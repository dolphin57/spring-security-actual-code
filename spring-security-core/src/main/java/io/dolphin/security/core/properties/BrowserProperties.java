package io.dolphin.security.core.properties;

import lombok.Data;

import static io.dolphin.security.core.properties.LoginType.JSON;

/**
 * @author Eric
 * @create 2019 07 24 22:37
 */
@Data
public class BrowserProperties {
    private String signUpUrl = "/eric-signUp.html";
    private String signOutUrl = "/eric-signOut.html";
    private String loginPage = "/eric-signIn.html";
    private LoginType loginType = JSON;
    private int rememberMeSecond = 3600;

    private SessionProperties session = new SessionProperties();
}
