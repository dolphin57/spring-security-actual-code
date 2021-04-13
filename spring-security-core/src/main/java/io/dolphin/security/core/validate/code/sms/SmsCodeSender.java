package io.dolphin.security.core.validate.code.sms;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2021-4-13 7:26
 */
public interface SmsCodeSender {
    void send(String mobile, String code);
}
