package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReqAll<T extends Tranrq> {

	@JsonProperty("HEADER")
	private DemoHeader header;

	@JsonProperty("TRANRQ")
	private T data;

	public DemoHeader getHeader() {
		return header;
	}

	public void setHeader(DemoHeader header) {
		this.header = header;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
