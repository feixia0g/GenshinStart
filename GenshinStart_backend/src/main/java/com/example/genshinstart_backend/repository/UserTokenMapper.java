package com.example.genshinstart_backend.repository;

import com.example.genshinstart_backend.domain.UserToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserTokenMapper extends BaseMapper<UserToken> {

    UserToken getToken(String token);

}
