package io.dolphin.security.app.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dolphin.security.core.properties.DolphinSecurityProperties;
import io.dolphin.security.core.support.SimpleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Eric
 * @create 2019 07 26 22:21
 */
@Slf4j
@Component("dolphinAuthenticationFailureHandler")
public class DolphinAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DolphinSecurityProperties dolphinSecurityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("登录失败");

        if (LoginType.JSON.equals(dolphinSecurityProperties.getBrowser().getLoginType())) {
            // 修改状态码
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            // 设置返回内容的数据形式和编码格式
            response.setContentType("application/json;charset=UTF-8");
            // 将抓到的错误信息以json数据的形式进行返回
            response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse(exception.getMessage())));
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
