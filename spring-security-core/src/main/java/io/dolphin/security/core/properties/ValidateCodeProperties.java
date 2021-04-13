package io.dolphin.security.core.properties;

import lombok.Data;

/**
 * 默认配置
 * @author Eric
 * @create 2019 07 28 11:26
 */
@Data
public class ValidateCodeProperties {
    private ImageCodeProperties image = new ImageCodeProperties();
    private SmsCodeProperties sms = new SmsCodeProperties();
}
