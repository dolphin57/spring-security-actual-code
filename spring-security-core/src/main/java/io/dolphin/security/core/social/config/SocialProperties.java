package io.dolphin.security.core.social.config;

/**
 * @Description:
 * @Author: dolphin
 * @Since: 2021-4-30 7:47
 */
public class SocialProperties {
    /**
     * Application id.
     */
    private String appId;

    /**
     * Application secret.
     */
    private String appSecret;

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return this.appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}
