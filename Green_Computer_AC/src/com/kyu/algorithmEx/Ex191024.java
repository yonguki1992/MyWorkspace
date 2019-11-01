package com.kyu.algorithmEx;

public class Ex191024 {
	public static void main(String[] args) {
		int num = 100;
		countAscendingNum(num);

		int ar[][] = {
				// (x좌표, y 좌표, x 좌표, y 좌표)
				{ 1, 2, 4, 4 },
				{ 2, 3, 5, 7 },
				{ 3, 1, 6, 5 },
				{ 7, 3, 8, 6 } 
		};

		boolean[][] field = new boolean[10][10];
		
		for (int k = 0; k < ar.length; ++k) {
			for (int i = ar[k][0]; i < ar[k][2]; ++i) {
				for (int j = ar[k][1]; j <
						ar[k][3]; ++j) {
					field[j][i] = true;
				}
			}
		}

		System.out.println();
		for (boolean[] bArr : field) {
			for (boolean arr : bArr) {
				System.out.print(String.format("%7s", arr));
			}
			System.out.println();
		}
		int count = 0;
		
		for (boolean[] bArr : field) {
			for (boolean arr : bArr) {
				if(arr) {
					count++;
				}
			}
		}
		System.out.println(count);

	}

	private static void countAscendingNum(int num) {
		int count = 0;
		for (int i = num; i < 1000; ++i) {
			if (i % 10 == 0) {
				continue;
			}
			if (isAscendingNum(i)) {
				count++;
			}
		}

		System.out.println(count);
	}

	private static boolean isAscendingNum(int num) {
		int reverseNum = getReverseNum(num);
		String ascendingNum = Integer.toString(num * reverseNum);
		boolean flag = false;
		int number = 0;
		// 자릿수가 점점 증가 의미 => 1 2 3 5 6 처럼 증가
		for (char charNum : ascendingNum.toCharArray()) {
			if (number > (charNum - '0')) {
				flag = false;
				break;
			}
			number = charNum - '0';
			flag = true;
		}
		return flag;
	}

	private static int getReverseNum(int num) {
		int reverseNum = 0;
		for (int i = num; i > 0; i /= 10) {
			reverseNum = reverseNum * 10 + i % 10;
		}
		return reverseNum;
	}
}
