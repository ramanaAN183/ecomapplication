package com.ecom.repositeory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.model.LeaveModel;

@Repository
public interface LeaveRepositeory extends JpaRepository<LeaveModel, Integer> {
	
	

}
