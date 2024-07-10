package com.example.genshinstart_backend.configuration.spring.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import javax.servlet.http.HttpServletRequest;

/**
 * @version 3.5.0
 * @description: 记住我，Cookie
 * @author feixia0g
 * @date 2024/7/10 9:50
 */
public class RestTokenBasedRememberMeServices extends TokenBasedRememberMeServices {
    /**
     * Instantiates a new Rest token based remember me services.
     *
     * @param key                the key
     * @param userDetailsService the user details service
     */
    public RestTokenBasedRememberMeServices(String key, UserDetailsService userDetailsService) {
        super(key, userDetailsService);
    }

    @Override
    protected boolean rememberMeRequested(HttpServletRequest request, String parameter) {
        return (boolean) request.getAttribute(DEFAULT_PARAMETER);
    }

}

