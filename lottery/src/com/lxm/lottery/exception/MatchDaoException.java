package com.lxm.lottery.exception;
/**
 * MatchDao Exception
 * @author lianxiao
 *
 */
public class MatchDaoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public MatchDaoException(){}
	
	public MatchDaoException(Throwable e){}

	public MatchDaoException(String exc){
		super(exc);
	}
	
	public String getMessage(){
		return super.getMessage();
	}
}
