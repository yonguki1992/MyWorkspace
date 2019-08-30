package com.kyu.algorithmEx;

import MyLib.ScannerFunctions;

public class Exam {

	public static void main(String[] args) {
		ScannerFunctions scf = new ScannerFunctions();
		int num = scf.inputNumber();
		int sum = num;
		String strNum = Integer.toString(num);
		while ((strNum.length() - 1) != 0) {
			sum = 0;
			
			for (int i = 0; i < strNum.length(); i++) {
				sum += Integer.parseInt(strNum.substring(i, i + 1));
			}
			num = sum;
			strNum = Integer.toString(num);
		}

		System.out.println(num);

	}

}
