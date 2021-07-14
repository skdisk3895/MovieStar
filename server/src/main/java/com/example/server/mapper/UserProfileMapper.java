package com.example.server.mapper;

import com.example.server.model.UserProfile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserProfileMapper {

    @Select("SELECT * FROM user")
    List<UserProfile> getAllUserProfile();
}
