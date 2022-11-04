package com.ecommerce.mvc.controllers;

import org.alicebot.ab.Chat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.alicebot.ab.Bot;

@Controller
@RequestMapping(value = "/aiml")
public class AimlController {

    @GetMapping("")
    public String home(){
        return "aiml";
    }

}
