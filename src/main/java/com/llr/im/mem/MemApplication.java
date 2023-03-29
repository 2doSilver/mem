package com.llr.im.mem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.llr.im.mem")
public class MemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemApplication.class, args);
	}

}
