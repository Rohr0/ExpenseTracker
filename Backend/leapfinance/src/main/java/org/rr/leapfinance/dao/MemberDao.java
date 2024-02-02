package org.rr.leapfinance.dao;

import java.util.Optional;

import org.rr.leapfinance.entity.Member;
import org.rr.leapfinance.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	@Autowired
	private MemberRepository memberRepository;
	
	public Member saveMember(Member m) {
		return memberRepository.save(m);
	}

	public Member updateMember(Member m) {
		return memberRepository.save(m);
	}
	
	public Optional<Member> findById(int id){
		return memberRepository.findById(id);
	}
	public Optional<Member> verifyMember(String email,String password){
		return memberRepository.verify(email,password);
	}

}
