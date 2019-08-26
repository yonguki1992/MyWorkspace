package com.kyu.algorithmEx;

import MyLib.ScannerFunctions;

public class PrimeNum {

	public static void main(String[] args) {
		ScannerFunctions sc = new ScannerFunctions();
		view1(sc.inputNumber());
		System.out.println();
		view2(sc.inputNumber());
		
		sc.finalize();
	}
	
	//2 ~ n 까지 소수 출력하기(향상된 버전)
	private static void view2(int n) {
		int cnt = 0;
		loop : for (int i = 2; i <= n; ++i) {
			for (int j = 2; j <= i/2; ++j) 
				if (i % j == 0) 
					continue loop;
			System.out.print(String.format("%3d", i));
			if (++cnt % 5 == 0)
				System.out.println();
		}
	}

	// 2 ~ n 까지 소수 출력하기
	private static void view1(int n) {
		boolean flag = false;
		int cnt = 0;
		for (int i = 2; i <= n; ++i) {
			flag = true;
			for (int j = 2; j <= i / 2; ++j) 
				if (i % j == 0) {
					flag = false;
					break;
				}

			if (flag == true) {
				System.out.print(String.format("%3d", i));
				if (++cnt % 5 == 0)
					System.out.println();
			}
		}
	}

}
