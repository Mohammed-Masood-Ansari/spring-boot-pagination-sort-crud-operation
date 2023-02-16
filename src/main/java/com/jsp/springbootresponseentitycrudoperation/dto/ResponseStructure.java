package com.jsp.springbootresponseentitycrudoperation.dto;

import org.springframework.stereotype.Component;

@Component
public class ResponseStructure<T> {

	private int statusCode;
	private String message;
	private T Data;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return Data;
	}

	public void setData(T data) {
		Data = data;
	}

}
