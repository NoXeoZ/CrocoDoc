package com.crocodoc.crocodocartifact;

import com.crocodoc.crocodocartifact.model.*;
import com.crocodoc.crocodocartifact.service.DMPService;
import com.crocodoc.crocodocartifact.service.StructureService;
import com.crocodoc.crocodocartifact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class CrocodocartifactApplication implements CommandLineRunner {

	@Autowired
	private StructureService structureService;
	@Autowired
	private UserService userService;
	@Autowired
	private DMPService dmpService;

	public static void main(String[] args) {
		SpringApplication.run(CrocodocartifactApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Structure s = structureService.create(new Structure("Big Brother", StructureType.HOSPITAL));
		userService.create(new User("admin", "admin", new Date(), "address", "+666", "admin", "pw", "rib", UserType.ADMIN, s));
		userService.create(new User("kenza", "yahi", new Date(), "address", "+666", "kenza", "pw", "rib", UserType.DOCTOR, s));
		userService.create(new User("daniel", "daniel", new Date(), "address", "+666", "daniel", "pw", "rib", UserType.SECRETARY, s));
		DMP dmp=dmpService.createDMP(new DMP("thomas","levee",new Date(),"Drancy","1245434","23344444","levethomas"));
		//Hospitalization h=dmpService.createHospitalization(new Hospitalization(s, dmp));


		/*System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHH "+ h.getDMP().getSocialSecurityNumber());
		dmp.addHospitalizations(h);
		System.out.println(dmp.getHospitalizations().size());
		for (DMP dmp1 : dmpService.getAllDMP()) {
			System.out.println(dmp1.getHospitalizations().size());
		}
		//dmpService.getAllHospitalization().forEach(u->System.out.println(u.getDMP().getSocialSecurityNumber()));*/
	}
}
