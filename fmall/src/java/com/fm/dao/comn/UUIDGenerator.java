package com.fm.dao.comn;

import java.util.UUID;



public  class UUIDGenerator implements IDGenerator{

	public String getId() {
		
		return UUID.randomUUID().toString();
	}
	                                            
}
