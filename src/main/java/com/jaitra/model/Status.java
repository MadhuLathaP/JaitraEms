package com.jaitra.model;

public class Status {
	
	@Override
	public String toString() {
		return "Status [code=" + code + ", message=" + message + "]";
	}

	public Integer code;
	
	public String message;

	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
