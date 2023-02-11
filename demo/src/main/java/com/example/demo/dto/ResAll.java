package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResAll<T extends Tranrs> {

	@JsonProperty("HEADER")
	private DemoHeader header;

	@JsonProperty("TRANRS")
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
