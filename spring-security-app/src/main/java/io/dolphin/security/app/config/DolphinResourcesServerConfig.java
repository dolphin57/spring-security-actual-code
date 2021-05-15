package io.dolphin.security.app.config;

import io.dolphin.security.app.social.openid.OpenIdAuthenticationSecurityConfig;
import io.dolphin.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import io.dolphin.security.core.constants.SecurityConstants;
import io.dolphin.security.core.properties.DolphinSecurityProperties;
import io.dolphin.security.core.validate.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @Description:
 * @Author: dolphin
 * @Since: 2021-5-15 11:03
 */
@Configuration
@EnableResourceServer
public class DolphinResourcesServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    protected AuthenticationSuccessHandler dolphinAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler dolphinAuthenticationFailureHandler;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    //openId校验配置类
    @Autowired
    private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;

    @Autowired
    private SpringSocialConfigurer dolphinSocialSecurityConfig;

    @Autowired
    private DolphinSecurityProperties dolphinSecurityProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(dolphinAuthenticationSuccessHandler)
                .failureHandler(dolphinAuthenticationFailureHandler);

        //将验证码校验逻辑放开
        http.apply(validateCodeSecurityConfig)
                .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                .apply(dolphinSocialSecurityConfig)
                .and()
                .apply(openIdAuthenticationSecurityConfig)
                .and()
                .authorizeRequests()
                .antMatchers(
                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_OPENID,
                        dolphinSecurityProperties.getBrowser().getLoginPage(),
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*",
                        dolphinSecurityProperties.getBrowser().getSignUpUrl(),
                        dolphinSecurityProperties.getBrowser().getSession().getSessionInvalidUrl(),
                        dolphinSecurityProperties.getBrowser().getSignOutUrl(),
                        "/user/register","/social/signUp")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }
}
