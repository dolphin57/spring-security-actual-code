package io.dolphin.security.brower;

import io.dolphin.security.core.authentication.AbstractChannelSecurityConfig;
import io.dolphin.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import io.dolphin.security.core.constants.SecurityConstants;
import io.dolphin.security.core.properties.DolphinSecurityProperties;
import io.dolphin.security.core.validate.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * @author Eric
 * @create 2019 07 21 22:36
 */
@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {
    @Autowired
    private DolphinSecurityProperties dolphinSecurityProperties;

    @Autowired
    private DataSource dataSource;

    @Qualifier("myUserDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private SpringSocialConfigurer dolphinSocialSecurityConfig;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;

    @Autowired
    private InvalidSessionStrategy invalidSessionStrategy;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        // ????????????????????????create table??????
        //tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        applyPasswordAuthenticationConfig(http);

        http.apply(validateCodeSecurityConfig)
            .and()
            .apply(smsCodeAuthenticationSecurityConfig)
            .and()
            // ???????????????????????????????????????????????????
            .apply(dolphinSocialSecurityConfig)
            .and()
            // ???????????????
            .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(dolphinSecurityProperties.getBrowser().getRememberMeSecond())
                .userDetailsService(userDetailsService)
                .and()
            // session??????
            .sessionManagement()
                .invalidSessionStrategy(invalidSessionStrategy)
                .maximumSessions(dolphinSecurityProperties.getBrowser().getSession().getMaximumSessions())
                .maxSessionsPreventsLogin(dolphinSecurityProperties.getBrowser().getSession().isMaxSessionsPreventsLogin())
                .expiredSessionStrategy(sessionInformationExpiredStrategy)
                .and()
                .and()
            .logout()
                .logoutUrl("/signOut")
                .logoutSuccessUrl("/eric-logout.html")
                .deleteCookies("JSESSIONID")
                .and()
            // ????????????
            .authorizeRequests()
                // ???????????????????????????????????????
                .antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        dolphinSecurityProperties.getBrowser().getLoginPage(),
                        dolphinSecurityProperties.getBrowser().getSignUpUrl(),
                        dolphinSecurityProperties.getBrowser().getSignOutUrl(),
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                        "/user/regist", "/session/invalid")
                        .permitAll()
                // ????????????
                .anyRequest()
                // ?????????????????????
                .authenticated()
                // ????????????????????????
                .and()
            .csrf().disable();
    }
}
