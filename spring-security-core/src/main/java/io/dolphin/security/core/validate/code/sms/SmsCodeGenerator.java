package io.dolphin.security.core.validate.code.sms;

import io.dolphin.security.core.properties.DolphinSecurityProperties;
import io.dolphin.security.core.validate.code.ValidateCode;
import io.dolphin.security.core.validate.code.ValidateCodeGenerator;
import lombok.Data;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author Eric
 * @create 2019 07 28 17:41
 */
@Data
@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private DolphinSecurityProperties dolphinSecurityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(dolphinSecurityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, dolphinSecurityProperties.getCode().getSms().getExpireIn());
    }
}
