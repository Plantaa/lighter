package com.planta.lighter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "plain-login";
    }

    @GetMapping("showMyFancyLoginPage")
    public String showMyFancyLoginPage() {
        return "fancy-login";
    }

    @GetMapping("/showAccessDeniedPage")
    public String showAccessDenied() {
        return "access-denied";
    }
}
