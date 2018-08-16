package com.weatherdata.collection.cimiss;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
@EnableJms
public class CimissApplication {

	public static void main(String[] args) {
		SpringApplication.run(CimissApplication.class, args);
	}
}
