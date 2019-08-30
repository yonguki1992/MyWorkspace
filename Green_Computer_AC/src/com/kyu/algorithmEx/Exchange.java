package com.kyu.algorithmEx;

import MyLib.ScannerFunctions;

public class Exchange {
	public static void main(String[] args) {
		int[] m = {100_0000, 10_0000, 5_0000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		
		ScannerFunctions scf = new ScannerFunctions();
		
		while(true) {
			
			System.out.print("월급 입력하시오(0이면 종료) > ");
			int num = scf.inputNumber();
			if(num == 0) break;
			
			for(int i = 0; i < m.length; ++i) {
				System.out.println(String.format("%10d원권 : %5d매", m[i], num/m[i]));
				num = num%m[i];
			}
			
		}
		
		scf.finalize();
		
	}
}
