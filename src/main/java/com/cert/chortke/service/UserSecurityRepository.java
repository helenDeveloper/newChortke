package com.cert.chortke.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cert.chortke.entities.UserEntity;

public interface UserSecurityRepository extends JpaRepository<UserEntity,String> {



}
