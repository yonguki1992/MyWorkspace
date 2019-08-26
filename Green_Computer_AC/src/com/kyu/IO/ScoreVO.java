package com.kyu.IO;

import java.io.Serializable;

public class ScoreVO implements Cloneable, Serializable, Comparable<ScoreVO> {
	private String name;
	private int kor, eng, math, edps, rank;
	public ScoreVO() {
		super();
		// TODO Auto-generated constructor stub
		name = "";
		rank = 1;
	}
	public ScoreVO(String name, int kor, int eng, int math, int edps) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.edps = edps;
		this.rank = 1;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEdps() {
		return edps;
	}
	public void setEdps(int edps) {
		this.edps = edps;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTot() {
		return kor+eng+math+edps;
	}
	public double getAvg() {
		return getTot()/4.0;
	}
	@Override
	public String toString() {
		return String.format("%-5s %5d %5d %5d %5d %6d %7.2f %3d", name, kor, eng, math, edps, getTot(), getAvg(), rank);
	}
	
	@Override
	public int compareTo(ScoreVO o) {
		// TODO Auto-generated method stub
		return this.getTot() - o.getTot();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + edps;
		result = prime * result + eng;
		result = prime * result + kor;
		result = prime * result + math;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rank;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScoreVO other = (ScoreVO) obj;
		if (edps != other.edps)
			return false;
		if (eng != other.eng)
			return false;
		if (kor != other.kor)
			return false;
		if (math != other.math)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rank != other.rank)
			return false;
		return true;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
