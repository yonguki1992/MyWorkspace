package com.kyu.test;

import java.text.ChoiceFormat;
import java.util.Iterator;


public class Students {
	
	private String ID;
	private int score = -1;
	private String grades;
	private int rank;
	private Achievement achive = Achievement.getInstance();
	
	
	public Students(String ID) {
		this.ID = ID;
	}
	
	public Students(String ID, int score) {
		setID(ID);
		setScore(score);
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		if(score < 0 || score > 100) {
			this.score = -1;
		}
		this.score = score;
		setGrades(score);
	}
	
	public void setGrades(int score) {
		if(score == -1) {
			return;
		}
		
		String pattern = "60#D|70#C|80<B|90#A";
		ChoiceFormat form = new ChoiceFormat(pattern);
		
		this.grades = form.format(score);
	}
	
	public String getGrades() {
		return this.grades;
	}
	
	public int getRank() {
		int cnt = 1;
		Achievement a = Achievement.getInstance();
		Iterator i1 = a.getsList().iterator();
	
		while(i1.hasNext()) {	
			Students s1 = (Students)i1.next();
			if(this.score < s1.score) {
				++cnt;
			}			
		}
		return this.rank = cnt;
	}
}