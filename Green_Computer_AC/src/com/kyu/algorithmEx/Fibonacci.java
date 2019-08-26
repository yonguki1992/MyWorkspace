package com.kyu.algorithmEx;

public class Fibonacci {

	public static void main(String[] args) {
		int first = 0, second = 1;
		System.out.println("일반 for문 구조"
				+ "\n==================================");
		for (int i = 1; i <= 30; ++i) {
			System.out.print((i%5==1)?String.format("%6d", second):" "+String.format("%6d", second));
			second += first;
			first = second - first;
			if (i % 5 == 0)
				System.out.println();
		}
		System.out.println("\n순환 구조"
				+ "\n==================================");
		for (int i = 1; i <= 30; ++i) {
			System.out.print((i%5==1)?String.format("%6d", fibonacci(i)):" "+String.format("%6d", fibonacci(i)));
			if (i % 5 == 0)
				System.out.println();
		}
		
	}

	private static int fibonacci(int i) {
		if (i == 0)
			return 0;
		if (i == 1)
			return 1;
		return fibonacci(i-1) + fibonacci(i-2);
	}
	
}
