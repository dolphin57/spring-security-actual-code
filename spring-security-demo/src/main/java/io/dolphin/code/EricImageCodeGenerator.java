package io.dolphin.code;

import io.dolphin.security.core.validate.code.image.ImageCode;
import io.dolphin.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author Eric
 * @create 2019 07 28 17:50
 */
//@Component("imageCodeGenerator")
public class EricImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更高级的图形验证码生成");
        return null;
    }
}
