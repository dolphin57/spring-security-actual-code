package io.dolphin.security.brower;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author Eric
 * @create 2019 07 22 21:58
 */
@Component
@Slf4j
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("登陆用户名:" + username);
        // 根据用户名查找用户信息
        // 根据查找到的用户信息判断用户是否被冻结
        String password = passwordEncoder.encode("123456");
        log.info("数据库密码:"+password);
        return new User(username, password,
                true, true, true, false,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
