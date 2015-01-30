package com.fm.exception;

import com.fm.exception.comn.BaseException;

public class DaoException extends BaseException{

	private static final long serialVersionUID = 1L;

	public DaoException(String code,String message){
		super(message);
		this.code=code;
	}
}
