package com.example.batchprocessing.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/good.properties")
@ConfigurationProperties(prefix = "good")
public class Config {
	Boolean bool;
	Integer integer;
	Float flt;
	Double dbl;
	String str;
	String[] array;

//	@Value("#{${good.map}}")
//	Map<String, String> map;

	public Boolean getBool() {
		return bool;
	}

	public void setBool(Boolean bool) {
		this.bool = bool;
	}

	public Integer getInteger() {
		return integer;
	}

	public void setInteger(Integer integer) {
		this.integer = integer;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	public Float getFlt() {
		return flt;
	}

	public void setFlt(Float flt) {
		this.flt = flt;
	}

	public Double getDbl() {
		return dbl;
	}

	public void setDbl(Double dbl) {
		this.dbl = dbl;
	}

}
