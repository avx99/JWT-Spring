package com.example.jwt.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.domain.AppUser;
import com.example.jwt.domain.Role;
import com.example.jwt.repository.AppUserRepository;
import com.example.jwt.repository.RoleRepository;
import com.example.jwt.service.AppUserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService{
	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public AppUser saveUser(AppUser user) {
		return this.appUserRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		return this.roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppUser user = this.appUserRepository.findByUserName(username);
		Role role = this.roleRepository.findByName(roleName);
		user.getRoles().add(role);
	}

	@Override
	public AppUser getUser(String username) {
		return this.appUserRepository.findByUserName(username);
	}

	@Override
	public List<AppUser> getUsers() {
		return this.appUserRepository.findAll();
	}

}
