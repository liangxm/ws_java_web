package com.lxm.lottery.wangyi.pojo;

public class DataSet {

	private String location;
	private String number;

	public DataSet(String location, String number) {
		super();
		this.location = location;
		this.number = number;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
