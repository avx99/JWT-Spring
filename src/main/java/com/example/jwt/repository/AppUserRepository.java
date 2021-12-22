package com.example.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jwt.domain.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>{
	AppUser findByUsername(String username);
}
