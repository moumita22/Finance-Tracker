package com.moumita.ft.features.investment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moumita.ft.features.investment.model.Investment;

@Repository
public interface Investmentrepository extends JpaRepository<Investment, Integer> {
	
	@Modifying//need for update and delete query
	@Transactional//need for update and delete query
	@Query("UPDATE Investment i SET i.amount = :amount, i.category = :category, i.month = :month WHERE i.id = id")
    int updateData(int id,long amount,String category,String month);

	@Query("SELECT sum(i.amount) FROM Investment i WHERE i.month = :month AND i.userId = :userId")
	long findByMonth(int userId,String month);

	List<Investment> findByUserIdOrderByMonthAsc(int userId);
	
	
//	@Modifying//need for update and delete query
//	@Transactional//need for update and delete query
//	@Query("DELETE FROM Investment i WHERE i.id = id")
//	boolean deleteRow(int id);

}
