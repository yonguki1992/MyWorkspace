package com.kyu.algorithmEx;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class JollyJumper {
	public static void main(String[] args) {
		int n = 4;
		int[] arr = {1,4,2,3};
		int[] arr2 = {1,4,2,-1,6};
		
		System.out.println(isJollyJumper(arr) ? "jolly jumper":"not jolly jumper");
		System.out.println(isJollyJumper(arr2) ? "jolly jumper":"not jolly jumper");
		
		System.out.println(asterisk("a1b2cde3~g45hi6"));
		System.out.println(ex3(1));
		System.out.println(ex3(3));
		System.out.println(ex3(5));
		System.out.println(ex3(7));
		System.out.println(ex3(1111));
		System.out.println(ex3(9901));
	}
	// 두수의 차의 절대값이 1 ~ n-1 까지의 값을 모두 가지면 그 수열을 Jolly jumper 라고 부른다
	private static boolean isJollyJumper(int[] arr) {
		Set<Integer> set = new TreeSet<Integer>();
		boolean flag = true;
		
		for(int i = 0; i < arr.length-1; ++i) {
			if(arr[i] > arr[i+1]) {
				set.add(arr[i]-arr[i+1]);
			} else {
				set.add(arr[i+1]-arr[i]);				
			}
		}
		int num = 1;
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			if(it.next()==num++) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	//모든 짝수번째 숫자를 *로 치환하시오 (홀수번째 숫자 또는 짝수번째 문자는 치환하면 안 됨)
	//"a1b2cde3~g45hi6" -> "a*b*cde*~g4*hi6"
	private static String asterisk(String str) {
		System.out.println("원래 값\n"+str);
		StringBuilder sb = new StringBuilder();
		char[] charArr = str.toCharArray();
		for(int i = 0; i < charArr.length; ++i) {
			if(i % 2!=0) {
				charArr[i] = (charArr[i] - '0' >= 0 && charArr[i] - '0' <= 9) ? '*' : charArr[i];
			}
			sb.append(charArr[i]);
		}
		return sb.toString();
	}
	
	//2나 5로 나눌수 없는 0 <= n <= 10000 의 정수중 10진수로 표기했을 때 모든 자리 숫자가 1인것이 있다. 
	//그러한 n의 배수중에서 가장 작은것은 몇자리 수 일까?
	
	/*
	 * 3, 7, 9, 
	 * 1
	 * 11
	 * 111
	 * 1111
	 * 11111
	 * 111111
	 */
	private static int ex3(int n) {
		if(n!=0 && n%2==0 ||n%5==0) {
			return 0;
		}
		long num = 1;
		while(num % n != 0) {
			num = 10*num+1;
		}
		
		return Long.toString(num).length();
	}
}
