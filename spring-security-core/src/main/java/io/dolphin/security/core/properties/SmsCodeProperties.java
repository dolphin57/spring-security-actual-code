package io.dolphin.security.core.properties;

import lombok.Data;

/**
 * @author Eric
 * @create 2019 07 28 11:24
 */
@Data
public class SmsCodeProperties {
    private int length = 6;
    private int expireIn = 60;

    private String url;
}
