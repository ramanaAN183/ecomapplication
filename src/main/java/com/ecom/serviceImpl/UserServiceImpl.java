package com.ecom.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.model.UserModel;
import com.ecom.repositeory.UserRepositeory;
import com.ecom.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepositeory userRepo;

	@Override
	public UserModel saveUser(UserModel userModel) {
		return userRepo.save(userModel);
		
	}


}
