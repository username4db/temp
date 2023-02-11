package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesA {

	@Value("${aa.username:DEFAULT}")
	public String username;

	@Value("${arrayOfStrings}")
	public String[] arrayOfStrings;

	@Value("#{'${arrayOfStrings}'.split(',')}")
	public List<String> listOfStrings;

	@Value("#{${listOfStrings}}")
	public List<String> listOfStringsV2;
}