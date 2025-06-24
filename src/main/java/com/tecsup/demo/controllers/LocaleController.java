package com.tecsup.demo.controllers;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocaleController {
    @GetMapping("/locale")
    public String locale(HttpServletRequest req) {
        String lastUrl = req.getHeader("referer");
        return "redirect:".concat(lastUrl);
    }
}
