package org.rr.leapfinance.controller;

import java.util.List;

import org.rr.leapfinance.entity.Expense;
import org.rr.leapfinance.entity.ResponseStructure;
import org.rr.leapfinance.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ExpenseController {
	@Autowired
	private ExpenseService serv;
	
	@PostMapping("/bus/{id}")
	public ResponseEntity<ResponseStructure<Expense>> saveBus(@RequestBody Expense e, @PathVariable int id) {
		return serv.saveExpense(e, id);
	}

	@PutMapping("/bus/{id}")
	public ResponseEntity<ResponseStructure<Expense>> updateBus(@RequestBody Expense e, @PathVariable int id) {
		return serv.updateExpense(e, id);
	}

//	@GetMapping("/bus/filter")
//	public ResponseEntity<ResponseStructure<List<Expense>>> filter(@RequestParam String from, @RequestParam String to,
//			@RequestParam LocalDate dod) {
//		return serv.filter(from, to, dod);
//	}

}
