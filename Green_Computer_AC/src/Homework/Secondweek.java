package Homework;

import static java.lang.System.*;
import java.util.Scanner;

public class Secondweek {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		example4_15();
	}
	
	// 2와 3의 배수가 아닌 수의 합
	static void example4_02() {
		int sum = 0;
		for(int i = 1; i <= 20; ++i) {
			if(i%2 == 0 || i%3 == 0) {
				continue;
			}
			sum += i;
		}
		out.println(sum);
	}
	
	// 1 + (1+2) + (1+2+3) ...... + (1+2+.....+9+10) 합
	static void example4_03() {
		int sum = 0;
		int sumTmp = 0;
		for(int i = 0; i < 10; ++i) {
			sumTmp = 0;
			for(int j = 0; j < i + 1; ++j) {
				sumTmp += (j+1);

			}
			sum += sumTmp;
		}
		out.println(sum);
	}
	
	static void example4_04() {
		int sum = 0;
		int num = 0;
		boolean sw = false;
		while(sum < 100) {
			++num;
			if(sw) {
				sum -= num;
				sw = false;
				continue;
			}
			sum += num;
			sw = true;
		}
		out.println(num);
	}
	
	static void example4_05() {
		int i = 0, j;
		
		while(i < 10) {
			j = 0;
			
			while(j <= i) {
				++j;
				out.print("*");
			}
			
			++i;
			out.println();	
		}
	}
	
	static void example4_06() {
		for(int diceA = 1; diceA<=6; ++diceA) {
			for(int diceB = 1; diceB<=6; ++diceB) {
				if(diceA+diceB == 6) {
					out.println("[" + diceA + ", " + diceB + "]");
				}
			}
		}
	}
	
	static void example4_07() {
		int value = (int)(Math.random()*100)%6 + 1;
		out.println("value " + value);
	}
	
	static void example4_08() {
		int x, y;
		for(x = 0; x <= 10; ++x) {
			for(y = 0; y <= 10; ++y) {
				if(2*x + 4*y == 10) {
					out.println("x=" + x + ", y=" + y);
				}
			}
		}
	}	

	static void example4_09() {
		String str = "12345";
		int sum = 0;
		
		for(int i = 0; i < str.length(); ++i) {
			sum += Integer.parseInt(String.valueOf(str.charAt(i)));
		}
		
		out.println("sum=" + sum);
	}

	static void example4_10() {
		int num = 12345;
		int sum = 0;
		
		for(int i = num; i > 0; i /= 10) {
			sum += i%10;
		}
		out.println("sum=" + sum);
	}
	
	static void example4_11() {
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;
		out.print(num1 + ", " + num2);
		for(int i = 0; i < 8; ++i) {
			num3 = num1 + num2;
			out.print(", " + num3);
			num1 = num2;
			num2 = num3;
		}
	}
	
	static void example4_12() {
		for(int i = 1; i <= 7; i += 3) {
			for(int j = 1; j <= 3; ++j) {
				for(int k = 1; k <= 3; ++k) {
					if(i+k == 10) {
						continue;
					}
					out.printf("%d*%d=%-5d", (i+k), j, (i+k) * j);
				}
				out.println();
			}
			out.println();
		}
	}
	
	static void example4_13() {
		String value = "12o34";
		char ch = ' ';
		boolean isNumber = true;

		for (int i = 0; i < value.length(); i++) {
			/* 알맞은 코드를 넣어 완성하시오 (1) . */
			ch = value.charAt(i);
			if('0' <= ch && ch <= '9') {
				isNumber = true;
			} else {
				isNumber = false;
				break;
			}
				
		}

		if (isNumber) {
			System.out.println(value + "는 숫자입니다.");
		} else {
			System.out.println(value + "는 숫자가 아닙니다.");
		} 
	}

	static void example4_14() {
		int answer = (int)(Math.random()*100);
		int input;
		int cnt = 0;

		Scanner s = new Scanner(in);
		
		do {
			cnt++;
			out.print("1과 100사이의 값을 입력하세요 : ");
			input = s.nextInt();
			
			if(answer - input > 0){
				out.println("더 큰 수를 입력하세요.");
			} else if(answer - input < 0){
				out.println("더 작은 수를 입력하세요.");
			} else {
				out.println("맞췃습니다.\n" + "시도횟수는 "+ cnt +"번입니다.");
				break;				
			}
			
		} while(true);
	}
	
	static void example4_15() {
		int number = 12342321;
		int tmp = number;
		
		int result = 0;
		
		while(tmp != 0) {
			result *= 10;
			result += (tmp % 10);
			tmp /= 10; 
		}
		if(number == result) {
			out.println(number + "는 회문수 입니다.");
		} else {
			out.println(number + "는 회문수가 아닙니다.");			
		}
	}
	
	
}

//향상된 버블 정렬
//int[] arr = new int[] { 100, 30, 39, 84, 5 };
//int cnt = 0;
//int flag = 0, temp = 0;
//for (int i = 0; i < arr.length; i++) {
//	if (flag == 0) {
//		for (int j = 0; j < arr.length - (i + 1); j++) {
//			// 플래그가 일정 횟수 증가하면 더 이상 정렬하지 않아도 된다고 판단 루프 종료
//			cnt++;
//			flag++;
//			if (arr[j] > arr[j + 1]) {
//				flag = 0;
//				temp = arr[j];
//				arr[j] = arr[j + 1];
//				arr[j + 1] = temp;
//			}
//		}
//	}
//}
//for (int i = 0; i < arr.length; i++) {
//	out.printf("%d ", arr[i]);
//}
//out.printf("\n총 %d 번 돌았습니다.\n", cnt);
