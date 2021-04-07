package io.dolphin.security.brower.support;

import lombok.Data;

/**
 * @author Eric
 * @create 2019 07 24 22:15
 */
@Data
public class SimpleResponse {
    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }
}
