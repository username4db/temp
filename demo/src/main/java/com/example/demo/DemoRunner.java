package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.DemoDown;
import com.example.demo.dto.DemoHeader;
import com.example.demo.dto.DemoUp;
import com.example.demo.dto.ReqAll;
import com.example.demo.dto.ResAll;

@Component
public class DemoRunner implements ApplicationRunner {

	@Autowired
	private Environment env;

	@Autowired
	private PropertiesA propA;

	@Autowired
	private PropertiesB propB;

	@Autowired
	@Qualifier("restSSL")
	private RestTemplate restTemplate;

	private static Logger LOGGER = LoggerFactory.getLogger(DemoRunner.class);
//	private final Logger LOGGER = LogManager.getLogger(getClass());

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// runA(args);
		runB(args);
	}

	public void runB(ApplicationArguments args) throws Exception {
		String[] arrayOfStrings = env.getProperty("arrayOfStrings", String[].class);
		List<String> listOfStrings = (List<String>) env.getProperty("arrayOfStrings", List.class);

		LOGGER.info(propA.username);
		LOGGER.info("  " + propB.getMap().get("port"));
		LOGGER.info(arrayOfStrings[0]);
		LOGGER.info(listOfStrings.get(0));
	}

	public void runA(ApplicationArguments args) throws Exception {

		ReqAll<DemoUp> req = new ReqAll();
		req.setHeader(new DemoHeader());
		req.getHeader().setHeadA("AA");
		req.getHeader().setHeadB("BB");
		req.setData(new DemoUp());
		req.getData().setUpA("aaa");
		req.getData().setUpB("bbb");

		ResAll<DemoDown> res = restTemplate.exchange( //
				"https://localhost:8443/DemoWeb/Demo2" //
				, HttpMethod.POST //
				, new HttpEntity<ReqAll<DemoUp>>(req) //
				, new ParameterizedTypeReference<ResAll<DemoDown>>() {
				}).getBody();

		LOGGER.info(res.getHeader().getHeadA());
		LOGGER.info(res.getHeader().getHeadB());
		LOGGER.info(res.getData().getDownA());
		LOGGER.info(res.getData().getDownB());
	}

}
