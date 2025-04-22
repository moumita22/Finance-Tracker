package com.moumita.ft.features.report.repository;

import java.time.LocalDateTime;
import java.time.YearMonth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.moumita.ft.features.report.model.Report;

public interface ReportRepository extends JpaRepository<Report, Integer>{

	@Modifying
	@Query("INSERT INTO Report (userId, month, date, score, totalInvested, totalExpense, totalSavings,"
			+ " increasedExpence, increasedSavings,increasedInvestment, summary) VALUES (:userId, :month, :date, :score, :totalInvested, "
			+ ":totalExpense, :totalSavings, :increasedExpence, :increasedSavings, :increasedInvestment, :summary)")
	void insertReport(int userId, String month,LocalDateTime date,int score,long totalInvested,long totalExpense,long totalSavings,double increasedExpence,double increasedSavings, double increasedInvestment,String summary);

	Report findByUserIdOrderByMonthAsc(int userId);

	@Query("SELECT r.totalInvested FROM Report r WHERE r.month = :month AND r.userId = :userId")
	Report findByPrevMonth(int userId, @Param("month") YearMonth prevMonth);

}
