package org.rr.leapfinance.repository;

import java.util.Optional;

import org.rr.leapfinance.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Integer>{
	@Query("Select m from Member m where m.email=?1 and m.password=?2")
	Optional<Member> verify(String email, String password);

}
