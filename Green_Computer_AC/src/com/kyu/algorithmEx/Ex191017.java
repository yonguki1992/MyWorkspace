package com.kyu.algorithmEx;

public class Ex191017 {
	/*
	 * 20150111 찍기
	 * 코드내에 숫자 x
	 * 파일 이름이나 경로 사용 x
	 * 시간, 날짜함수 사용 불가
	 * 에러번호 출력 이용 불가
	 */

	private static void number() {
		StringBuilder sb = new StringBuilder();
		char c_f = 'É';
		char c_s = 'ǵ';
		char c_l = '';
		sb.append((int)c_f).append((int)c_s).append((int)c_l);
		
		System.out.println(sb.toString());
	}
	
	/*
	 * ASCII art N
	 * 1 입력
	 * N
	 * 2
	 * NN
	 * NN
	 * 3 입력
	 * N N
	 * NNN
	 * N N
	 * 4
	 * N  N
	 * NN N
	 * N NN
	 * N  N
	 * 5 입력
	 * N   N
	 * NN  N
	 * N N N
	 * N  NN
	 * N   N
	 * 
	 * 
	 */
	private static void asciiArtN() {
		int n = 5;
		
		for(int i = 0; i < n; ++i) {
			System.out.print("N");
			for(int j = 1; j < n-1; ++j) {
				if(i == 0 || i == n-1) {
					System.out.print(" ");
				} else {
					if(i==j) {
						System.out.print("N");
						continue;
					}
					System.out.print(" ");
				}
				
			}
			if(n!=1)
				System.out.print("N");
			System.out.println();
		}
	}

	/*
	문제 3] CamelCase를 Pothole_case 로 바꾸기!
	파이썬과 같은 몇몇 프로그래밍 언어는 Pothole_case 를 더 선호하는 언어라고 합니다.
	Example:
	codingDojang --> coding_dojang
	numGoat30 --> num_goat_3_0
	위 보기와 같이 CameleCase를 Pothole_case 로 바꾸는 함수를 만들어요!
	 */
	public static void main(String[] args) {
		number();
		asciiArtN();
		StringBuilder sb = new StringBuilder();
	}

}


