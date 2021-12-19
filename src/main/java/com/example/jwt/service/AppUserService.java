package com.example.jwt.service;

import java.util.List;

import com.example.jwt.domain.AppUser;
import com.example.jwt.domain.Role;


public interface AppUserService {
	AppUser saveUser(AppUser user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	AppUser getUser(String username);
	List<AppUser> getUsers();
}
