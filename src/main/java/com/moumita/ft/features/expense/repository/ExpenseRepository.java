package com.moumita.ft.features.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moumita.ft.features.expense.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

	@Modifying//need for update and delete query
	@Transactional//need for update and delete query
	@Query("UPDATE Expense e SET e.amount = :amount, e.category = :category, e.month = :month, e.needOrWant = :needOrWant WHERE e.id = id")
    int updateData(int id,long amount,String category,String month,String needOrWant);

	@Query("SELECT sum(e.amount) FROM Expense e WHERE e.month = :month AND e.userId = :userId")
	long findByMonth(@Param("userId") int userId, @Param("month") String month);
}
