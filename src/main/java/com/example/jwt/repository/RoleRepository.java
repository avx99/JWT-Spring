package com.example.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwt.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByName(String username);
}
