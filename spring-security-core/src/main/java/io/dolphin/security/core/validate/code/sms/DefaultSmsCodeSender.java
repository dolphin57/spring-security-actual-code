package io.dolphin.security.core.validate.code.sms;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2021-4-13 7:29
 */
@Slf4j
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        log.info("向手机 {} 发送验证码: {}", mobile, code);
    }
}
