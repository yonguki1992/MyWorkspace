package Homework;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class Thirdweek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		intermediate03();
	}

	static void example5_03() {
		int[] arr = { 10, 20, 30, 40, 50 };
		int sum = 0;

		for (int num : arr) {
			sum += num;
		}

		out.println("sum=" + sum);
	}

	static void example5_04() {
		int[][] arr = { 
				{ 5, 5, 5, 5, 5 }, 
				{ 10, 10, 10, 10, 10 },
				{ 20, 20, 20, 20, 20 }, 
				{ 30, 30, 30, 30, 30 } 
				};
		int total = 0;
		float average = 0;

		int num = 0;
		for (int[] i : arr) {
			for (int j : i) {
				total += j;
				++num;
			}
		}
		average = (int) (((float) total / num) * 100 + 0.5) / 100f;

		out.println("total=" + total);
		out.println("average=" + average);
	}

	static void example5_05() {
		int[] ballArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] ball3 = new int[3];
		for (int i = 0; i < ballArr.length; i++) {
			int j = (int) (Math.random() * ballArr.length);
			int tmp = 0;

			tmp = ballArr[i];
			ballArr[i] = ballArr[j];
			ballArr[j] = tmp;
		}

		for (int i = 0; i < ball3.length; i++) {
			ball3[i] = ballArr[i];
		}

		for (int i = 0; i < ball3.length; i++) {
			out.print(ball3[i]);
		}
	}

	static void example5_06() {
		int[] coinUnit = { 500, 100, 50, 10 };
		int money = 2680;

		out.println("money=" + money);
		for (int i = 0; i < coinUnit.length; i++) {
			out.println(coinUnit[i] + "원 : " + money / coinUnit[i]);
			money %= coinUnit[i];
		}
	}

	static void example5_07() {
		int money = 3200;
		int[] coinUnit = { 500, 100, 50, 10 };
		int[] coin = { 5, 5, 5, 5 };

		out.println("money=" + money);
		for (int i = 0; i < coinUnit.length; i++) {
			int coinNum = 0;

			coinNum = money / coinUnit[i];
			if (coinNum > coin[i]) {
				coinNum = coin[i];
				money -= coinNum * coinUnit[i];
			} else {
				money -= coinNum * coinUnit[i];
			}
			coin[i] -= coinNum;

			out.println(coinUnit[i] + "원 : " + coinNum);
		}

		if (money > 0) {
			out.println("거스름돈이 부족합니다 .");
			exit(0); // 프로그램을 종료한다.
		}
		out.println("=남은 동전의 개수 =");
		for (int i = 0; i < coinUnit.length; i++) {
			out.println(coinUnit[i] + "원 :" + coin[i]);
		}
	}

	static void example5_08() {
		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[4];
		for (int i = 0; i < answer.length; i++) {
			/* (1) . */
			switch (answer[i]) {
			case 1:
				counter[0]++;
				break;
			case 2:
				counter[1]++;
				break;
			case 3:
				counter[2]++;
				break;
			case 4:
				counter[3]++;
				break;
			}
		}

		for (int i = 0; i < counter.length; i++) {
			/* (2) . */
			out.print(counter[i]);
			for (int j = 0; j < counter[i]; j++) {
				out.print("*");
			}
			out.println();
		}
	}

	static void example5_09() {
		char[][] star = { 
				{ '*', '*', ' ', ' ', ' ' },
				{ '*', '*', ' ', ' ', ' ' }, 
				{ '*', '*', '*', '*', '*' },
				{ '*', '*', '*', '*', '*' } };
		char[][] result = new char[star[0].length][star.length];
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				out.print(star[i][j]);
			}
			out.println();
		}
		out.println();

		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				/* 알맞은 코드를 넣어 완성하시오 (1) . */
				result[j][i] = star[star.length - 1 - i][j];
			}
		}
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				out.print(result[i][j]);
			}
			out.println();
		}
	}

	static void example5_10() {
		//알파벳 변환할 것
		char[] abcCode = { '`','~','!','@','#','$','%','^','&','*', '(',')','-','_','+','=','|','[',']','{', '}',';',':',',','.','/'}; 
		//숫자 변환할 것
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};


		String src = "abc123";
		String result = "";

		for (int i = 0; i < src.length(); i ++) {
			char ch = src.charAt(i); 
			/* 알맞은 코드를 넣어 완성하시오 (1) . */
			if('0' <= ch && ch <= '9') {
				result += numCode[ch - '0'];
			} else if('a' <= ch && ch <= 'z') {
				result += abcCode[ch - 'a'];
			}
		}
		
		out.println("src:" + src);
		out.println("result:" + result);
	}

	static void example5_11() {
		int[][] score = { 
				{100, 100, 100} , 
				{20, 20, 20} , 
				{30, 30, 30} , 
				{40, 40, 40} , 
				{50, 50, 50} 
				}; 
		
		int[][] result = new int[score.length + 1][score[0].length + 1];
		
		
		for (int i = 0; i < score.length; i ++) {
		    for (int j = 0; j < score[i].length; j ++) { 
		    	result[i][j] = score[i][j];
		    	result[i][score[i].length] += result[i][j];
		    	result[score.length][j] += result[i][j];
		    	result[score.length][score[i].length] += result[i][j];
		    }
		}
		
		for (int i = 0; i < result.length; i ++) {
		    for (int j = 0; j < result[i].length; j ++) {
		        out.printf("%4d", result[i][j]);
		    }
		    out.println();
		}
	}

	static void example5_12() {
		String[][] words = {
				{"chair", "의자"},
				{"computer", "컴퓨터"},
				{"integer", "정수"}
		};
		
		Scanner scan = new Scanner(in);
		int collect = 0;
		for(int i = 0; i < words.length; ++i) {
			out.printf("Q%d. %s의 뜻은? ", i+1, words[i][0]);
			String tmp = scan.nextLine();
			if(tmp.equals(words[i][1])) {
				collect++;
				out.println("정답입니다.\n");
			} else {
				out.printf("틀렸습니다. 정답은 %s입니다.\n\n", words[i][1]);
			}
		}
		
		out.println("전체 " + words.length + "문제 중 " + collect + "문제 맞추셨습니다." );
		scan.close();
	}
	
	static void example5_13() {
		String[] words = {"television", "computer", "mouse", "phone"};
		Scanner scanner = new Scanner( in);
	        
	    for (int i = 0; i < words.length; i ++) {
	    	char[] question = words[i].toCharArray();
		
			for (int j = 0; j < question.length; j++) {
				int n = (int) (Math.random() * question.length);
				char tmp = ' ';

				tmp = question[i];
				question[i] = question[n];
				question[n] = tmp;
			}

	    	out.printf("Q%d. %s.> ", i + 1, new String(question));
	    	
	    	String answer = scanner.nextLine();

	    	if(words[i].equals(answer.trim()))
	    		out.printf("맞았습니다.%n%n"); 
	    	else 
	    		out.printf("틀렸습니다.%n%n");
	    }
	    scanner.close();
	}
	
	/*
	 * 여기서부터 알고리즘(중급) 과제
	 * */
	
	static void intermediate01() {
		Scanner s = new Scanner(in);
		int num;//입력받은 수
		int j;	//제수
		
		while((num = s.nextInt()) < 2 ){
			out.println("2 이상의 정수를 입력해주십시오.");
		}
		
		for(j = 2; j <= num; ++j) {
			if(num % j == 0) {
				break;
			}
		}
		if(j == num) {
			out.println("소수.");
		} else {
			out.println("소수아님.");
		}
		s.close();
	}
	
	static void intermediate02() {
		int[] A = new int[100];	// 약수 저장할 배열
		Scanner s = new Scanner(in);
		int num;	//입력받은 수
		
		
		while((num = s.nextInt()) < 2 ){
			out.println("2 이상의 정수를 입력해주십시오.");
		}
		
		int index = 0; // 약수를 저장할 인덱스
		for(int i = 1; i <= num; ++i) {
			if(num % i == 0) {
				A[index++] = i;
			}
		}
		for(int array : A) {
			if(array == 0) {
				break;
			}
			out.print(array + " ");
		}
		s.close();
	}
	
	static void intermediate03() {
		int[] array = new int[20];
		Scanner s = new Scanner(in);
		int num;	//입력받은 수
		
		while((num = s.nextInt()) < 2 ){
			out.println("2 이상의 정수를 입력해주십시오.");
		}
		
		if(isPrimeNum(num)) {
			array[0] = num;
			out.println("소인수 분해 결과 : " + array[0]);
			exit(0);
		}
		
		int index = 0;
		for(int i = 2; i <= num; ++i) {
			if(isPrimeNum(i)) {
				for(int j = num; j > 1 && j % i == 0; j /= i) {
					array[index++] = i;
				}
			}			
		}
		out.print("소인수 분해 결과 : " + num + " => ");
		int cnt = 1;
		for(int i = 0; i < array.length && array[i] != 0; ++i) {
			if(array[i] == array[i+1]) {
				++cnt;
			} else {
				//지수 처리하는 부분
				//ex) 1024 = 2^10 이런식으로 표시됨. 
				out.print(array[i] + "^" + cnt );
				if(array[i+1] != 0) {
					out.print(" X ");
				}
				cnt = 1;
			}
			
		}
		s.close();		
	}
	
	static boolean isPrimeNum(int num) {
		int j;	//제수
		
		while(num < 2 ){
			out.println("2 이상의 정수가 아닙니다.");
			return false;
		}
		
		for(j = 2; j <= num; ++j) {
			if(num % j == 0) {
				break;
			}
		}
		if(j == num) {
			//out.println("소수.");
			return true;
		} else {
			//out.println("소수아님.");
			return false;
		}
	}
	
	//최대공약수, 최소공배수
	static void intermediate04() {
		Scanner s = new Scanner(in);
		int[] num = new int[2];	//입력받은 수
		
		for(int i = 0; i < num.length; ++i) {
			while((num[i] = s.nextInt()) < 2 ){
				out.println("2 이상의 정수를 입력해주십시오.");
			}
		}
		int big = Integer.max(num[0], num[1]);
		int small = Integer.min(num[0], num[1]);
		
		int gcm = 0, lcm = 0, tmp;
		if(big % small == 0) {
			gcm = small;
			lcm = big * small / gcm;
			out.println("두 수 " + num[0] + ", " + num[1] +"의 최대공약수는 " + gcm + ", 최소공배수는 " + lcm);
		} else {
			while(big % small != 0) {
				tmp = big;
				big = small;
				small = tmp%small;
			}
			gcm = small;
			lcm = num[0] * num[1] / gcm;
			out.println("두 수 " + num[0] + ", " + num[1] +"의 최대공약수는 " + gcm + ", 최소공배수는 " + lcm);
		}
		s.close();
	}
	
	//최대값 최소값
	static void intermediate05() {
		Scanner s = new Scanner(in);
		int[] num = new int[5];	//입력받은 점수
		
		for(int i = 0; i < num.length; ++i) {
			out.print("점수 " + (i+1) + "입력 : ");
			num[i] = s.nextInt();
		}
		
		int max = 0;
		for(int i = 0; i < num.length; ++i) {
			if(num[i] > max) {
				max = num[i];
			}
		}
		out.println("최대값은 " + max);
		s.close();
	}
	
	//최대 최소 합계 평균
	static void intermediate06() {
		Scanner s = new Scanner(in);
		int[] num = new int[5];	//입력받은 점수
		
		for(int i = 0; i < num.length; ++i) {
			out.print("점수 " + (i+1) + "입력 : ");
			num[i] = s.nextInt();
		}
		
		int max = 0, min = num[0], sum = 0;
		for(int i = 0; i < num.length; ++i) {
			sum += num[i];
			if(num[i] > max) {
				max = num[i];
			} 
			if(num[i] < min){
				min = num[i];
			}
		}
		out.println("최대값은 " + max + ", 최소값은 " + min + ", 합계는 " + sum);
		s.close();
	}
	
	//배수
	static void intermediate07() {
		int[] Arr = new int[100];
		int n = 0;
		for(int i = 1; i <= 100; ++i) {
			if(i%5 == 0) {
				Arr[n++] = i;
			}
		}
		for(int arr : Arr) {
			if(arr == 0) {
				break;
			}
			out.println(arr);
		}
	}
	
	//진법변환
	static void intermediate08() {
		int[] binary = new int[10];
		Scanner s = new Scanner(in);
		int num;
		
		while((num = s.nextInt()) < 0 || num > 1023 ){
			out.println("범위를 초과하였습니다. 다시 입력해 주세요");
		}
		
		//2^9 자리부터 2^0 까지 num(dividend)를 나눈 몫과 나머지를 이용하여 이진수로 변환함
		int dividend = num;
		for (int i = 0; i < binary.length; ++i ){
			int divisor = 1;
			for(int j = binary.length-1; j > i; --j) {
				divisor *= 2;
			}
			binary[i] = dividend / divisor;
			dividend %= divisor;
		}
		out.println(Arrays.toString(binary));
		s.close();
	}
	
	//석차
	static void intermediate09() {
		Scanner s = new Scanner(in);
		int[] num = new int[5];	//입력받은 점수
		int[] rank = new int[5];
		
		for(int i = 0; i < num.length; ++i) {
			out.print("점수 " + (i+1) + "입력 : ");
			num[i] = s.nextInt();
			rank[i] = 1;
		}
		
		for(int i = 0; i < rank.length; ++i) {
			for(int j = 0; j < num.length; ++j) {
				if(num[i] < num[j]) {
					rank[i]++;
				}		
			}
		}
		
		for(int i = 0; i < num.length; ++i) {
			out.println("점수 : " + num[i] + " -> " + rank[i] + "등");
		}
		s.close();
	}
	
	static void intermediate10() {
		int[] A = new int[10];
		int min = 0;
		int indexMin = 0;
		Scanner s = new Scanner(in);
		for(int i = 0; i < A.length; ++i) {
			A[i] = s.nextInt();
		}
		
		for(int i = 0; i < A.length; ++i) {
			min = A[i];
			for(int j = i+1; j < A.length; ++j) {
				if(min >= A[j]) {
					min = A[j];
					indexMin = j;
				} 				
			}
			if(A[i] > min) {
				A[i] ^= A[indexMin];
				A[indexMin] ^= A[i];
				A[i] ^= A[indexMin];
			}
		}
			
		for(int array : A) {
			out.print(array + " ");
		}
		s.close();
	}
	
	//100, 30, 39, 84, 5, 1, 3, 8, 2, 10 
	static void intermediate11() {
		int[] arr = new int[] { 30, 100, 39, 84, 5, 11, 3, 8, 2, 10  };
		//int cnt = 0;
		int flag = 0;
	
		for (int i = 1; i <= arr.length; i++) {
			for (int j = 0; j < arr.length - i && flag < arr.length - i ; j++) {
				// 플래그가 일정 횟수 증가하면 더 이상 정렬하지 않아도 된다고 판단 루프 종료
				//cnt++;
				flag++;
				if (arr[j] > arr[j + 1]) {
					flag = 0;
					arr[j] ^= arr[j + 1];
					arr[j + 1] ^= arr[j];
					arr[j] ^= arr[j+1];
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			out.printf("%d ", arr[i]);
		}
//		out.printf("\n총 %d 번 돌았습니다.\n", cnt);

	}
	
	static void intermediate12() {
		int[] arr = new int[] { 30, 100, 39, 84, 5, 11, 3, 8, 2, 10  };
		int key;
	
		for(int m = 1; m < arr.length; ++m) {
			key = arr[m];
			for(int w = m - 1; w >= 0; --w) {
				if(arr[w] > key) {
					arr[w] ^= arr[w+1];
					arr[w+1] ^= arr[w];
					arr[w] ^= arr[w+1];
				}
			}
		}
		
		for(int array : arr) {
			out.print(array + " ");
		}
	}
	
	//{ 1,2,3,4,5,6,7,8,9,10 };
	static void intermediate13() {
		int[] arr = new int[10];
		int l = 0;
		int h = arr.length - 1;
		int m; 
		int index = -1;
		
		Scanner s = new Scanner(in);
		
		for(int i = 0; i < arr.length; ++i) {
			arr[i] = s.nextInt();
		}
		bubbleSort(arr);
		out.print("key 값을 입력 : ");
		//7
		int k = s.nextInt(); 
		
		while(l<=h) {
			m = (l + h) / 2;
			
			if(k > arr[m]) {
				l = m + 1;
			} else if (k < arr[m]) {
				h = m - 1;
			} else {
				index = m;
				out.println(k + "는 " + (index + 1) + "번째에 있습니다.");
				break;
			}	
		}
		if(index == -1) {
			out.println(k + "를(을) 찾지 못했습니다.");
		}
		s.close();
	}
	
	static void bubbleSort(int[] arr) {
		//int cnt = 0;
		int flag = 0;
	
		for (int i = 1; i <= arr.length; i++) {
			for (int j = 0; j < arr.length - i && flag < arr.length - i ; j++) {
				// 플래그가 일정 횟수 증가하면 더 이상 정렬하지 않아도 된다고 판단 루프 종료
				//cnt++;
				flag++;
				if (arr[j] > arr[j + 1]) {
					flag = 0;
					arr[j] ^= arr[j + 1];
					arr[j + 1] ^= arr[j];
					arr[j] ^= arr[j+1];
				}
			}
		}
//		for (int i = 0; i < arr.length; i++) {
//			out.printf("%d ", arr[i]);
//		}
//		out.printf("\n총 %d 번 돌았습니다.\n", cnt);
	}
	
	static void intermediate14() {
		int[] Gu = new int[9];
		for(int a = 1; a <= Gu.length; ++a) {
			for(int b = 1; b <= Gu.length; ++b) {
				Gu[a - 1] = a*b;
				out.printf("%2dX%2d = %2d ", a, b, Gu[a-1]);
			}
			out.println();
		}
	}
	
}
