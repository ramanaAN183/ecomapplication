package com.ecom.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.model.LeaveModel;
import com.ecom.response.SuccessResponse;
import com.ecom.service.LeaveService;
import com.ecom.serviceImpl.LeaveServiceImpl;

@RestController
@RequestMapping("/leave")
public class LeaveManagementController {
	
	@Autowired
	private LeaveServiceImpl leaveService;
	
	@PostMapping("/apply")
	public ResponseEntity<?> applyLeave(@RequestBody LeaveModel leaveModel){
		
			LeaveModel leaveResponceModel=leaveService.saveLeaveRecord(leaveModel);
			if(leaveResponceModel!=null)
				return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(true,leaveResponceModel,"success"));
			else 
				return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(false,leaveResponceModel,"failed"));
	}

}
