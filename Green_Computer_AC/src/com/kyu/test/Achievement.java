package com.kyu.test;

import java.util.ArrayList;
import java.util.Iterator;
import static java.lang.System.*;

import org.apache.commons.lang3.StringUtils;

public class Achievement {
	public static final int TOTAL_NUM_OF_STUDENT = 10;
	private static int numOfStudent = 0;
	private static Achievement instance;
	private ArrayList sList = new ArrayList();
	private Iterator i;

	// 인스턴스 단 하나만 생성 가능
	private Achievement() {
	}

	public static Achievement getInstance() {
		if (instance == null) {
			return instance = new Achievement();
		}
		return instance;
	}

	public static int getNumOfStudent() {
		return numOfStudent;
	}

	public int getScore(String ID) {
		Iterator i = sList.iterator();
		while(i.hasNext()) {
			Students s = (Students)i.next();
			if(StringUtils.equals(s.getID(), ID)) {
				return s.getScore();
			}
		}
		return -1;
	}

	public int getRank(String ID) {
		Iterator i = sList.iterator();
		while(i.hasNext()) {
			Students s = (Students)i.next();
			if(StringUtils.equals(s.getID(), ID)) {
				return s.getRank();
			}
		}
		return -1;
	}
	
	public String getGrades(String ID) {
		
		Iterator i = sList.iterator();
		while(i.hasNext()) {
			Students s = (Students)i.next();
			if(StringUtils.equals(s.getID(), ID)) {
				return s.getGrades();
			}
		}
		return "null";
	}
	
	public boolean setsList(String ID, int score) {
		// ID로 먼저 검색하고
		// 없으면 새로 만들기
		// 있으면 ID찾아서 score 입력
		if(isFull()) {
			return false;
		}
		i = sList.iterator();

		while (i.hasNext()) {
			Students s = (Students) i.next();
			// 등록된 ID가 있는지 검사.
			if(StringUtils.equals(s.getID(), ID)) {
				if (score <= -1) {
					out.println("이미 등록된 학번입니다.");
					return false;
				} else {
					out.println("시험 점수가 변경되었습니다.");
					s.setScore(score);
					return true;
				}
			}
		}
		// ID가 아직 등록되지 않았음.
		sList.add(new Students(ID, score));
		numOfStudent++;
		return true;
	}
	
	public boolean setsList(String ID) {
		// ID로 먼저 검색하고
		// 없으면 새로 만들기
		// 있으면 중복 ID안됨 경고
		return setsList(ID, -1);
	}

	public ArrayList getsList() {
		return sList;
	}

	public boolean isInputEnd(String ID) {
		i = sList.iterator();
		while (i.hasNext()) {
			Students s = (Students) i.next();
			if (StringUtils.equals(s.getID(), ID)) {
				if(s.getScore() != -1) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean hasID(String ID) {
		i = sList.iterator();
		while (i.hasNext()) {
			Students s = (Students) i.next();
			if (StringUtils.equals(s.getID(), ID)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isFull() {
		if (sList.size() < TOTAL_NUM_OF_STUDENT) {
			return false;
		} else {
			return true;
		}
	}

}
