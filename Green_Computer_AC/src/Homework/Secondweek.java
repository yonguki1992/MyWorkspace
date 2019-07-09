package Homework;

import static java.lang.System.out;


public class Secondweek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		example4_6();
	}
	
	// 2와 3의 배수가 아닌 수의 합
	static void example4_2() {
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
	static void example4_3() {
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
	
	static void example4_4() {
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
	
	static void example4_5() {
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
	
	static void example4_6() {
		for(int diceA = 1; diceA<=6; ++diceA) {
			for(int diceB = 1; diceB<=6; ++diceB) {
				if(diceA+diceB == 6) {
					out.println("[" + diceA + ", " + diceB + "]");
				}
			}
		}
	}
}
