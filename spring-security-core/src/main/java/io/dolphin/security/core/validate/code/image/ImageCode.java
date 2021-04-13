package io.dolphin.security.core.validate.code.image;

import io.dolphin.security.core.validate.code.ValidateCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author Eric
 * @create 2019 07 27 17:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageCode extends ValidateCode {
    private BufferedImage image;

    /**
     * @param image     根据随机数生成的图片
     * @param code      随机数
     * @param expireInt 有效时间（秒）
     */
    public ImageCode(BufferedImage image, String code, int expireInt) {
        this(image, code, LocalDateTime.now().plusSeconds(expireInt));
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireInt) {
        super(code, expireInt);
        this.image = image;
    }
}
