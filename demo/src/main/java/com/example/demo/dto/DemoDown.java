package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DemoDown extends Tranrs {

	@JsonProperty("downA")
	private String downA;

	@JsonProperty("downB")
	private String downB;

	public String getDownA() {
		return downA;
	}

	public void setDownA(String downA) {
		this.downA = downA;
	}

	public String getDownB() {
		return downB;
	}

	public void setDownB(String downB) {
		this.downB = downB;
	}

}
