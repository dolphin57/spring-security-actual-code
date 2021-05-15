package io.dolphin.security.app.pojo;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 自定义一个TokenEnhancer，在生成JWT时加入一些扩展信息
 * @Author: dolphin
 * @Since: 2021-5-15 11:37
 */
public class DolphinJwtTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        //在jwt里加入一个company信息
        Map<String, Object> info = new HashMap<>();
        info.put("company", "NRSC");

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
