package io.dolphin.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author Eric
 * @create 2019 07 28 17:35
 */
public interface ValidateCodeGenerator {
    ValidateCode generate(ServletWebRequest request);
}
