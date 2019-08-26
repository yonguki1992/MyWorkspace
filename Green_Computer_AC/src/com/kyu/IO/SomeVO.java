package com.kyu.IO;

import java.io.Serializable;

public class SomeVO implements Serializable, Cloneable {
	/**
	 * 시리얼 번호는 클래스의 버전 번호같은것.
	 * 선언해줄 것.
	 */
	private static final long serialVersionUID = 715334945614699515L;
	int data;
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "[" + data + "]";
	}

}
