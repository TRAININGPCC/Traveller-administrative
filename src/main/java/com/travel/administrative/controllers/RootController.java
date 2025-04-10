package com.travel.administrative.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RootController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @PostMapping("/process-uApi")
    public String uApiProcess(  @RequestParam("username") String username,
                                @RequestParam("password") String password,
                                @RequestParam("targetBranch") String targetBranch,
                                @RequestParam("url") String url,
                                @RequestParam("gdsCode") String gdsCode){


        System.out.println(username);
        System.out.println(password);
        System.out.println(targetBranch);
        System.out.println(url);
        System.out.println(gdsCode);
        return "index";
    }


    @GetMapping("/galileo-web-services")
    public String galileoWebServices(){
        return "webservices";
    }

    @PostMapping("/process-galileo-web-services")
    public String processGalileoWebServices(
            @RequestParam("hostName") String hostName,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("url") String url,
            @RequestParam("session") String session
    ) {
        System.out.println("Host Name: " + hostName);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("URL: " + url);
        System.out.println("Session: " + session);

        return "webservices";
    }
}
