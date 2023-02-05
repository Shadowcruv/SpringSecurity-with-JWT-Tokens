package com.eonAcademy.demy2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogInPlace {

    @GetMapping("/login")
    public String loginPage(){
        return "signIn";
    }
}
