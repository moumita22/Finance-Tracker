package com.moumita.ft.features.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.moumita.ft.features.user.model.Salary;

public interface SalaryRepository extends JpaRepository<Salary,Integer> {

	@Query("SELECT amount FROM Salary s WHERE s.month = :month and s.userId = :userId")
	long findByMonth(int userId,String month);

}
