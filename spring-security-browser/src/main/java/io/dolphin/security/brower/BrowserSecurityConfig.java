package io.dolphin.security.brower;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Eric
 * @create 2019 07 21 22:36
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http// 表单登录
            .formLogin()
            .and()
            // 授权配置
            .authorizeRequests()
            // 任何请求
            .anyRequest()
            // 都需要身份认证
            .authenticated();
    }
}