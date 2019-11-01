package com.kyu.algorithmEx;

import java.util.ArrayList;
import java.util.List;

public class JosephusPloblems {

	//n 까지의 숫자를 돌아가면서 k번째에 위치한 수를 제거
	/*
	 * ex n = 10, k = 3
	 * 1 2 (3) 4 5 (6) 7 8 (9) 10
	 * 							1 (2) 4 5 (7) 8 10
	 *  										(1) 4 5 (8) 10
	 *    													4 (5) 10
	 *        														4 (10)
	 */

	public static void main(String[] args) {
		int n = 10, k = 3;
		joseph1(n, k);
		System.out.println(joseph2(n, k));
		System.out.println(printerTest(1, 1, 5));
		System.out.println(printerTest(3, 5, 4));
		
	}

	public static int joseph2(int n, int k) {
		return  (n == 1)? 1 : (joseph2(n - 1, k) + k - 1) % n + 1;
	}
	
	private static void joseph1(int n, int k) {
		List<Integer> soldiers = new ArrayList<Integer>();
		
		for(int i = 0; i < n; ++i) {
			soldiers.add(i+1);
		}
		int idx = 0;
		int cnt = 0;
		
		while(soldiers.size() > 1) {
			if((cnt+1)%k == 0) {
				System.out.print((idx+1)+" : ");
				System.out.println(soldiers.remove(idx));
				System.out.println(soldiers);
				idx--;
			}
			idx = ++idx%soldiers.size();
			cnt++;
		}
		System.out.println("남은 병사 : "+soldiers);
	}
	
	/*
	문제 2] Two Printers
	John과 Mary는 "J&M 출판사"를 설립하고 낡은 프린터 2대를 구입하였다.
	그들이 첫번째로 성사시킨 거래는 N개의 페이지로 구성된 문서를 출력하는 일이었다.
	그들이 구입한 두 대의 프린터는 각기 다른 속도록 문서를 출력하고 있다고 한다. 
	하나는 한 페이지를 출력하는 데 X초가 걸리고 다른 하나는 Y초가 소요된다고 한다.
	John과 Mary는 두 대의 프린터를 이용하여 전체 문서를 출력하는 데 드는 최소한의 시간이 알고 싶어졌다.

	입력과 출력
	입력데이터의 첫번 째 라인은 테스트케이스의 갯수를 뜻하고 그 갯수만큼의 라인이 추가로 입력된다. 
	추가되는 각 라인은 세 개의 정수값 X Y N 으로 구성된다. 
	X는 첫번째 프린터가 한 페이지를 출력하는 데 드는 소요시간, 
	Y는 두번째 프린터가 한 페이지를 출력하는 데 드는 소요시간을 뜻하고 
	N은 출력할 문서의 총 페이지 수를 의미한다. 
	(단, 출력할 문서의 총 페이지 수는 1,000,000,000개를 초과하지 않는다.)
	출력은 프린팅에 드는 최소한의 시간을 테스트케이스의 갯수만큼 공백으로 구분하여 출력하도록 한다.

	입출력의 예는 다음과 같다:
	input data:
	2
	1 1 5
	3 5 4
	answer:
	3 9
	 */
	private static int printerTest(int x, int y, int n) {
		int time = 1;
		while((time/x+time/y)<n) {
			time++;
		}
		return time;
	}
}
