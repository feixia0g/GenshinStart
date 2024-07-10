package com.example.genshinstart_backend.event;

import com.example.genshinstart_backend.domain.UserEventLog;
import org.springframework.context.ApplicationEvent;

/**
 * @version 1.0.0
 * @description: The type User event.
 * @author feixia0g
 * @date 2024/7/10 10:15
 */
public class UserEvent extends ApplicationEvent {

    private final UserEventLog userEventLog;

    /**
     * Instantiates a new User event.
     *
     * @param userEventLog the user event log
     */
    public UserEvent(final UserEventLog userEventLog) {
        super(userEventLog);
        this.userEventLog = userEventLog;
    }

    /**
     * Gets user event log.
     *
     * @return the user event log
     */
    public UserEventLog getUserEventLog() {
        return userEventLog;
    }
}

