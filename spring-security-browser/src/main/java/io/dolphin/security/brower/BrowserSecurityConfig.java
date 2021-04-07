package io.dolphin.security.brower;

import io.dolphin.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Eric
 * @create 2019 07 21 22:36
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http// 表单登录
            .formLogin()
            // 登录页面
            .loginPage("/authentication/require")
            // 让UsernamePasswordAuthenticationFilter去处理此路径
            .loginProcessingUrl("/authentication/form")
            .and()
            // 授权配置
            .authorizeRequests()
            // 匹配器去匹配页面就允许通过
            .antMatchers("/authentication/require",
                    securityProperties.getBrowser().getLoginPage()).permitAll()
            // 任何请求
            .anyRequest()
            // 都需要身份认证
            .authenticated()
            // 去掉跨域请求防护
            .and().csrf().disable();
    }
}
