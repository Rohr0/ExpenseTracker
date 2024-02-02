package org.rr.leapfinance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Expense {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double amount;
	private String category;
	private String description;
	private String date;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Member member;

}
