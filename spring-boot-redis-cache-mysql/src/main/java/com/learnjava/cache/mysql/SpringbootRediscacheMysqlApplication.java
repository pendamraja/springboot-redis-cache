package com.learnjava.cache.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootRediscacheMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRediscacheMysqlApplication.class, args);
	}

}
