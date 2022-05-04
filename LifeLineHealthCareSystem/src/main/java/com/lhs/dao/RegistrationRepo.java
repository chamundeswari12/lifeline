package com.lhs.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lhs.entity.RegistrationEntity;

@Repository
public interface RegistrationRepo extends CrudRepository<RegistrationEntity, Integer> {

	boolean existsByUsername(String username);

	RegistrationEntity findByUsername(String username);
	RegistrationEntity findByEmail(String email);

}
