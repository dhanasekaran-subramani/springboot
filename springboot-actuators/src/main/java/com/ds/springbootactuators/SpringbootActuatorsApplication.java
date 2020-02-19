package com.ds.springbootactuators;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
@EnableAdminServer
@SpringBootApplication
public class SpringbootActuatorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootActuatorsApplication.class, args);
	}

}
