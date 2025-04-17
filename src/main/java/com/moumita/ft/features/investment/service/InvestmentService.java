package com.moumita.ft.features.investment.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moumita.ft.features.investment.model.Investment;
import com.moumita.ft.features.investment.repository.Investmentrepository;

@Service
public class InvestmentService {
	@Autowired
	private Investmentrepository repo;
	
	public Investment addService(Investment invest) {
		invest.setDate(LocalDateTime.now());
		return repo.save(invest);
	}
	
	public List<Investment> getAll() {
		
		return repo.findAll();
	}

	public int update(Investment invest) {
		return repo.updateData(invest.getId(),invest.getAmount(),invest.getCategory(),invest.getMonth());
		//return repo.findById(invest.getId());
	}
	
	public Optional<Investment> getById(int id) {
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
