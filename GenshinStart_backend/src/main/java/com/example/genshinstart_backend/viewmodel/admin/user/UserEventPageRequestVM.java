package com.example.genshinstart_backend.viewmodel.admin.user;

import com.example.genshinstart_backend.base.BasePage;

public class UserEventPageRequestVM extends BasePage {
    private Integer userId;

    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
