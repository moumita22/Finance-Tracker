package com.moumita.ft.features.report.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moumita.ft.features.expense.repository.ExpenseRepository;
import com.moumita.ft.features.investment.model.Investment;
import com.moumita.ft.features.investment.repository.Investmentrepository;
import com.moumita.ft.features.report.model.Report;
import com.moumita.ft.features.report.repository.ReportRepository;
import com.moumita.ft.features.savings.repository.SavingsRepository;
import com.moumita.ft.features.user.repository.SalaryRepository;

@Service
public class ReportService {
	
	@Autowired
	ReportRepository reportRepo;

	@Autowired
	ExpenseRepository expenseRepo;
	
	@Autowired
	SavingsRepository savingsRepo;
	
	@Autowired
	Investmentrepository investRepo;
	
	@Autowired
	SalaryRepository salaryRepo;

    public Report generateReport(int userId, String month) {
        
        long salary = salaryRepo.findByMonth(userId,month);
        long expenses = expenseRepo.findByMonth(userId,month);
        long savings = savingsRepo.findByMonth(userId,month);
        long invested = investRepo.findByMonth(userId,month);
        double investedPercentage = Math.round(((double)invested/salary)*100* 100.0)/ 100.0;
        double expensePercentage = Math.round(((double)expenses/salary)*100* 100.0)/ 100.0;
        double savingsPercentage = Math.round(((double)savings/salary)*100* 100.0)/ 100.0;
        
        int score = 0;

        // Investment score: 0 to 40
        score += Math.min((int) ((investedPercentage / 30.0) * 40), 40);

        // Savings score: 0 to 30
        score += Math.min((int) (((100-investedPercentage-expensePercentage) / 20.0) * 30), 30);

        // Expenses score: 0 to 30 (the less you spend, the better, up to 50%)
        // If expensesPercentage is more than 50%, score will be 0
        if (expensePercentage <= 50) {
            score += (int) (((50 - expensePercentage) / 50.0) * 30);
        }else {
            // If spending more than 50%, reduce score gradually down to 0 at 100%
            double overExpense = Math.min(expensePercentage, 100); // cap at 100%
            double reduction = ((100 - overExpense) / 50.0) * 30; // from 30 to 0 as expenses go from 50% to 100%
            score += Math.max((int) reduction, 0);
        }
        
//        YearMonth prevMonth =YearMonth.parse(month).minusMonths(1);
//        Report history = reportRepo.findByPrevMonth(userId,prevMonth);
//        double investmentGrowthPercentage = ((double)(invested - history.getTotalInvested()) / history.getTotalInvested()) * 100;
//        double expensesGrowthPercentage = ((double)(expenses - history.getTotalExpense()) / history.getTotalExpense()) * 100;
//        double savingsGrowthPercentage = ((double)(savings - history.getTotalSavings()) / history.getTotalSavings()) * 100;

        Report report = new Report();
        report.setUserId(userId);
        report.setMonth(month);
        report.setDate(LocalDateTime.now());
        report.setTotalExpense(expenses);
        report.setTotalSavings(savings);
        report.setTotalInvested(invested);
        report.setInvestedPercentage(investedPercentage);
        report.setExpensePercentage(expensePercentage);
        report.setSavingsPercentage(savingsPercentage);
//        report.setIncreasedInvestment(investmentGrowthPercentage);
//        report.setIncreasedExpence(expensesGrowthPercentage);
//        report.setIncreasedSavings(savingsGrowthPercentage);
        report.setScore(score);
        
        LocalDate today = LocalDate.now();
        if(today.getDayOfMonth() == today.lengthOfMonth()) {
        	reportRepo.save(report);
        }
        return report;
    }
    
    public Map<String, String> comment(double investedPercentage,double expensePercentage,double savingsPercentage){
    	Map<String, String> comments = new HashMap<>();
    	String comment;
    	if(investedPercentage >=28)
    		comment = "Great job! You're investing a strong portion of your income. 💪";
    	else if (investedPercentage >= 22) {
    		comment = "Good work! There's still room to grow your investments. 💰";
        } else if (investedPercentage >= 15) {
        	comment = "You're on the right track. Try to gradually increase your investments. ✅";
        } else if (investedPercentage > 0) {
        	comment = "Consider investing more to build long-term wealth.";
        } else {
        	comment = "Start investing to secure your financial future! ⚠️";
        }
    	
    	comments.put("Invested", comment);
    	
    	if (expensePercentage <= 40) {
    		comment = "Well done! You're keeping your expenses under control. 💰";
    	} else if (expensePercentage <= 50) {
    		comment = "You're doing okay, but try to cut unnecessary spending. ✅";
    	} else if (expensePercentage <= 60) {
    		comment = "Caution! A big chunk of your salary is going into expenses.";
    	} else {
    		comment = "Too high! Consider budgeting more carefully to avoid financial stress. ⚠️";
    	}
    	
    	comments.put("Expenses", comment);
    	
    	if (savingsPercentage >= 30) {
    		comment = "Excellent! You're saving a healthy portion of your income. 💰";
    	} else if (savingsPercentage >= 20) {
    		comment = "Good job! You're saving well, but there's room to grow. ✅";
    	} else if (savingsPercentage >= 10) {
    		comment = "Try to increase your savings for better financial security.";
    	} else {
    		comment = "Savings are too low! Prioritize setting aside some income. ⚠️";
    	}
    	
    	comments.put("Savings", comment);
    	
    	return comments;
    }
    
    public List<Investment> isInvestmentConsistent(int userId,String month) {
        List<Investment> investment = investRepo.findByUserIdOrderByMonthAsc(userId);
//        
//        YearMonth prevMonth =YearMonth.parse(month).minusMonths(1);
//        Report history = reportRepo.findByPrevMonth(userId,prevMonth);
       System.out.println(investment);
        return investment;
    }
}
