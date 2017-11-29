package com.cert.chortke.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cert.chortke.entities.StuffTypeEntity;
import com.cert.chortke.entities.UserEntity;

public interface StuffTypeRepository extends JpaRepository<StuffTypeEntity, Long> {

	
	
}
