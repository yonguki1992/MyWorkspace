package com.kyu.librarian;

public class BookRecordSetIterator implements CustomIterator {
	private BookRecordSet brs;
	private int index;
	
	public BookRecordSetIterator() {
		// TODO Auto-generated constructor stub
		this(new BookRecordSet());
	}

	public BookRecordSetIterator(BookRecordSet brs) {
		// TODO Auto-generated constructor stub
		if(brs != null) {
			this.brs = brs;
			this.index = 0;
		} else {
			this.brs = new BookRecordSet();
			this.index = 0;
		}
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(brs.size() > index) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Object next() {
		// TODO Auto-generated method stub
		// 다음 인덱스가 비어있으면 nullPointerException 발생 가능성 있으니 처리함
		if(hasNext()) {
			return brs.getBookRecord(this.index++);	
		} else {
			this.index = 0;
			return brs.getBookRecord(0);
		}
	}
	
	
}
