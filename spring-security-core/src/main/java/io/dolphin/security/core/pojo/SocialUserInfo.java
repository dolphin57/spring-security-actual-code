package io.dolphin.security.core.pojo;

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

    private String nickName;

    private String headImg;
}
