package com.application.pichuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PichuserApplication {
	public static void main(String[] args) {
		
		static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PichuserApplication.class);

		SpringApplication.run(PichuserApplication.class, args);

	}
}