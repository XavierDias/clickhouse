package com.xavierdias.clickhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ClickhouseApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClickhouseApplication.class, args);
	}
}