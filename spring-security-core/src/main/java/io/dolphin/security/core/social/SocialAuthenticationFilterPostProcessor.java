package io.dolphin.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * @Description: 指定springsocial成功处理器的接口
 * @Author: dolphin
 * @Since: 2021-5-15 11:41
 */
public interface SocialAuthenticationFilterPostProcessor {
    /**
     * 参数为springsocial的过滤器
     * @param socialAuthenticationFilter
     */
    void process(SocialAuthenticationFilter socialAuthenticationFilter);
}
