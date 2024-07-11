package com.example.genshinstart_backend.listener;

import com.example.genshinstart_backend.domain.User;
import com.example.genshinstart_backend.event.OnRegistrationCompleteEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;


/**
 * @version 1.1.0
 * @description: The type Email send listener.
 * @author kodi
 * @date 2024/7/9 14:30
 */
@Component
public class EmailSendListener implements ApplicationListener<OnRegistrationCompleteEvent> {

    @Override
    @NonNull
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        User user = event.getUser();
        System.out.println("User register Email sender :" + user.getUserName());
    }
}
