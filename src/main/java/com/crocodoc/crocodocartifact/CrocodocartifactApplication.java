package com.crocodoc.crocodocartifact;

import com.crocodoc.crocodocartifact.service.StructureService;
import com.crocodoc.crocodocartifact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrocodocartifactApplication implements CommandLineRunner {

	@Autowired
	private StructureService structureService;
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(CrocodocartifactApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Structure s = structureService.create(new Structure("Big Brother", StructureType.HOSPITAL));
		//userService.create(new User("admin", "admin", new Date(), "address", "+666", "admin", "pw", "rib", UserType.ADMIN, s));
	}
}
