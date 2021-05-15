package io.dolphin.security.core.validate.code;

import io.dolphin.security.core.properties.DolphinSecurityProperties;
import io.dolphin.security.core.validate.code.image.ImageCodeGenerator;
import io.dolphin.security.core.validate.code.sms.DefaultSmsCodeSender;
import io.dolphin.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Eric
 * @create 2019 07 28 17:45
 */
@Configuration
public class ValidateCodeBeanConfig {
    @Autowired
    private DolphinSecurityProperties dolphinSecurityProperties;

    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setDolphinSecurityProperties(dolphinSecurityProperties);
        return codeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }
}
