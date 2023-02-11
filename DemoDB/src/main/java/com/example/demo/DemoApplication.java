package com.example.demo;

import java.net.URL;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.tempuri.Weather;
import org.tempuri.WeatherSoap;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) throws Exception {

		URL url = new URL("https://fishingstatus.com/desktopmodules/vivowebservices/weather.asmx?WSDL");
		Weather w = new Weather(url);
		WeatherSoap soap = w.getWeatherSoap();
		System.out.println("=================================");
		System.out.println(soap.getGamePrediction(""));
		System.out.println("=================================");

//		SpringApplication.run(DemoApplication.class, args);
	}

}
