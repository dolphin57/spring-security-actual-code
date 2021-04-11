package io.dolphin.security.brower;

import io.dolphin.security.core.properties.SecurityProperties;
import io.dolphin.security.core.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Eric
 * @create 2019 07 21 22:36
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler dolphinAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler dolphinAuthenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(dolphinAuthenticationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        // 在usernamePassword过滤器前加入验证码过滤器
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
            // 表单登录
            .formLogin()
            // 登录页面
            .loginPage("/authentication/require")
            // 让UsernamePasswordAuthenticationFilter去处理此路径
            .loginProcessingUrl("/authentication/form")
            // 成功处理器
            .successHandler(dolphinAuthenticationSuccessHandler)
            // 失败处理器
            .failureHandler(dolphinAuthenticationFailureHandler)
            .and()
            // 授权配置
            .authorizeRequests()
            // 匹配器去匹配页面就允许通过
            .antMatchers("/authentication/require",
                    securityProperties.getBrowser().getLoginPage(),
                    "/code/image").permitAll()
            // 任何请求
            .anyRequest()
            // 都需要身份认证
            .authenticated()
            // 去掉跨域请求防护
            .and().csrf().disable();
    }
}
