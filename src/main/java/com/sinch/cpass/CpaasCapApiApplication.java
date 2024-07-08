package com.sinch.cpass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableFeignClients
@SpringBootApplication
public class CpaasCapApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CpaasCapApiApplication.class, args);
	}

}
