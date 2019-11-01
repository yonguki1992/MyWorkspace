package com.kyu.algorithmEx;

import java.util.Arrays;

public class NotOverlaped {

	public static void main(String[] args) {
		/*
		 * 중복인 숫자가 있으면 false
		 * 중복된 숫자가 없으면 true
		 * ex) 0123456 01123465 01223456 0124769
		 * 		true	false	false		true
		 */

		 String[] strArr = {"0123456", "01123465", "01223456", "0124769"};
		 boolean[] result = new boolean[strArr.length];
		 int[] number = {};	//0~9 까지 중복확인할 숫자 배열
		 
		 for(int i = 0; i <strArr.length; ++i) {
			 number =  new int[10];
			 boolean flag = true;
			 
			 for(char ch : strArr[i].toCharArray()) {
				 if(number[(ch - '0')] == 0) {
					 ++number[(ch - '0')];
				 } else {
					 flag = false;
					 break;
				 }
			 }
			 
			 result[i] = flag;			 
			 System.out.println(strArr[i] + " 의 중복확인 값"+ result[i]);
		 }
		 
		 System.out.println(Arrays.toString(result));
		
	}

}
