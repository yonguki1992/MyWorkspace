package com.kyu.LinkedListIpl;

public class Node implements Linkable {
	private Linkable nextNode;
	private String name;
	private String phNum;
	
	@Override
	public Linkable next() {
		// TODO Auto-generated method stub
		return nextNode;
	}
	
	@Override
	public void next(Linkable node) {
		//새로운 노드를 자신의 다음 노드로 지정
		nextNode = node;
	}
	
	public void setData(String name, String phNum) {
		this.name = name;
		this.phNum = phNum;
		
	}
	
	public String getName() {
		return name;
	}
	public String getPhNum() {
		return phNum;
	}
	
}

interface Linkable {
	
	Linkable next();
	void next(Linkable node);

}