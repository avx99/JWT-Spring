package com.example.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwt.domain.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long>{
	AppUser findByUserName(String username);
}
