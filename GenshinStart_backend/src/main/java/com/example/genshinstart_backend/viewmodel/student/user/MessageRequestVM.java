package com.example.genshinstart_backend.viewmodel.student.user;

import com.example.genshinstart_backend.base.BasePage;

public class MessageRequestVM extends BasePage {

    private Integer receiveUserId;

    public Integer getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Integer receiveUserId) {
        this.receiveUserId = receiveUserId;
    }
}
