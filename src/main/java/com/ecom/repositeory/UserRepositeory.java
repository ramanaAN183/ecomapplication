package com.ecom.repositeory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.model.UserModel;

@Repository
public interface UserRepositeory extends JpaRepository<UserModel,Long> {
	
	@Query(value="select * from user where username=?1",nativeQuery = true)
	 public UserModel userLogin(String username);
	

}
