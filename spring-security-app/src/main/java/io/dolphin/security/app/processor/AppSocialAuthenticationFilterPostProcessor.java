package io.dolphin.security.app.processor;

import io.dolphin.security.core.social.SocialAuthenticationFilterPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @Description: 设置app下springsocial走的成功处理器
 * @Author: dolphin
 * @Since: 2021-5-15 11:38
 */
@Component
public class AppSocialAuthenticationFilterPostProcessor implements SocialAuthenticationFilterPostProcessor {
    //认证成功后返回token的成功处理器
    @Autowired
    private AuthenticationSuccessHandler dolphinAuthenticationSuccessHandler;

    @Override
    public void process(SocialAuthenticationFilter socialAuthenticationFilter) {
        socialAuthenticationFilter.setAuthenticationSuccessHandler(dolphinAuthenticationSuccessHandler);
    }
}
