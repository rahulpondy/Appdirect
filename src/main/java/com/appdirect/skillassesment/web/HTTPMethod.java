package com.appdirect.skillassesment.web;

public enum HTTPMethod {
	POST("post"),
	GET("get"),
	PUT("put"),
	DELETE("delete");
	
	
	private String value;
	
	private HTTPMethod(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}

}
