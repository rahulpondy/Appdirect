package com.appdirect.skillassesment.web;

public enum ErrorCode {
	ACCOUNT_NOT_FOUND("ACCOUNT_NOT_FOUND", "Requested account could not be found"),
	BAD_REQUEST("EVENT_NOT_FOUND", "Error Occurred to get an ebent description");
	private String code;
	private String message;
	
	private ErrorCode(String code, String message){
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
