package com.app;

import com.app.service.JpaService;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

	@Autowired
	private JpaService jpaService;

	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
		boolean type = false;
		if (type) {
			jpaService.run();
		} else {
			userService.run();
		}
	}

}
