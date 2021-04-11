package io.dolphin.security.core.properties;

import lombok.Data;

/**
 * @author Eric
 * @create 2019 07 28 11:24
 */
@Data
public class ImageCodeProperties {
    private int width = 67;
    private int height = 23;
    private int length = 4;
    private int expireIn = 60;

    private String url;
}
