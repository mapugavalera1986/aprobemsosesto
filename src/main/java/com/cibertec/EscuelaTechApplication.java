package com.cibertec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EscuelaTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscuelaTechApplication.class, args);
		System.out.println("La API REST ya debería estar funcionando sin problemas");
	}
}
