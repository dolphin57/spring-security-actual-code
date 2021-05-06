package io.dolphin.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @Description:
 * @Author: dolphin
 * @Since: 2021-5-5 17:08
 */
public class DolphinSpringSocialConfigurer extends SpringSocialConfigurer {
    private String filterProcessesUrl;

    public DolphinSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    /**
     *
     * @param object：实际要放到过滤器链上的filter
     * @param <T>
     * @return
     */
    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        return (T) filter;
    }
}
