package io.dolphin.security.core.social.config;

import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;

/**
 * @Description: 从springboot1.5.6.RELEASE版本的org.springframework.boot.autoconfigure.social下拷贝的源码
 * @Author: dolphin
 * @Since: 2021-4-30 7:45
 */
public abstract class SocialAutoConfigurerAdapter extends SocialConfigurerAdapter {

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer configurer,
                                       Environment environment) {
        configurer.addConnectionFactory(createConnectionFactory());
    }

    protected abstract ConnectionFactory<?> createConnectionFactory();

}
