package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DemoHeader {

	@JsonProperty("headA")
	private String headA;

	@JsonProperty("headB")
	private String headB;

	public String getHeadA() {
		return headA;
	}

	public void setHeadA(String headA) {
		this.headA = headA;
	}

	public String getHeadB() {
		return headB;
	}

	public void setHeadB(String headB) {
		this.headB = headB;
	}

}
