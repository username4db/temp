package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DemoUp extends Tranrq {

	@JsonProperty("upA")
	private String upA;

	@JsonProperty("upB")
	private String upB;

	public String getUpA() {
		return upA;
	}

	public void setUpA(String upA) {
		this.upA = upA;
	}

	public String getUpB() {
		return upB;
	}

	public void setUpB(String upB) {
		this.upB = upB;
	}

}
