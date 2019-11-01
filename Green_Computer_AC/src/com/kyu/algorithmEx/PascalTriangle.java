package com.kyu.algorithmEx;

import MyLib.ScannerFunctions;

public class PascalTriangle {
	public static void main(String[] args) {
		ScannerFunctions scf = new ScannerFunctions();
		int len = scf.inputNumber();

		int[][] arr = new int[len][len];

		// 삼각형 외곽 1로 채움
		for (int i = 0; i < len; ++i) {
			arr[i][0] = 1;
			arr[0][i] = 1;
		}

		for (int i = 1; i < len; ++i) {
			for (int j = 1; j < len - i; ++j) {
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
			}
		}
		
		for (int k = 0; k < len; ++k) {
			for (int i = 0; i < arr.length; ++i) {
				if(i == 0) {
					for (int cnt = 0; cnt < 3 * (arr.length - k); ++cnt)
						System.out.print(" ");
				}
				for (int j = 0; j < arr[i].length; ++j) {
					if (arr[i][j] != 0 && (i+j) == k)
						System.out.print((i==0)? arr[i][j] : String.format("%6d", arr[i][j]));
						//System.out.print(i+", " + j+" " + arr[i][j]);
				}

			}
			System.out.println();
		}
//		int n = 3;
//		String arg = "%"+n+"d";
//		System.out.println(String.format(arg, 1));
		scf.finalize();
	}

}
