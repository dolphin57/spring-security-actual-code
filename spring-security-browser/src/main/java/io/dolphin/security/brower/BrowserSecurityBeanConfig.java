package io.dolphin.security.brower;

import io.dolphin.security.brower.logout.DolphinLogoutSuccessHandler;
import io.dolphin.security.brower.session.DolphinExpiredSessionStrategy;
import io.dolphin.security.brower.session.DolphinInvalidSessionStrategy;
import io.dolphin.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * @Description:
 * @Author: dolphin
 * @Since: 2021-5-8 17:16
 */
@Configuration
public class BrowserSecurityBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    //用户可以通过实现一个InvalidSessionStrategy类型的bean来覆盖掉默认的实现--》NRSCInvalidSessionStrategy
    @ConditionalOnMissingBean(InvalidSessionStrategy.class)
    public InvalidSessionStrategy invalidSessionStrategy(){
        return new DolphinInvalidSessionStrategy(securityProperties.getBrowser().getSession().getSessionInvalidUrl());
    }

    @Bean
    @ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
    public SessionInformationExpiredStrategy sessionInformationExpiredStrategy(){
        return new DolphinExpiredSessionStrategy(securityProperties.getBrowser().getSession().getSessionInvalidUrl());
    }

    @Bean
    @ConditionalOnMissingBean(LogoutSuccessHandler.class)
    public LogoutSuccessHandler logoutSuccessHandler(){
        return new DolphinLogoutSuccessHandler(securityProperties.getBrowser().getSignOutUrl());
    }
}