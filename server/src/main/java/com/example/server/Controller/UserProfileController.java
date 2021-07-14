package com.example.server.Controller;

import com.example.server.mapper.UserProfileMapper;
import com.example.server.model.UserProfile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserProfileController {

    private UserProfileMapper mapper;

    public UserProfileController(UserProfileMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/api/users")
    public List<UserProfile> getAllUserProfile() {
        return mapper.getAllUserProfile();
    }
}
