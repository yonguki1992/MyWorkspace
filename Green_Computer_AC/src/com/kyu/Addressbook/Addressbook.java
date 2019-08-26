package com.kyu.Addressbook;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Vector;

public class Addressbook {
	protected Vector vecRs;
	protected DataInputStream dis;
	protected int imenu;
	private String filePath = System.getProperty("user.dir")+"\\etc\\AddressBook\\address.txt";
	
	public Addressbook() {
		vecRs = new Vector(50);
		dis = new DataInputStream(System.in);
	}

	public Addressbook(int size) {
		vecRs = new Vector(size);
		dis = new DataInputStream(System.in);
	}
	
	public Addressbook(int size, int incr) {
		vecRs = new Vector(size, incr);
		dis = new DataInputStream(System.in);
	}
	
	public void addRecord() {
		System.out.println("주소록 추가");
	}
	
	public void getRecord() {
		System.out.println("주소록 출력");	
	}

	public void delRecord(){
		System.out.println("주소록에서 삭제");	
		//return new Record();
	}
	
	public void displayMenu() {
		System.out.println("주소록 메뉴 출력");
	}
	
	public void saveAddressBook(String toSaveFile) {
		try {
			OutputStream output = new FileOutputStream(filePath);
			//String str = "Hello World";
			byte[] b = toSaveFile.getBytes("UTF-8");
			output.write(b);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
