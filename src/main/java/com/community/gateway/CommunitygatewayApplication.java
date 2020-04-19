package com.community.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@ComponentScan({"com.community.gateway"})
public class CommunitygatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunitygatewayApplication.class, args);
	}

}
