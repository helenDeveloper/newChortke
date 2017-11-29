package com.cert.chortke.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cert.chortke.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	List<UserEntity> findByUsername(String username);
	
	
}
