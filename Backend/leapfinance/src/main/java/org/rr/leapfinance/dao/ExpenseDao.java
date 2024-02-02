package org.rr.leapfinance.dao;

import java.util.Optional;

import org.rr.leapfinance.entity.Expense;
import org.rr.leapfinance.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ExpenseDao {
	@Autowired
	private ExpenseRepository ExpenseRepository;
	
	public Expense saveExpense(Expense m) {
		return ExpenseRepository.save(m);
	}

	public Expense updateExpense(Expense m) {
		return ExpenseRepository.save(m);
	}
	
	public Optional<Expense> findById(int id){
		return ExpenseRepository.findById(id);
	}
	
	public boolean deleteExpense(int id){
		Optional<Expense> recExpense=ExpenseRepository.findById(id);
		if(recExpense.isPresent()) {
			ExpenseRepository.delete(recExpense.get());
			return true;
		}
		else
			return false;
	}
	
}
