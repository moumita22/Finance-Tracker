package com.moumita.ft.features.investment.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.moumita.ft.features.investment.model.Investment;
import com.moumita.ft.features.investment.service.InvestmentService;

@Controller
public class InvestmentController {
	@Autowired
	InvestmentService service;
	
	@PostMapping("invest")
	@ResponseBody
	public Investment addInvestment(Investment invest){
		
		service.addService(invest);
		return invest;
	}
	
	@GetMapping(path ="investments",produces = {"application/json"})
	@ResponseBody
	public List<Investment> showAllInvestments(){
		List<Investment> investments = service.getAll();
		return investments;
	}
	
	@PutMapping("invest/{id}")
	@ResponseBody
	public int updateInvestment(Investment invest) {
		int data = service.update(invest);
		return data;
	}
	
	@DeleteMapping("delInvest/{id}")
	@ResponseBody
	public String DeleteInvestment(@PathVariable Integer id) {//@PathVariable is must
		System.out.println(id);
		String data = service.deleteData(id);
		return data;
	}
}
