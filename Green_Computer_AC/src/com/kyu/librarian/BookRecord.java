package com.kyu.librarian;

public class BookRecord {
	private String strTitleh;
	private String strAuthor;
	private int iQuantity;
	
	public BookRecord() {
		
	}
	public BookRecord(String strTitleh, String strAuthor, int iQuantity) {
		this.strTitleh = strTitleh;
		this.strAuthor = strAuthor;
		this.iQuantity = iQuantity;
	}
	public String getStrTitleh() {
		return strTitleh;
	}
	public String getStrAuthor() {
		return strAuthor;
	}
	public int getiQuantity() {
		return iQuantity;
	}
	
	
	public void setStrTitleh(String strTitleh) {
		this.strTitleh = strTitleh;
	}
	public void setStrAuthor(String strAuthor) {
		this.strAuthor = strAuthor;
	}
	public void setiQuantity(int iQuantity) {
		this.iQuantity = iQuantity;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "도서명 : " + this.strTitleh + "\n저자명 : " + this.strAuthor + "\n현재 수량 : " + this.iQuantity;
	}
}
