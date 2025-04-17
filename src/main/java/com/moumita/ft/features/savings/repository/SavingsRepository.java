package com.moumita.ft.features.savings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moumita.ft.features.savings.model.Savings;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Integer> {

	@Modifying//need for update and delete query
	@Transactional//need for update and delete query
	@Query("UPDATE Savings s SET s.amount = :amount, s.month = :month WHERE s.id = id")
    int updateData(int id,long amount,String month);

//	@Query("SELECT sum(s.amount) FROM Savings WHERE s.month = :month AND s.userId = :userId")
//	long findByMonth(int userId,String month);
	
	
	@Query("SELECT COALESCE(SUM(s.amount), 0) FROM Savings s WHERE s.month = :month AND s.userId = :userId")
	long findByMonth(@Param("userId") int userId, @Param("month") String month);
	//COALESCE(..., 0) returns 0 instead of null when there's no data
}
