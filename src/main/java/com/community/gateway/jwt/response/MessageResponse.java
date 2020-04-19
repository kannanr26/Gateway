package com.community.gateway.jwt.response;

public class MessageResponse {
	private String message;
    private boolean isSuccess;
	public MessageResponse(boolean isSuccess,String message) {
		this.isSuccess=isSuccess;
	    this.message = message;
	  }

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
