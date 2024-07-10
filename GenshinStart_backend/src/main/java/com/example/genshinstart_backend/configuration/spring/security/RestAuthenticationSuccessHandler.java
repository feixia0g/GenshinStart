package com.example.genshinstart_backend.configuration.spring.security;

import com.example.genshinstart_backend.base.SystemCode;
import com.example.genshinstart_backend.domain.UserEventLog;
import com.example.genshinstart_backend.event.UserEvent;
import com.example.genshinstart_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @version 1.0.0
 * @description: 登录成功返回
 * @author feixia0g
 * @date 2024/7/10 10:15
 */
@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final ApplicationEventPublisher eventPublisher;
    private final UserService userService;

    /**
     * Instantiates a new Rest authentication success handler.
     *
     * @param eventPublisher the event publisher
     * @param userService    the user service
     */
    @Autowired
    public RestAuthenticationSuccessHandler(ApplicationEventPublisher eventPublisher, UserService userService) {
        this.eventPublisher = eventPublisher;
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Object object = authentication.getPrincipal();
        if (null != object) {
            User springUser = (User) object;
            com.example.genshinstart_backend.domain.User user = userService.getUserByUserName(springUser.getUsername());
            if (null != user) {
                UserEventLog userEventLog = new UserEventLog(user.getId(), user.getUserName(), user.getRealName(), new Date());
                userEventLog.setContent(user.getUserName() + " 登录了在线考试平台系统");
                eventPublisher.publishEvent(new UserEvent(userEventLog));
                com.example.genshinstart_backend.domain.User newUser = new com.example.genshinstart_backend.domain.User();
                newUser.setUserName(user.getUserName());
                newUser.setImagePath(user.getImagePath());
                RestUtil.response(response, SystemCode.OK.getCode(), SystemCode.OK.getMessage(), newUser);
            }
        } else {
            RestUtil.response(response, SystemCode.UNAUTHORIZED.getCode(), SystemCode.UNAUTHORIZED.getMessage());
        }
    }
}

