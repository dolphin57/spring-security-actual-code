package io.dolphin.security.core.social.qq.config;

import io.dolphin.security.core.properties.QQProperties;
import io.dolphin.security.core.properties.DolphinSecurityProperties;
import io.dolphin.security.core.social.config.SocialAutoConfigurerAdapter;
import io.dolphin.security.core.social.qq.connect.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 * @Description:
 * @Author: dolphin
 * @Since: 2021-4-25 8:14
 */
@Configuration
@ConditionalOnProperty(prefix = "dolphin.security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {
    @Autowired
    private DolphinSecurityProperties dolphinSecurityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qqProperties = dolphinSecurityProperties.getSocial().getQq();
        return new QQConnectionFactory(qqProperties.getProviderId(), qqProperties.getAppId(), qqProperties.getAppSecret());
    }
}
