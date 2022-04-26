package com.ecom.repositeory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.model.UserModel;

@Repository
public interface UserRepositeory extends JpaRepository<UserModel,Long> {
	
	 
	

}
