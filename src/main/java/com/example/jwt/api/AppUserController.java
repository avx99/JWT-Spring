package com.example.jwt.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.domain.AppUser;
import com.example.jwt.service.AppUserService;


@RestController
@RequestMapping("api")
public class AppUserController {
	
	@Autowired
	private AppUserService appUserService;
	
	@GetMapping("/users")
	public ResponseEntity<List<AppUser>> getUsers(){
		return ResponseEntity.ok().body(this.appUserService.getUsers());
	}
}









