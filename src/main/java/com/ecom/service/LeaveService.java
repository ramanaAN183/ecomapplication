package com.ecom.service;

import org.springframework.stereotype.Service;

import com.ecom.model.LeaveModel;

@Service
public interface LeaveService {
	public LeaveModel saveLeaveRecord(LeaveModel leaveModel);
}
