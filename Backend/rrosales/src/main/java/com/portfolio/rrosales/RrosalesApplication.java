package com.portfolio.rrosales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontend-ap-f2550.web.app")
public class RrosalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RrosalesApplication.class, args);
	}

}
