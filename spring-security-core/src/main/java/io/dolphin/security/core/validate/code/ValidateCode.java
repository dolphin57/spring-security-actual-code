package io.dolphin.security.core.validate.code;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Eric
 * @create 2019 07 27 17:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidateCode implements Serializable {
    private final static long serialVersionUID = 1588203828504660915L;

    private String code;
    private LocalDateTime expireTime;

    public ValidateCode(String code, int expireInt) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireInt);
    }

    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
