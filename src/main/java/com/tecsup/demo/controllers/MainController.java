package com.tecsup.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String inicio(Model model) {
        return "inicio";
    }

    @GetMapping("/lista")
    public String listar(Model model) {
        return "lista";
    }

    @GetMapping("/docente")
    public String docente(Model model) {
        return "docente";
    }
}
