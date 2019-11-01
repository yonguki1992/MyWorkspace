package com.kyu.algorithmEx;

import java.util.Arrays;

public class NumofSubstring {
	
	public static void main(String[] args) {
					//	  , ,  1,  2,  3,  4,  5,  6,  7, 8, 9, 0
		String[] dial = " , ,abc,def,ghi,jkl,mno,pqr,stu,vw,xy,z".split(",");
		// 실제 내용 [ , ,abc,def,ghi,jkl,mno,pqr,stu,vw,xy,z]
		
		String code = "zazocqgzqiz";
		
		for(int i = 0; i < code.length(); ++i) {
			for(int idx = 0; idx < dial.length; ++idx) {
				if(dial[idx].contains(Character.toString(code.charAt(i)))) {
					System.out.print((idx-1)%10);
					break;
				}
			}
		}
		
	}
	
}
