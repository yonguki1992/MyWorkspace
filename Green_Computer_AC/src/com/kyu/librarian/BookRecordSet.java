package com.kyu.librarian;

public class BookRecordSet implements Aggregate {
	private BookRecord[] brSet;
	private int iLast=0;
	
	public BookRecordSet() {
		// TODO Auto-generated constructor stub
		this(50);
	}

	public BookRecordSet(int index) {
		// TODO Auto-generated constructor stub
		brSet = new BookRecord[index];
	}
	
	public BookRecord getBookRecord(int index) {
		return this.brSet[index];
	}
	
	public void appendBookRecord(BookRecord book) {
		this.brSet[iLast++] = book;
	}
	
	public int size() {
		return iLast;
	}
	
	//객체 배열을 순회하여 조회하기 위한 열거자 얻어오기
	@Override
	public CustomIterator customIterator() {
		// TODO Auto-generated method stub
		return new BookRecordSetIterator(this);
	}
}
