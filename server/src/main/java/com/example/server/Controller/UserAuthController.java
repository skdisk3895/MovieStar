package com.example.server.Controller;

import com.example.server.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserAuthController {

    @Autowired
    UserAuthService userAuthService;

    @PostMapping("/api/register")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email, @RequestParam("salt") String salt) throws Exception {
        System.out.println("아이디 : " + username);
        int result = userAuthService.idCheck(username);
        System.out.println("결과값 : " + result);
        if (result != 0)
            return "fail";
        else
            return "success";
    }
}
