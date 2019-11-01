package com.kyu.algorithmEx;

public class EulerProject {
	
	public static void main(String[] args) {
		//100까지 자연수의 함과 제곱의 함의 차이
		//
		int sum = 0;
		for(int i=1; i <= 100; ++i) {
			sum+= i*(i-1);
		}
		System.out.println(sum);
		
		
		//시저 암호 풀기
		//
		
		
		
		//3. 2진법으로 자연수 나타내기
		StringBuilder sb = new StringBuilder();
		int num = 10;	//0000 0000 0000 1010
		
		int filter = 0x8000;	//1000 0000 0000 0000
		for(int i = 0; i < 16; ++i) {
			sb.append(((num&filter) == filter) ? "1" : "0");
			filter >>= 1;
		}
		System.out.println(sb.toString());
	}
	
}
