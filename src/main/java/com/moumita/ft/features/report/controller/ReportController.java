package com.moumita.ft.features.report.controller;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.moumita.ft.features.report.model.Report;
import com.moumita.ft.features.report.service.ReportService;

@Controller
public class ReportController {

	@Autowired
    private ReportService reportService;

    @GetMapping("/{userId}")
    public String index(@PathVariable int userId,Model model) {
    	LocalDate now = LocalDate.now();
        String month = now.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        int year = now.getYear();
    	Report report = reportService.generateReport(userId, month);
        model.addAttribute("report", report);
        model.addAttribute("comments",reportService.comment(report.getInvestedPercentage(),report.getExpensePercentage(),report.getSavingsPercentage()));
        
        model.addAttribute("investment", reportService.isInvestmentConsistent(userId,month));
        return "index";  
    }

//    @GetMapping("/dashboard")
//    public String dashboard(Model model) {
//        model.addAttribute("username", "John");
//        return "dashboard";  // will render templates/dashboard.html
//    }
}

