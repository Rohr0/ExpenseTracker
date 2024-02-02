package org.rr.leapfinance.controller;

import org.rr.leapfinance.entity.Member;
import org.rr.leapfinance.entity.ResponseStructure;
import org.rr.leapfinance.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MemberController {
	@Autowired
	private MemberService serv;
	
	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<Member>> saveUser(@RequestBody Member m){
		return serv.saveMember(m);
	}
	@PutMapping("/users")
	public ResponseEntity<ResponseStructure<Member>> updateUser(@RequestBody Member m){
		return serv.updateMember(m);
	}
	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<Member>> findById(@PathVariable int id){
		return serv.findById(id);
	}
	@PostMapping("/users/verifyByEmail")
	public ResponseEntity<ResponseStructure<Member>> verify(@RequestParam String email, @RequestParam String password) {
		return serv.verifyMember(email, password);
	}

}
