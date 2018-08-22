package com.NikitaDrozdinski.finalProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.NikitaDrozdinski.finalProject.Utils.DeleteExpiredCoupons;

/**
 * NOTE: This class should be in a package that is a "root" package in all sub-projects
 */

@SpringBootApplication
public class FinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}
	@Bean
	public CommandLineRunner taske() {
		return args -> {
			Thread t = new Thread(new DeleteExpiredCoupons());
		t.start();
		};
		
	}
}
