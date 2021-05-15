package io.dolphin.security.core.enums;

/**
 * @Description: 处理成功和处理失败可以有不同的方式,这里做个简单处理,要么都为REDIRECT,要么都为JSON
 * @Author: dolphin
 * @Since: 2021-5-15 12:14
 */
public enum LoginType {
    /**
     * 返回标记
     * 表示按照spring-security默认方式即:登录成功后会跳转到引发登录的请求上
     */
    REDIRECT,

    /**
     * 返回标记
     * 表示登陆成功,返回json字符串
     */
    JSON
}
