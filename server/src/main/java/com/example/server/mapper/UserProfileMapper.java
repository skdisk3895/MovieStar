package com.example.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserProfileMapper {
//    @Select("INSERT INTO users VALUES((SELECT COUNT(*) FROM users self), #{username}, #{password}, #{email}, #{salt})")
//    public void register(@Param("username") String username, @Param("password") String password, @Param("email") String email, @Param("salt") String salt);

    // 아이디 중복 검사
    public int idCheck(String username);

    // 이메일 중복 검사
    public int emailCheck(String email);

    // 아이디 존재 여부 검사
    public Map<String, String> searchUser(String username);
}
