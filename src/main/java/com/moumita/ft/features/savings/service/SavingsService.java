package com.moumita.ft.features.savings.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moumita.ft.features.savings.model.Savings;
import com.moumita.ft.features.savings.repository.SavingsRepository;

@Service
public class SavingsService {
	@Autowired
	private SavingsRepository repo;
	
	public Savings addService(Savings savings) {
		savings.setDate(LocalDateTime.now());
		return repo.save(savings);
	}
	
	public List<Savings> getAll() {
		
		return repo.findAll();
	}

	public int update(Savings savings) {
		return repo.updateData(savings.getId(),savings.getAmount(),savings.getMonth());
		//return repo.findById(invest.getId());
	}
	
	public Optional<Savings> getById(int id) {
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
