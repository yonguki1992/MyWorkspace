package com.kyu.algorithmEx;

import MyLib.ScannerFunctions;

public class primeOrComposite {
	public static void main(String[] args) {
		ScannerFunctions scf = new ScannerFunctions();
		String[] numbers = scf.inputTextLine().split(" ");
		
		for(String num : numbers) {
			primeNumTest(Integer.parseInt(num));
		}
	}

	private static void primeNumTest(int num) {
		boolean flag = false;		
		if(num == 1) {
			System.out.println(num + " 은 숫자 1입니다.");
			return;
		}
		for (int j = 2; j <= num / 2; ++j) {
			if (num % j == 0) {
				flag = true;
				System.out.println(num + " 은 소수가 아닙니다.");
				break;
			}
		}
		if(!flag) {			
			System.out.println(num + " 은 소수입니다.");
		}
	}
}
