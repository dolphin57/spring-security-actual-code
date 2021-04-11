package io.dolphin.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Eric
 * @create 2019 07 24 22:23
 */
@Data
@ConfigurationProperties(prefix = "dolphin.security")
public class SecurityProperties {
    private BrowserProperties browser = new BrowserProperties();
    private ValidateCodeProperties code = new ValidateCodeProperties();
}
