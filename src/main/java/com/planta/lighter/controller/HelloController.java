package com.planta.lighter.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    
    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("date", LocalDateTime.now());
        return "helloworld";
    }
}
