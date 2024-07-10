package com.example.genshinstart_backend.configuration.spring.security;

import com.example.genshinstart_backend.base.SystemCode;
import com.example.genshinstart_backend.domain.User;
import com.example.genshinstart_backend.domain.UserEventLog;
import com.example.genshinstart_backend.service.UserService;
import com.example.genshinstart_backend.event.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @version 1.0.0
 * @description: 用户登出
 * @author feixia0g
 * @date 2024/7/10 10:30
 */
@Component
public class RestLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    private final ApplicationEventPublisher eventPublisher;
    private final UserService userService;

    /**
     * Instantiates a new Rest logout success handler.
     *
     * @param eventPublisher the event publisher
     * @param userService    the user service
     */
    @Autowired
    public RestLogoutSuccessHandler(ApplicationEventPublisher eventPublisher, UserService userService) {
        this.eventPublisher = eventPublisher;
        this.userService = userService;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        if (null != springUser) {
            User user = userService.getUserByUserName(springUser.getUsername());
            UserEventLog userEventLog = new UserEventLog(user.getId(), user.getUserName(), user.getRealName(), new Date());
            userEventLog.setContent(user.getUserName() + " 登出了在线考试平台系统");
            eventPublisher.publishEvent(new UserEvent(userEventLog));
        }
        RestUtil.response(response, SystemCode.OK);
    }
}

