package com.example.server.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieAPIController {

    @GetMapping("/api/kobis")
    public String requestKobis() {
        String kobisURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList..json?key=5b839e4245168cdca8e9c3aabc826188&targetDt=20210715";
        return "success";
    }
}
