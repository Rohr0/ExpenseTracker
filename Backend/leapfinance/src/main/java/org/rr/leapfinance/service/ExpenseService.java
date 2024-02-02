package org.rr.leapfinance.service;

import java.util.Optional;

import org.rr.leapfinance.dao.ExpenseDao;
import org.rr.leapfinance.dao.MemberDao;
import org.rr.leapfinance.entity.Expense;
import org.rr.leapfinance.entity.Member;
import org.rr.leapfinance.entity.ResponseStructure;
import org.rr.leapfinance.exceptions.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseDao expenseDao;
	@Autowired
	private MemberDao memberDao;
	
	public ResponseEntity<ResponseStructure<Expense>> saveExpense(Expense e,int id){
		Optional<Member> recMember=memberDao.findById(id);
		ResponseStructure<Expense> s=new ResponseStructure<>();
		if(recMember.isPresent()) {
			Member m=recMember.get();
			m.getExpense().add(e);
			e.setMember(m);
			memberDao.updateMember(m);
			expenseDao.saveExpense(e);
			
			s.setData(e);
			s.setMessage("Expense Added");
			s.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Expense>>(s, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Expense>> updateExpense(Expense e,int id){
		Optional<Member> recMember=memberDao.findById(id);
		ResponseStructure<Expense> s=new ResponseStructure<>();
		if(recMember.isPresent()) {
			Member m=recMember.get();
//			m.getExpense().add(e);
			e.setMember(m);
//			memberDao.updateMember(m);
			expenseDao.saveExpense(e);
			
			s.setData(e);
			s.setMessage("Expense Updated");
			s.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Expense>>(s, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}
	
 
}
