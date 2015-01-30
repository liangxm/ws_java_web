package com.fm.dao.comn;

import java.util.UUID;



public class IDFacade {
	public static  String getPKID(){
		IDGenerator gen=new UUIDGenerator();
		return gen.getId();
	}
	
	public static UUID toUUID(String str){
		UUID uuid= UUID.fromString(str);
		return uuid;
	}

	
	public static void main(String[] args) {
		System.out.println(getPKID());
	}
	
}
                                 