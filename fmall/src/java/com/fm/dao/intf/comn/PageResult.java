package com.fm.dao.intf.comn;

import java.util.List;

public interface PageResult<T>{

	public int getPageSize() ;
	public int getCurrentPage() ;
	public int getTotalPage() ;
	public int getTotalCount() ;
	public List<T> getList() ;

	
	
}
