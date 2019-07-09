package Homework;

import static java.lang.System.*;

public class Firstweek {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		answer();
	}

	// 1 ~ 100 합
	static int begginer01() {
		int aStart = 1, aEnd = 100;
		return (aEnd - aStart + 1) * (aStart + aEnd) / 2;
	}

	// 1 ~ 100 까지 홀수/짝수 합
	static int begginer02() {
		int sum = 0;
		for (int i = 1; i <= 100; ++i) {
			if (i % 2 == 1) {
				sum += i;
			}
		}
		return sum;
	}

	// 1 ~ 100 까지 홀수의 제곱의 합
	static int begginer03() {
		int sum = 0;
		for (int i = 0; i < 100; ++i) {
			if (i % 2 == 1) {
				sum += i * i;
			}
		}
		return sum;
	}

	// 1 ~ 100 까지 n*(-1)^(n-1) 의 합
	static int begginer04() {
		int sum = 0;
		boolean sw = false;
		for (int i = 1; i <= 100; ++i) {
			if (!sw) {
				sw = true;
				sum += i;
				continue;
			}
			sum -= i;
			sw = false;
		}
		return sum;
	}

// 1 ~ 10항 까지 (n^2 - n + 2) / 2 의 합
	static int begginer05() {
		int a[] = new int[10];
		int sum = 0;
		for (int i = 0; i < a.length; ++i) {
			a[i] = (i * i + i + 2) / 2;
			sum += a[i];
		}
		return sum;
	}

	// 1 ~ 10항까지 (n^2 + n)/2 의 합
	static int begginer06() {
		int a[] = new int[10];
		int sum = 0;
		for (int i = 0; i < a.length; ++i) {
			a[i] = (i * i + 3 * i + 2) / 2;
			sum += a[i];
		}
		return sum;
	}

	// 1~100 까지 곱
	static int begginer07() {
		int mul = 1;
		for (int i = 0; i < 10; ++i) {
			mul *= i + 1;
		}
		return mul;
	}

	// 1 ~ 49 까지 n/n+1 의 합
	static float begginer08() {
		float sum = 0.0f;
		for (int i = 1; i <= 49; ++i) {
			sum = sum + (float) i / (i + 1);
		}
		return sum;
	}

	// 피보나치 일반항
	static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	// 피보나치 1 ~ 10 항 까지 합
	static int begginer09() {
		int sum = 0;
		for (int i = 1; i <= 10; ++i) {
			sum += fibonacci(i);
		}
		return sum;
	}

	// 정답 출력하는 함수
	static void answer() {
		out.append("1번 > " + Integer.toString(begginer01()) + "\n")
		.append("2번 > " + Integer.toString(begginer02()) + "\n")
		.append("3번 > " + Integer.toString(begginer03()) + "\n")
		.append("4번 > " + Integer.toString(begginer04()) + "\n")
		.append("5번 > " + Integer.toString(begginer05()) + "\n")
		.append("6번 > " + Integer.toString(begginer06()) + "\n")
		.append("7번 > " + Integer.toString(begginer07()) + "\n")
		.append("8번 > " + Float.toString(begginer08()) + "\n")
		.append("9번 > " + Integer.toString(begginer09()) + "\n").flush();
		out.close();
	}
}