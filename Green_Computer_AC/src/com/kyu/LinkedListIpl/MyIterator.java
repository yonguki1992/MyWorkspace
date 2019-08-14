package com.kyu.LinkedListIpl;


public class MyIterator implements LinkIterator {
	
	private Linkable first_ptr;	// 처음 포인트
	private Linkable tmp_ptr;	// 커서 포인트
	
	public MyIterator(Linkable first_ptr) {
		this.first_ptr = first_ptr;
		first();
	}
	
	@Override
	public void first() {
		//처음 노드로 이동
		this.tmp_ptr = this.first_ptr;
	}
	@Override
	public Linkable next() {
		// 현재 노드의 레퍼런스 반환하고 다음 노드로 포인터 변경
		
		Linkable node = tmp_ptr;
		if(node == null) {
			return null;
		} else {
			tmp_ptr = node.next();
			return node;
		}
	}
}

interface LinkIterator {
	void first();
	Linkable next();
}