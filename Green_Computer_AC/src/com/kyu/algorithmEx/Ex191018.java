package com.kyu.algorithmEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex191018 {


	/*
	 * 문제 1] 카드 역배치(2015년 KOI 지역본선 고등) 1부터 20까지 숫자가 하나씩 쓰인 20장의 카드가 아래 그림과 같이 오름차순으로
	 * 한 줄로 놓여있 다. 각 카드의 위치는 카드 위에 적힌 숫자와 같이 1부터 20까지로 나타낸다. 이제 여러분은 다음과 같은 규칙으로 카드의
	 * 위치 를 바꾼다: 구간 [a,b] (단, 1≤a≤b≤20) 가 주어지면 위치 a부터 위치 b까지의 카드를 현 재의 역순으로 놓는다. 예를
	 * 들어, 현재 카드가 놓인 순서가 위의 그림과 같고 구간이 [5,10]으로 주어진다면, 위치 5부터 위치 10까지의 카드
	 * 5,6,7,8,9,10을 역순으 로 하여 10,9,8,7,6,5로 놓는다. 이 상태에서 구간 [9,13]이 다시 주어진다면, 위치 9부터
	 * 위치 13까지의 카드 6,5,11,12,13 을 역순으로 하여 13,12,11,5,6으로 놓는다. 오름차순으로 한 줄로 놓여있는 20장의
	 * 카드에 대해 10개의 구간이 주어지면, 주어진 구간의 순 서대로 위의 규칙에 따라 순서를 뒤집는 작업을 연속해서 처리한 뒤 마지막 카드들의
	 * 배치를 구하 는 프로그램을 작성하시오. 
	 * 입력 예시:
		1 ~ 20 list
		
		1 20
		출력 예시: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
	 */
	private static void reverseCard(int a, int b, int[] cards) {
		for(int i = a-1; i < (b+a-1)/2 ; ++i) {
			cards[i] ^= cards[b-(i-a+1)-1];
			cards[b-(i-a+1)-1]^=cards[i] ;
			cards[i] ^= cards[b-(i-a+1)-1];
		}
	}

//	문제 2] Happy Number
//	== 문제 설명 ==
//	양의 정수 S0 의 각 아라비아 숫자들의 제곱의 합으로 양의 정수 S1을 만든다고 하자.
//	동일한 방법이라면, S1으로 S2를 만들 수 있고, 이 후로도 계속 만들 수 있다.
//	만약 어떤 i(i ≥ 1)에 대해서 Si = 1이라면, 최초의 S0를 Happy Number라고 부른다.
//	Happy Number가 아닌 수를 Unhappy Number라고 부른다.
//
//	예를 들어, 7에서 시작하게 되면 다음과 같은 일련의 순서를 가지게 되며
//	7, 49(=7^2), 97(=4^2+9^2), 130(=9^2+7^2), 10(=1^2+3^2), 1(=1^2),
//	따라서 7은 즐거운 수이다.
//	그리고 4는
//	4, 16(4^2), 37(1^2+6^2), 58(3^2+7^2), 89(5^2+8^2), 145(8^2+9^2),
//	42(1^2+4^2+5^2), 20(4^2+2^2), 4(2^2)의 순서로 반복되므로 Unhappy Number이다.
//	== 입력 ==
//	첫 라인은 인풋 케이스의 수 n이 주어지며 이후 n라인의 케이스가 주어진다.
//	각 테스트 케이스는 한 개의 양의 정수 N으로 구성되며 N은 10^9 보다 작다.
//	== 출력 ==
//	출력은 주어진 수 N이 Happy Number인지 Unhappy Number인지 여부에 따라 다음과 같이 출력한다.
//	N이 Happy Number라면 “Case #p: N is a Happy number.”
//	N이 Unhappy Number라면 “Case #p: N is an Unhappy number.”
//	p는 1부터 시작하는 케이스의 번호이며 각각의 케이스는 한 줄에 결과를 표시한다.
//	== 샘플 인풋 ==
//	3
//	7
//	4
//	13
//	== 샘플 출력 ==
//	Case #1: 7 is a Happy number.
//	Case #2: 4 is an Unhappy number.
//	Case #3: 13 is a Happy number.
	
	
	
	public static void main(String[] args) {	
//		int[] cards = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
//		System.out.println(Arrays.toString(cards));
//		reverseCard(1, 1, cards);
//		reverseCard(2, 2, cards);
//		reverseCard(3, 3, cards);
//		reverseCard(4, 4, cards);
//		reverseCard(5, 5, cards);
//		reverseCard(6, 6, cards);
//		reverseCard(7, 7, cards);
//		reverseCard(8, 8, cards);
//		reverseCard(9, 9, cards);
//		reverseCard(10, 10, cards);
//		System.out.println(Arrays.toString(cards));	
//		reverseCard(1, 20, cards);
//		System.out.println(Arrays.toString(cards));
//		reverseCard(2, 10, cards);
//		System.out.println(Arrays.toString(cards));

		int input = 12;
		int result = input;
		List<Integer> list = new ArrayList<Integer>();
		
		while(result != 1) {
			
			String number = Integer.toString(result);
			result = 0;
			for(char num : number.toCharArray()) {
				result += (num - '0')*(num - '0'); 
			}
			list.add(result);
			System.out.println(result);
			if(list.contains(result)) {
				break;
			}
		}
		System.out.println(result == 1?"happy number":"Unhappy number");
	}


}
