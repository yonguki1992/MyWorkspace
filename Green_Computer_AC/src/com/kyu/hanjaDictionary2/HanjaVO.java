package com.kyu.hanjaDictionary2;

public class HanjaVO {
	private int idx;
	private String h;
	private String k;
	private String m;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getH() {
		return h;
	}
	public void setH(String h) {
		this.h = h;
	}
	public String getK() {
		return k;
	}
	public void setK(String k) {
		this.k = k;
	}
	public String getM() {
		return m;
	}
	public void setM(String m) {
		this.m = m;
	}
	@Override
	public String toString() {
		return idx + ". " + h + "(" + m + ")";
	}
	
}
