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
        int usernameCheckResult = userAuthService.idCheck(username);
        int emailCheckResult = userAuthService.emailCheck(email);

        if (usernameCheckResult != 0)
            return "username error";
        else if (emailCheckResult != 0)
            return "email error";
        else
            return "success";
    }

    @PostMapping("/api/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String inputPass) throws Exception {
        int idCheckResult = userAuthService.searchUser(username, inputPass);
        switch(idCheckResult) {
            case -1:
                return "Not found id";
            case -2:
                return "Wrong password";
            default:
                return "Success";
        }
    }
}
