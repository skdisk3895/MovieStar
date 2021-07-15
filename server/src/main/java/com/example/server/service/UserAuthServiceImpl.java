package com.example.server.service;

import com.example.server.mapper.UserProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Service
public class UserAuthServiceImpl implements UserAuthService{

    @Autowired
    UserProfileMapper userProfileMapper;

    @Override
    public int idCheck(String username) throws Exception {
        return userProfileMapper.idCheck(username);
    }

    @Override
    public int emailCheck(String email) throws Exception {
        return userProfileMapper.emailCheck(email);
    }

    @Override
    public int searchUser(String username, String inputPass) throws Exception {
        Map<String, String> result = userProfileMapper.searchUser(username);
        System.out.println(result);
        if (result == null)
            return -1;
        else {
            String password = result.get("password");
            String salt = result.get("salt");
            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            md.update(salt.getBytes());
            md.update(inputPass.getBytes());
            if (!String.format("%064x", new BigInteger(1, md.digest())).equals(password))
                return -2;
            return 0;
        }
    }
}
