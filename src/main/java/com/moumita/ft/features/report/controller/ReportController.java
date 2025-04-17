package com.moumita.ft.features.report.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {



    @GetMapping("/")
    public String index() {
        return "index";  
    }

//    @GetMapping("/dashboard")
//    public String dashboard(Model model) {
//        model.addAttribute("username", "John");
//        return "dashboard";  // will render templates/dashboard.html
//    }
}

