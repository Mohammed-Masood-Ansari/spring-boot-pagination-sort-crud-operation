package com.jsp.springbootresponseentitycrudoperation.exception;

import org.springframework.stereotype.Component;

public class IdNotFoundException extends Exception {

	String msg;
	
	public IdNotFoundException(String msg) {
		super(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
