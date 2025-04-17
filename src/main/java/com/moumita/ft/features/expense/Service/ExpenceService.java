package com.moumita.ft.features.expense.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.moumita.ft.features.expense.model.Expense;
import com.moumita.ft.features.expense.repository.ExpenseRepository;

public class ExpenceService {

	@Autowired
	private ExpenseRepository repo;
	
	public Expense addService(Expense expense) {
		expense.setDate(LocalDateTime.now());
		return repo.save(expense);
	}
	
	public List<Expense> getAll() {
		
		return repo.findAll();
	}

	public int update(Expense expense) {
		return repo.updateData(expense.getId(),expense.getAmount(),expense.getCategory(),expense.getMonth(),expense.getNeedOrWant());
		//return repo.findById(expense.getId());
	}
	
	public Optional<Expense> getById(int id) {
		return repo.findById(id);
	}

	public String deleteData(int id) {
		if(getById(id).isPresent()) {
			repo.deleteById(id);
			return "Row/s deleted";
		}

		return "Id not exists";
	}
}
