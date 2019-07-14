package Homework;

import java.util.Scanner;

public class Thirdweek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		example5_13();
	}

	static void example5_03() {
		int[] arr = { 10, 20, 30, 40, 50 };
		int sum = 0;

		for (int num : arr) {
			sum += num;
		}

		System.out.println("sum=" + sum);
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

		System.out.println("total=" + total);
		System.out.println("average=" + average);
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
			System.out.print(ball3[i]);
		}
	}

	static void example5_06() {
		int[] coinUnit = { 500, 100, 50, 10 };
		int money = 2680;

		System.out.println("money=" + money);
		for (int i = 0; i < coinUnit.length; i++) {
			System.out.println(coinUnit[i] + "원 : " + money / coinUnit[i]);
			money %= coinUnit[i];
		}
	}

	static void example5_07() {
		int money = 3200;
		int[] coinUnit = { 500, 100, 50, 10 };
		int[] coin = { 5, 5, 5, 5 };

		System.out.println("money=" + money);
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

			System.out.println(coinUnit[i] + "원 : " + coinNum);
		}

		if (money > 0) {
			System.out.println("거스름돈이 부족합니다 .");
			System.exit(0); // 프로그램을 종료한다.
		}
		System.out.println("=남은 동전의 개수 =");
		for (int i = 0; i < coinUnit.length; i++) {
			System.out.println(coinUnit[i] + "원 :" + coin[i]);
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
			System.out.print(counter[i]);
			for (int j = 0; j < counter[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
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
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				/* 알맞은 코드를 넣어 완성하시오 (1) . */
				result[j][i] = star[star.length - 1 - i][j];
			}
		}
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
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
		
		System.out.println("src:" + src);
		System.out.println("result:" + result);
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
		        System.out.printf("%4d", result[i][j]);
		    }
		    System.out.println();
		}
	}

	static void example5_12() {
		String[][] words = {
				{"chair", "의자"},
				{"computer", "컴퓨터"},
				{"integer", "정수"}
		};
		
		Scanner scan = new Scanner(System.in);
		int collect = 0;
		for(int i = 0; i < words.length; ++i) {
			System.out.printf("Q%d. %s의 뜻은? ", i+1, words[i][0]);
			String tmp = scan.nextLine();
			if(tmp.equals(words[i][1])) {
				collect++;
				System.out.println("정답입니다.\n");
			} else {
				System.out.printf("틀렸습니다. 정답은 %s입니다.\n\n", words[i][1]);
			}
		}
		
		System.out.println("전체 " + words.length + "문제 중 " + collect + "문제 맞추셨습니다." );
		scan.close();
	}
	
	static void example5_13() {
		String[] words = {"television", "computer", "mouse", "phone"};
		Scanner scanner = new Scanner(System. in);
	        
	    for (int i = 0; i < words.length; i ++) {
	    	char[] question = words[i].toCharArray();
		
			for (int j = 0; j < question.length; j++) {
				int n = (int) (Math.random() * question.length);
				char tmp = ' ';

				tmp = question[i];
				question[i] = question[n];
				question[n] = tmp;
			}

	    	System.out.printf("Q%d. %s.> ", i + 1, new String(question));
	    	
	    	String answer = scanner.nextLine();

	    	if(words[i].equals(answer.trim()))
	    		System.out.printf("맞았습니다.%n%n"); 
	    	else 
	    		System.out.printf("틀렸습니다.%n%n");
	    }
	}
}
