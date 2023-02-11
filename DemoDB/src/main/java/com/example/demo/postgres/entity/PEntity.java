package com.example.demo.postgres.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PTABLE")
public class PEntity {

	@Id
	private String seq;

	private BigDecimal num;

	public PEntity() {
		super();
		this.seq = "GG";
		this.num = BigDecimal.ZERO;
	}

	public PEntity(String seq, BigDecimal num) {
		super();
		this.seq = seq;
		this.num = num;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public BigDecimal getNum() {
		return num;
	}

	public void setNum(BigDecimal num) {
		this.num = num;
	}
}
