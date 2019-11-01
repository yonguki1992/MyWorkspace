package com.kyu.algorithmEx;

import java.util.Arrays;

public class Sum1to1000 {

	public static void main(String[] args) {
		// 1 ~ 1000 까지 각 자리의 전체 합
		// 1 ~ 1000 까지 각 자리의 갯수 함
		// % 연산자 활용할 것

		int sum = 0;
		int[] number = new int[10];
		for (int i = 1; i <= 1000; ++i) {
			int tmp = i;
			while (tmp > 0) {
				int remainder = tmp%10;
				++number[remainder];
				sum += remainder;
				System.out.print(remainder + " ");
				tmp /= 10;
			}
			System.out.println();
		}
		
		System.out.println(sum);
		System.out.println(Arrays.toString(number));
	}

}
