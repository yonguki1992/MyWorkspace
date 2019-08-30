package com.kyu.algorithmEx;

import MyLib.ScannerFunctions;

public class SnailSquare {

	public static void main(String[] args) {

		int cnt = new ScannerFunctions().inputNumber();

	}

	// 작성중
	private static void snailSquare02(int cnt) {
		int[][] arr = new int[cnt][cnt];
		int width = 0;
		int height = -1;
		int times = 0;
		int sw = 1;

		while (cnt > 0) {
			for (int i = 0; i < cnt; ++i) {
				height += sw;
				arr[width][height] = ++times;
			}

			cnt--;
			if (cnt == 0)
				continue;

			for (int j = 0; j < cnt; ++j) {
				width += sw;
				arr[width][height] = ++times;
			}

			sw *= -1;

		}

		for (int[] a : arr) {
			for (int b : a) {
				System.out.print(String.format("%3d", b));
			}
			System.out.println();
		}
	}

	private static void snailSqaure01(int cnt) {
		int[][] arr = new int[cnt][cnt];
		int width = 0;
		int height = -1;
		int times = 0;
		int sw = 1;

		while (cnt > 0) {
			for (int i = 0; i < cnt; ++i) {
				height += sw;
				arr[width][height] = ++times;
			}

			cnt--;
			if (cnt == 0)
				continue;

			for (int j = 0; j < cnt; ++j) {
				width += sw;
				arr[width][height] = ++times;
			}

			sw *= -1;

		}

		for (int[] a : arr) {
			for (int b : a) {
				System.out.print(String.format("%3d", b));
			}
			System.out.println();
		}
	}
}
