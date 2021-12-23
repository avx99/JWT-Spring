package com.example.jwt.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

	private final AppUserRepository appUserRepository;
	private final RoleRepository roleRepository;
//	private final PasswordEncoder passwordEncoder;
	@Override
	public AppUser saveUser(AppUser user) {
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return this.appUserRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("saving new Role {} to db",role);
		return this.roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppUser user = this.appUserRepository.findByUsername(username);
		Role role = this.roleRepository.findByName(roleName);
		user.getRoles().add(role);
	}

	@Override
	public AppUser getUser(String username) {
		return this.appUserRepository.findByUsername(username);
	}

	@Override
	public List<AppUser> getUsers() {
		return this.appUserRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = this.appUserRepository.findByUsername(username);
		if(user == null){
			log.error("user not found");
			throw new UsernameNotFoundException("user not found");
		}else{
			log.info("user {} found",user);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
	}


}
