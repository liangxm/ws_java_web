package com.fm.util.errcode;

public class ErrCode {
	/*
	 * 组成的错误码最终是这样的：INDA001;代表保险模块数据库通用错误
	 */
	
	/**************************************业务模块前缀字符串************************************/
	public static final String AL="AL";/*所有业务模块*/
	public static final String IN="IN";/*保险模块*/
	/**************************************数据库错误码前缀************************************/
	public static final String DA="DA";/*数据库错误码前缀*/
	/**************************************服务层错误码前缀************************************/
	public static final String SE="SE";/*服务层错误码前缀*/
	/**************************************Controller错误码前缀************************************/
	public static final String CO="CO";/*controller错误码前缀*/ 
	
	
	/**************************************数据库错误范围001-030************************************/
	public static final String DAE="001";/*数据库通用错误*/
	
}
