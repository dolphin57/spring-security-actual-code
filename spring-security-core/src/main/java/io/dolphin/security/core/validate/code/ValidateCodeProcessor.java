package io.dolphin.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Description: 校验码处理器，封装不同校验码的处理逻辑
 * @Author: Eric Liang
 * @Since: 2021-4-13 8:09
 */
public interface ValidateCodeProcessor {
    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建校验码
     * ServletWebRequest是request和response的封装，后面可以用一个
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     *
     * @param servletWebRequest
     * @throws Exception
     */
    void validate(ServletWebRequest servletWebRequest);
}
