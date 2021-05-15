package io.dolphin.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: "大盒子"类-----------------用于统一管理项目中所有由yml或properties文件传入的变量值
 * @author Eric
 * @create 2019 07 24 22:23
 */
@Data
@Component
@ConfigurationProperties(prefix = "dolphin.security")
public class SecurityProperties {

    /***封装浏览器相关的属性*/
    private BrowserProperties browser = new BrowserProperties();

    /***验证码相关的属性---可能包含图形验证码，短信验证码等，所以对其进行了又一次封装*/
    private ValidateCodeProperties code = new ValidateCodeProperties();

    /***springsocial相关的配置*/
    private DolphinSocialProperties social = new DolphinSocialProperties();

    /***认证服务器相关的配置*/
    private Oauth2ServerProperties oauth2 = new Oauth2ServerProperties();
}
