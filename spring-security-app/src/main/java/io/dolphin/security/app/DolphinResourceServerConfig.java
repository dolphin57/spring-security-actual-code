package io.dolphin.security.app;

import io.dolphin.security.app.authentication.DolphinAuthenticationFailureHandler;
import io.dolphin.security.app.authentication.DolphinAuthenticationSuccessHandler;
import io.dolphin.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import io.dolphin.security.core.properties.SecurityConstants;
import io.dolphin.security.core.properties.SecurityProperties;
import io.dolphin.security.core.validate.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @Description:
 * @Author: dolphin
 * @Since: 2021-5-9 18:35
 */
@Configuration
@EnableResourceServer
public class DolphinResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private DolphinAuthenticationSuccessHandler dolphinAuthenticationSuccessHandler;

    @Autowired
    private DolphinAuthenticationFailureHandler dolphinAuthenticationFailureHandler;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private SpringSocialConfigurer dolphinSocialSecurityConfig;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(dolphinAuthenticationSuccessHandler)
                .failureHandler(dolphinAuthenticationFailureHandler);

        http.apply(validateCodeSecurityConfig)
                .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                // 往过滤器链上加过滤器，拦截特定请求
                .apply(dolphinSocialSecurityConfig)
                .and()
                // 授权配置
                .authorizeRequests()
                // 匹配器去匹配页面就允许通过
                .antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        securityProperties.getBrowser().getLoginPage(),
                        securityProperties.getBrowser().getSignUpUrl(),
                        securityProperties.getBrowser().getSignOutUrl(),
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                        "/user/regist", "/session/invalid")
                .permitAll()
                // 任何请求
                .anyRequest()
                // 都需要身份认证
                .authenticated()
                // 去掉跨域请求防护
                .and()
                .csrf().disable();
    }
}
