package com.kyu.algorithmEx;

import java.util.Arrays;

public class GoogleInterview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { -1, 1, 3, -2, 2,-10};
		int[] sort = new int[num.length];
		int pointer = -1;
		
		while (pointer != num.length-1) {
			for (int ar : num) {
				if (ar < 0) {
					sort[++pointer] = ar;
				}
			}

			for (int ar : num) {
				if (ar >= 0) {
					sort[++pointer] = ar;
				}
			}
		}
		
		
		System.out.println(Arrays.toString(num));
		System.out.println(Arrays.toString(sort));
	}

}
