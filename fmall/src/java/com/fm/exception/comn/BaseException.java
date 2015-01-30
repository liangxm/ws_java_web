package com.fm.exception.comn;

public abstract class BaseException extends Exception{

	private static final long serialVersionUID = 1L;
	
	protected String code;
	
	public BaseException(){
		super();
	}
	
	public BaseException(String code){
		super();
		this.code=code;
	}
	
	public BaseException(String code,String message){
		super(message);
		this.code=code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
