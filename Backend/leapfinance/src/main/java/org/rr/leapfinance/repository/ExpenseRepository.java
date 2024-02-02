package org.rr.leapfinance.repository;

import java.util.Optional;

import org.rr.leapfinance.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Integer>{
	

}
