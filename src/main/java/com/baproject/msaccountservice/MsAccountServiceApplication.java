package com.baproject.msaccountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAccountServiceApplication.class, args);
	}

}
