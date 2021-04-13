package io.dolphin.security.core.properties;

import lombok.Data;

/**
 * @author Eric
 * @create 2019 07 28 11:24
 */
@Data
public class ImageCodeProperties extends SmsCodeProperties {
    private int width = 67;
    private int height = 23;

    public ImageCodeProperties() {
        setLength(4);
    }
}
