package com.kyu.LinkedListIpl;

public class MyList implements Aggregate{
	
	private Linkable first_ptr = null;	// 첫 포인트 레퍼런스
	private Linkable last_ptr = null;	// 마지막 포인트 레퍼런스
	private Node first_node = new Node();	// 첫 노드 레퍼런스
	private Node last_node = new Node();	// 마지막 노드 레퍼런스


	public void append(Linkable node) {
		if(first_ptr == null) {	//링크드 리스트가 비었을 때
			this.last_ptr = this.first_ptr = node;
			this.last_node = this.first_node = (Node)node;
			
			return;
		}
		
		this.last_node.next(node);
		this.last_ptr = node;
		this.last_node = (Node)node;
	}
	
	@Override
	public MyIterator customIterator() {
		// TODO Auto-generated method stub
		if(first_ptr == null) {
			return null;
		}
		return new MyIterator(first_ptr);
	}
	
}

interface Aggregate {
	LinkIterator customIterator();
}




