package com.kyu.Addressbook;

public class Record {
	private String name;	//성명
	private String phNum; 	// 폰번
	private String address;	// 주소
	
	public Record() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhNum() {
		return phNum;
	}
	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
