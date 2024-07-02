package com.fooddelivery.resturantlistingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient

@ComponentScan("com.fooddelivery")
public class ResturantlistingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResturantlistingServiceApplication.class, args);
	}

}
