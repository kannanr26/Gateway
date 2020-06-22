package com.community.gateway.jwt.response;

import lombok.Data;

@Data
public class MessageResponse<T> {
	private String message;
    private boolean isSuccess;
    private T obj;
	public MessageResponse(T obj,boolean isSuccess,String message) {
		this.isSuccess=isSuccess;
	    this.message = message;
	    this.obj=obj;
	  }
	public MessageResponse(boolean isSuccess,String message) {
			this.isSuccess=isSuccess;
		    this.message = message;
		    
		  }
}
