package com.kyu.algorithmEx;

public class Test1010 {
	public static void main(String[] args) {
		int[] S1 = {1,3,4,8,13,17,20};
		int[] S2 = {1,3,7,8,13,17,20};
		test1(S1);
		test1(S2);
		
		int i = 100, j = 200;
		test2result(i, j);

	}

	private static void test2result(int i, int j) {
		int idx = 0;
		int max = 0;
		for(int k = i; k <= j; ++k ) {
			int result = test2(k);
			if(max < result) {
				max = result;
				idx = k;
			}
		}
		System.out.println("사이클의 최대 값은 : "+max+"("+idx+")");
	}
	
	// 1차원의 점들이 주어졌을 때, 그 중 가장 거리가 짧은 것의 쌍을 출력하는 함수를 작성하시오.(단, 점들은 모두 정렬 되어있다고 가정
	// S = {1,3,4,8,13,17,20} 이 주어졌다면 결과는 3,4
	private static void test1(int[] S) {
		
		int idx = 0;
		int dist = S[1] - S[0];
		for(int i = 0; i < S.length-1; ++i) {
			if(S[i+1] - S[i] < dist) {
				idx = i;
				break;
			}
		}
		System.out.println("최소 거리는 : "+S[idx]+", "+S[idx+1]);
	}
	
	
	// 3n+1 문제
	/*
	 *  어떤 정수 n에서 시작해, n이 짝수면 2로 나누고, 홀수면 3을 곱한다음 1을 더한다.
	 *  이렇게 해서 새로 만들어진 숫자를 n으로, n=1 이 될때까지 같은 작업을 계속 반복
	 *  n=22 이면 다음같은 수열이 만들어짐
	 *  22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1 
	 *  1이 나올때까지의 수의 갯수를 n의 싸이클이라고 한다
	 *  i와 j라는 두개의 수가 주어졌을 때, i와 j사이의 모든 수에대해 최대 사이클의 길이를 구하라.
	 */
	private static int test2(int n) {
		int cnt = 1;
		while(n > 1) {
			cnt++;
			//System.out.println(n);
			if(n%2==0) {
				n /= 2;
				continue;
			} else {
				n = 3*n + 1;
				continue;
			}
		}
		return cnt;
	}
}
