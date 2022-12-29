package com.ecommerce.mvc.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;


@Controller
@RequestMapping(value = "/chat")
public class ChatBotController {

    @GetMapping("")
    public String home(){
        return "chat";
    }

    @PostMapping(value = "" , consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String home(@RequestParam Map<String,String> text){
        System.out.println(text.get("messageText"));
        return text.get("messageText");
    }

}
