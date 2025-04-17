package com.moumita.ft.features.report.service;

import org.springframework.stereotype.Service;

import com.moumita.ft.features.expense.repository.ExpenseRepository;
import com.moumita.ft.features.investment.repository.Investmentrepository;
import com.moumita.ft.features.report.model.Report;
import com.moumita.ft.features.savings.repository.SavingsRepository;
import com.moumita.ft.features.user.repository.SalaryRepository;

@Service
public class ReportService {

	ExpenseRepository expenseRepo;
	SavingsRepository savingsRepo;
	Investmentrepository investRepo;
	SalaryRepository salaryRepo;

    public Report generateReport(int userId, String month) {
        // TODO: Fetch salary, expenses, investment, savings from respective repos
        long salary = salaryRepo.findByMonth(userId,month); // example data
        long expenses = expenseRepo.findByMonth(userId,month);
        long savings = savingsRepo.findByMonth(userId,month);
        long investment = investRepo.findByMonth(userId,month);

        // Example scoring logic
        int score = 0;
        if (investment >= salary * 0.3) score += 40;
        if (savings >= salary * 0.2) score += 30;
        if (expenses <= salary * 0.5) score += 30;

        Report report = new Report();
        report.setMonth(month.toString());
       // report.setSalary(salary);
        report.setTotalExpense(expenses);
        report.setTotalSavings(savings);
        report.setTotalInvested(investment);
        report.setScore(score);

        return report;
    }
}
