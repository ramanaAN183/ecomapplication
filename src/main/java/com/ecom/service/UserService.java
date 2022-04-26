package com.ecom.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecom.model.UserModel;

@Service
public interface UserService  {
	
	public UserModel saveUser(UserModel userModel);

}
