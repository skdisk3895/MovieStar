package com.example.server.service;

public interface UserAuthService {

    public int idCheck(String username) throws Exception;
    public int emailCheck(String email) throws Exception;
    public int searchUser(String username, String inputPass) throws Exception;
}
