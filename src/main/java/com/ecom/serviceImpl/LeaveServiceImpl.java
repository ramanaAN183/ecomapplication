package com.ecom.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.model.LeaveModel;
import com.ecom.repositeory.LeaveRepositeory;
import com.ecom.service.LeaveService;

@Service
public class LeaveServiceImpl implements LeaveService {
	@Autowired
	private LeaveRepositeory leaveRepositeory;
	
	public LeaveModel saveLeaveRecord(LeaveModel leaveModel) {
		return leaveRepositeory.save(leaveModel);
	}
	
}
