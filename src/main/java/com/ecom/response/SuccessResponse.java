package com.ecom.response;

public class SuccessResponse {
	
	private Boolean status;
	private Object data;
	private String message;
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public SuccessResponse(Boolean status, Object data, String message) {
		super();
		this.status = status;
		this.data = data;
		this.message = message;
	}
}
