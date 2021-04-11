package io.dolphin.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Eric
 * @create 2019 07 27 18:30
 */
public class ValidateCodeException extends AuthenticationException {
    private static final long serialVersionUID = 3911793971271521192L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
