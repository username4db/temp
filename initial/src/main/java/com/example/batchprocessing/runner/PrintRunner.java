package com.example.batchprocessing.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.example.batchprocessing.config.Config;

@Component
public class PrintRunner implements ApplicationRunner {

	@Autowired
	private Environment env;

	@Autowired
	private Config config;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		env.getActiveProfiles();
		System.out.println(config.getBool());
		System.out.println(config.getStr());
		System.out.println(config.getInteger());
		System.out.println(config.getFlt());
		System.out.println(config.getDbl());
		System.out.println(config.getArray());
	}
}
