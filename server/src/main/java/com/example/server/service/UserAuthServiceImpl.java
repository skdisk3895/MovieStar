package com.example.server.service;

import com.example.server.mapper.UserProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl implements UserAuthService{

    @Autowired
    UserProfileMapper userProfileMapper;

    @Override
    public int idCheck(String username) throws Exception {
        return userProfileMapper.idCheck(username);
    }
}
