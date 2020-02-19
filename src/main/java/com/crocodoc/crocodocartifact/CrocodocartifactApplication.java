package com.crocodoc.crocodocartifact;

import com.crocodoc.crocodocartifact.model.Structure;
import com.crocodoc.crocodocartifact.model.StructureType;
import com.crocodoc.crocodocartifact.service.StructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrocodocartifactApplication implements CommandLineRunner {

	@Autowired
	private StructureService structureService;

	public static void main(String[] args) {
		SpringApplication.run(CrocodocartifactApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
