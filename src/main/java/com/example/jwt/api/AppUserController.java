package com.example.jwt.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.domain.AppUser;
import com.example.jwt.domain.Role;
import com.example.jwt.service.AppUserService;

import lombok.Data;


@RestController
@RequestMapping("api")
public class AppUserController {
	
	@Autowired
	private AppUserService appUserService;
	
	@GetMapping("/users")
	public ResponseEntity<List<AppUser>> getUsers(){
		return ResponseEntity.ok().body(this.appUserService.getUsers());
	}
	
	@PostMapping("/user/save")
	public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user){
		return ResponseEntity.ok().body(this.appUserService.saveUser(user));
	}	
	
	@PostMapping("/role/save")
	public ResponseEntity<Role> saveRole(@RequestBody Role role){
		return ResponseEntity.ok().body(this.appUserService.saveRole(role));
	}
	
	@PostMapping("/role/addtouser")
	public ResponseEntity<?> addToUser(@RequestBody Form form){
		this.appUserService.addRoleToUser(form.getUsername(), form.getRoleName());
		return ResponseEntity.ok().build();
	}
	
	@Data
	class Form{
		private String username;
		private String roleName;
	}
}









