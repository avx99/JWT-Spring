package com.example.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.jwt.domain.AppUser;
import com.example.jwt.domain.Role;
import com.example.jwt.service.AppUserService;

@SpringBootApplication
public class JwtApplication {

	@Autowired
	private AppUserService appUserService;
	public static void main(String[] args) {
		
		SpringApplication.run(JwtApplication.class, args);
		
	}
	
	@Bean
	CommandLineRunner run() {
		return args -> {
			appUserService.saveRole(new Role(null,"ROLE_USER"));
			appUserService.saveRole(new Role(null,"ROLE_ADMIN"));
			appUserService.saveRole(new Role(null,"ROLE_MANAGER"));
			
			appUserService.saveUser(new AppUser(null, "oussama", "ouss", "123456789", new ArrayList<Role>()));
			appUserService.saveUser(new AppUser(null, "anas", "ce", "4861354", new ArrayList<Role>()));
			appUserService.saveUser(new AppUser(null, "rim", "wsc", "1sdcsc89", new ArrayList<Role>()));
			appUserService.saveUser(new AppUser(null, "cd", "zeczerf", "1scdcvsv9", new ArrayList<Role>()));
			appUserService.saveUser(new AppUser(null, "fr", "&n&sa", "45ssv", new ArrayList<Role>()));
			appUserService.saveUser(new AppUser(null, "refg", "scdzecz", "none9", new ArrayList<Role>()));
			
			
			appUserService.addRoleToUser("ouss", "ROLE_ADMIN");
			appUserService.addRoleToUser("ouss", "ROLE_MANAGER");
			appUserService.addRoleToUser("ouss", "ROLE_USER");
			appUserService.addRoleToUser("ce", "ROLE_USER");
		};
	}
}
