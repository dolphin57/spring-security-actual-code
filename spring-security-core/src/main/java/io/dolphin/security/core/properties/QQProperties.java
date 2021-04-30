package io.dolphin.security.core.properties;

import lombok.Data;
import io.dolphin.security.core.social.config.SocialProperties;
/**
 * @Description:
 * @Author: dolphin
 * @Since: 2021-4-25 7:48
 */
@Data
public class QQProperties extends SocialProperties {
    private String providerId = "qq";
}
