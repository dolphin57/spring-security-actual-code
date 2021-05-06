package io.dolphin.security.brower.support;

import lombok.Data;

/**
 * @Description:
 * @Author: dolphin
 * @Since: 2021-5-6 7:55
 */
@Data
public class SocialUserInfo {
    private String providerId;

    private String providerUserId;

    private String nickname;

    private String headimg;
}
