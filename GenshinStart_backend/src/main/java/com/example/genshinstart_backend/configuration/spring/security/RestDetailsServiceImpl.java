package com.example.genshinstart_backend.configuration.spring.security;

import com.example.genshinstart_backend.domain.enums.RoleEnum;
import com.example.genshinstart_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @version 1.0.0
 * @description: 验证通过之后,第二、三...请求，会调用此类
 * @author feixia0g
 * @date 2024/7/10 10:10
 */
@Component
public class RestDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    /**
     * Instantiates a new Rest details service.
     *
     * @param userService the user service
     */
    @Autowired
    public RestDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.example.genshinstart_backend.domain.User user = userService.getUserByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username  not found.");
        }

        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(RoleEnum.fromCode(user.getRole()).getRoleName()));

        return new User(user.getUserName(), user.getPassword(), grantedAuthorities);
    }
}

