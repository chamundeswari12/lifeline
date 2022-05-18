package com.lhs.service;

import java.security.Principal;

import com.lhs.dto.RegistrationDto;
import com.lhs.entity.RegistrationEntity;

public interface RegistrationServiceInterface {

	public RegistrationDto addAccount(RegistrationDto register);
	RegistrationEntity updateuser(RegistrationDto dto,String name);

}
