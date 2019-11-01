package com.kyu.algorithmEx;

import java.util.Arrays;

import MyLib.ScannerFunctions;

public class YonseiAndKoreaUniv {
	/*
	 * 첫째줄 테스트 케이스를 의미하는 자연수 T
	 * T개의 테스트 케이스가 주어짐
	 * 각 테스트 케이스는 9줄에 걸쳐서 입력되며, 매줄마다 연세대 Y와 고려대 K 의 득점이 공백으로 주어짐
	 * 단, 0 ~ 9 사이의 숫자
	 */
	public static void main(String[] args) {
		int t = 0;
		final int Y = 0, K = 1;
		int[] y = new int[9], k = new int[9];
		
		ScannerFunctions scf = new ScannerFunctions();
		System.out.print("테스트 케이스를 입력하시오 > ");
		t = scf.inputNumber();
		scf.inputTextLine();
		
		for(int i = 0; i < 9; ++i) {
			String[] tCase = scf.inputTextLine().split(" ");
			//System.out.println(Arrays.toString(tCase));
			y[i] = Integer.parseInt(tCase[Y]);
			k[i] = Integer.parseInt(tCase[K]);
		}
		
		System.out.println(t+" 건의 경기 결과 ");
		for(int i = 0; i < t; ++i) {
			if(y[i] > k[i]) {			
				System.out.println("연세대의 승리");
			} else if(y[i] < k[i]) {
				System.out.println("고려대의 승리");
			} else {
				System.out.println("비김");
			}
		}
		
	}

}
