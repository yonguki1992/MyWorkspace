package com.kyu.algorithmEx;

import MyLib.ScannerFunctions;

public class FindPath {
	public static void main(String[] args) {
		int[][] arr2 = init(5);

		System.out.println();
		for (int k = 0; k < 5; ++k) {
			for (int i = 0; i < 5; ++i) {
				for (int j = 0; j < 5; ++j) {

					if ((i + j) == k) {
						if (i == 0) {
							for (int n = 5 - k; n >= 0; --n) {
								System.out.print(" ");
							}
						}
						System.out.print(i!=0?" "+arr2[j][i]:arr2[j][i]);
					}
				}
			}
			System.out.println();
		}

		System.out.println();
		for (int[] a : arr2) {
			for (int b : a) {
				System.out.print(b);
			}
			System.out.println();
		}

		int sum = 0;
		int row = 0, col = 0;
		while ((row + col) < 4) {
			if (arr2[row + 1][col] >= arr2[row][col + 1]) {
				sum += arr2[row + 1][col];
				row++;
			} else if (arr2[row + 1][col] < arr2[row][col + 1]) {
				sum += arr2[row][col + 1];
				col++;
			}
		}

		System.out.println(sum);
	}

	private static int[][] init(int length) {
		int[][] arr = new int[length][length];
		ScannerFunctions scf = new ScannerFunctions();

		for (int k = 0; k < length; ++k) {
			System.out.println((k + 1) + "열");

			for (int i = 0; i < length; ++i) {
				for (int j = 0; j < length; ++j) {
					if ((i + j) == k) {
						arr[j][i] = scf.inputNumber();
					}
				}
			}

		}
		scf.finalize();
		return arr;
	}
}
