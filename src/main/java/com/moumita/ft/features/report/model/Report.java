package com.moumita.ft.features.report.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_monthly_report")
public class Report {

	@Id
	@Column(name = "fld_ai_id")
	private int id;
	@Column(name = "fld_user_id")
	private int userId;
	@Column(name = "fld_month")
	private String month;
	@Column(name = "fld_date")
	private LocalDateTime date;
	@Column(name = "fld_Score")
	private int score;
	@Column(name = "fld_total_invested")
	private long totalInvested;
	@Column(name = "fld_total_expense")
	private long totalExpense;
	@Column(name = "fld_total_savings")
	private long totalSavings;
	@Column(name = "fld_invested_percentage")
	private double investedPercentage;
	@Column(name = "fld_expense_percentage")
	private double expensePercentage;
	@Column(name = "fld_savings_percentage")
	private double savingsPercentage;
	@Column(name = "fld_increased_expence")
	private double increasedExpence;
	@Column(name = "fld_increased_savings")
	private double increasedSavings;
	@Column(name = "fld_increased_investment")
	private double increasedInvestment;
	@Column(name = "fld_summary")
	private String summary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public long getTotalInvested() {
		return totalInvested;
	}
	public void setTotalInvested(long totalInvested) {
		this.totalInvested = totalInvested;
	}
	public long getTotalExpense() {
		return totalExpense;
	}
	public void setTotalExpense(long totalExpense) {
		this.totalExpense = totalExpense;
	}
	public long getTotalSavings() {
		return totalSavings;
	}
	public void setTotalSavings(long totalSavings) {
		this.totalSavings = totalSavings;
	}
	public double getInvestedPercentage() {
		return investedPercentage;
	}
	public void setInvestedPercentage(double investedPercentage) {
		this.investedPercentage = investedPercentage;
	}
	public double getExpensePercentage() {
		return expensePercentage;
	}
	public void setExpensePercentage(double expensePercentage) {
		this.expensePercentage = expensePercentage;
	}
	public double getSavingsPercentage() {
		return savingsPercentage;
	}
	public void setSavingsPercentage(double savingsPercentage) {
		this.savingsPercentage = savingsPercentage;
	}
	public double getIncreasedExpence() {
		return increasedExpence;
	}
	public void setIncreasedExpence(double increasedExpence) {
		this.increasedExpence = increasedExpence;
	}
	public double getIncreasedSavings() {
		return increasedSavings;
	}
	public void setIncreasedSavings(double increasedSavings) {
		this.increasedSavings = increasedSavings;
	}
	public double getIncreasedInvestment() {
		return increasedInvestment;
	}
	public void setIncreasedInvestment(double increasedInvestment) {
		this.increasedInvestment = increasedInvestment;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Override
	public String toString() {
		return "report [id=" + id + ", userId=" + userId + ", month=" + month + ", date=" + date
				+ ", score=" + score + ", totalInvested=" + totalInvested + ", totalExpense=" + totalExpense
				+ ", totalSavings=" + totalSavings + ", increasedExpence=" + increasedExpence + ", increasedSavings="
				+ increasedSavings + ", increasedInvestment=" + increasedInvestment + ", summary=" + summary + "]";
	}
	
	
}
