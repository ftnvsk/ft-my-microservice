package com.ft.mymicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication      // Specifica faptul ca clasa asta porneste aplicatia Spring Boot
public class DemoApplication {

	// acuma pornim Spring boot
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
