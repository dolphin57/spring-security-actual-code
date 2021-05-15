//package io.dolphin.security.brower.authentication;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.dolphin.security.core.properties.LoginType;
//import io.dolphin.security.core.properties.SecurityProperties;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author Eric
// * @create 2019 07 24 23:05
// */
//@Slf4j
//@Component("dolphinAuthenticationSuccessHandler")
//public class DolphinAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private SecurityProperties securityProperties;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                        Authentication authentication) throws IOException, ServletException {
//        log.info("登录成功");
//        // authentication以json返回给前台
//        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
//            response.setContentType("application/json;charset=UTF-8");
//            response.getWriter().write(objectMapper.writeValueAsString(authentication));
//        } else {
//            super.onAuthenticationSuccess(request, response, authentication);
//        }
//    }
//}
