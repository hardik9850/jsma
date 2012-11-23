package com.github.jkschoen.jsma.misc;

import com.github.jkschoen.jsma.response.SMResponse;


public class SmugMugException extends Exception {

	private static final long serialVersionUID = 5953246277446742032L;

	private int code;
	private String method;
	
	public SmugMugException(int code, String method, String message){
		super (message+" [Error Code: "+code +" Method: "+method+"]");
		this.code = code;
		this.method = method;
	}
	
	public SmugMugException(SMResponse response){
		super (response.getMessage()+" [Method: "+response.getMethod()+" Error Code: "+response.getCode()+" Message: "+response.getMessage() +" ]");
		this.code = response.getCode();
		this.method = response.getMethod();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	
	
}
