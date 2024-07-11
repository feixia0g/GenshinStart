package com.example.genshinstart_backend.controller.wx;

import com.example.genshinstart_backend.context.WxContext;
import com.example.genshinstart_backend.domain.User;
import com.example.genshinstart_backend.domain.UserToken;
import com.example.genshinstart_backend.utility.ModelMapperSingle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseWXApiController {
    protected final static ModelMapper modelMapper = ModelMapperSingle.Instance();
    @Autowired
    private WxContext wxContext;

    protected User getCurrentUser() {
        return wxContext.getCurrentUser();
    }

    protected UserToken getUserToken() {
        return wxContext.getCurrentUserToken();
    }
}
