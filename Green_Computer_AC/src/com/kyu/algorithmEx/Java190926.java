package com.kyu.algorithmEx;

import MyLib.ScannerFunctions;

public class Java190926 {
	public static void main(String[] args) {

		for (int i = 0; i < 33; ++i) {
			long num = fibonacci(i);
			if (num % 2 == 0)
				System.out.println(num);
		}

		// getPerfectNum();
		// fibonacciEvenNum();

	}

	private static void fibonacciEvenNum() {

		long num2 = 0;
		int count = 1;
		long sum = 0;
		while (num2 <= 4_000_000) {

			if ((num2 = fibonacci(count++)) % 2 == 0) {
				sum += num2;
			}
		}
		System.out.println("피보나치 수열 중 짝수이면서 4백만 이하의 총 합은 : " + sum);
	}

	private static long fibonacci(long num) {
		if (num <= 1) {
			return 1;
		} else {
			return fibonacci(num - 1) + fibonacci(num - 2);
		}
	}

	private static void getPerfectNum() {
		ScannerFunctions scf = new ScannerFunctions();
		System.out.print("숫자를 하나 입력해 주십시오. > ");
		int num = scf.inputNumber();

		for (int n = 1; n <= num; ++n) {
			int sum = 0;
			for (int i = 1; i <= n / 2; ++i) {
				if (n % i == 0) {
					sum += i;
				}
			}
			if (sum == n) {
				System.out.println(n + " 은 완전수");
			}
		}
		scf.finalize();
	}
}
