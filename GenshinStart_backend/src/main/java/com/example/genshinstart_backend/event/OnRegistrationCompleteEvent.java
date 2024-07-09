package com.example.genshinstart_backend.event;

import com.example.genshinstart_backend.domain.User;
import org.springframework.context.ApplicationEvent;

/**
 * @version 1.0.0
 * @description: The type On registration complete event.
 * @author feixia0g
 * @date 2024/7/9 20:25
 */
public class OnRegistrationCompleteEvent extends ApplicationEvent {


    private final User user;


    /**
     * Instantiates a new On registration complete event.
     *
     * @param user the user
     */
    public OnRegistrationCompleteEvent(final User user) {
        super(user);
        this.user = user;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

}
