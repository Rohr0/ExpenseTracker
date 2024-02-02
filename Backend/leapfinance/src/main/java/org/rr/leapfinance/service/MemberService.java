package org.rr.leapfinance.service;

import java.util.Optional;

import org.rr.leapfinance.dao.MemberDao;import org.rr.leapfinance.entity.Member;
import org.rr.leapfinance.entity.ResponseStructure;
import org.rr.leapfinance.exceptions.IdNotFoundException;
import org.rr.leapfinance.exceptions.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDao mdao;
	
	public ResponseEntity<ResponseStructure<Member>> saveMember(Member m){
		ResponseStructure<Member> structure=new ResponseStructure<>();
		structure.setData(mdao.saveMember(m));
		structure.setMessage("Member Saved :D");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Member>>(structure,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Member>> updateMember(Member m){
		ResponseStructure<Member> structure=new ResponseStructure<>();
		structure.setData(mdao.saveMember(m));
		structure.setMessage("Member Updated :D");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Member>>(structure,HttpStatus.ACCEPTED);
	}
	public ResponseEntity<ResponseStructure<Member>> findById(int id){
		ResponseStructure<Member> s=new ResponseStructure<>();
		Optional<Member> recMember=mdao.findById(id);
		if(recMember.isPresent()) {
			s.setData(recMember.get());
			s.setMessage("Member Found");
			s.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Member>>(s, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<Member>> verifyMember(String email, String password) {
		ResponseStructure<Member> structure = new ResponseStructure<>();
		Optional<Member> rs = mdao.verifyMember(email, password);
		if (rs.isPresent()) {
			structure.setData(rs.get());
			structure.setMessage("Member Phone-Number Verified Successfully");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Member>>(structure, HttpStatus.OK);
		} 
		throw new InvalidCredentialsException();
	}

}
