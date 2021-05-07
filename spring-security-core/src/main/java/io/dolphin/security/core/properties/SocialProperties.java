package io.dolphin.security.core.properties;

import lombok.Data;

/**
 * @Description:
 * @Author: dolphin
 * @Since: 2021-4-25 8:06
 */
@Data
public class SocialProperties {
    private String filterProcessesUrl = "/auth";

    private QQProperties qq = new QQProperties();
    private WeixinProperties weixin = new WeixinProperties();
}
