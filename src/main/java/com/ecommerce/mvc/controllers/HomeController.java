package com.ecommerce.mvc.controllers;

import com.ecommerce.mvc.services.ChatBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private ChatBotService chatBotService;

    @GetMapping("/")
    public String home(){

        return "home";
    }

    @PostMapping("/")
    public String home(String message){
        chatBotService.chatBot(message);
        return "home";
    }

}
