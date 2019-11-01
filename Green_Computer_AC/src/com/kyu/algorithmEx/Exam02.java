package com.kyu.algorithmEx;

import org.apache.commons.lang3.StringUtils;

import MyLib.ScannerFunctions;

public class Exam02 {
	public static void main(String[] args) {
//		number();
		moonja();
		

	}

	private static void moonja() {
		ScannerFunctions scf = new ScannerFunctions();

		String str = StringUtils.EMPTY;
		
		while(true) {
			int[] numArr = new int[26];
			System.out.println("소문자로 이뤄진 문자를 입력해주세요 0은 종료");
			str = scf.inputText();
			if(StringUtils.equals(str, "0"))
				break;
			
			System.out.println("입력한 문자 : " + str);
			
			for(int i = 0; i < str.length(); ++i) 
				numArr[(str.charAt(i) - 'a')]++;
			
			for(int i = 0; i < numArr.length; ++i) {
				if(numArr[i] !=0)
					System.out.println((char)(i+'a')+":"+numArr[i]);
			}
		}
	}

	private static void number() {
		ScannerFunctions scf = new ScannerFunctions();
		
		int a = 0, b = 0, c = 0;
		String mult = StringUtils.EMPTY;
		
		while(true) {
			int[] numArr = new int[10];
			
			System.out.println("숫자를 입력해주세요 0은 종료");
			a = scf.inputNumber();
			if(a == 0)
				break;
			b = scf.inputNumber();
			if(b == 0)
				break;
			c = scf.inputNumber();
			if(c == 0)
				break;
			mult = Integer.toString(a*b*c);
			
			System.out.println("계산결과 : " + mult);
			
			for(int i = 0; i < mult.length(); ++i) 
				numArr[(mult.charAt(i) - '0')]++;
			
			for(int i = 0; i < numArr.length; ++i) {
				if(numArr[i] !=0)
					System.out.println(i+":"+numArr[i]);
			}
		}
	}
}
