package com.kyu.algorithmEx;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class Ex191023 {
	public static void main(String[] args) {
		/*
		 * 문제 1] 친화수 친화수란 a와 b라는 서로 다른 두 자연수가 있을 때, a의 자신을 제외한 약수를 모두 더하면 b가 되고, b의 자신을
		 * 제외한 약수를 모두 더하면 a가 되는 두 수의 쌍을 말한다. 예로 220, 284을 들면 220의 자신을 제외한 약수는 1, 2, 4,
		 * 5, 10, 11, 20, 22, 44, 55, 110이고, 이를 모두 더하면 284이다. 또한 284의 자신을 제외한 약수는 1, 2,
		 * 4, 71, 142이고, 이를 모두 더하면 220이 되므로 220과 284는 친화수이다. 자연수 A를 입력받았을 때, A 이하의 친화수의
		 * 쌍의 개수를 출력하는 프로그램을 만들어라.
		 */

		int num = 300;
		findFriendlyNum(num);

		/*
		 * 문제 2] 2^1000의 각 자릿수의 합은? (프로젝트 오일러 문제 16번) 2^15 = 32768 의 각 자리수를 더하면 3 + 2 +
		 * 7 + 6 + 8 = 26 입니다. 2^1000의 각 자리수를 모두 더하면 얼마입니까?
		 * 0100 0000 0000 0000
		 * 2^1 => 2
		 * 2^2 => 4
		 * 2^3 => 8
		 * 2^4 => 7
		 * 2^5 => 5
		 * 2^6 => 10
		 * 2^7 => 11
		 * 2^8 => 13
		 * 2^9 => 8
		 * 2^10 => 7
		 * 2^11 => 14
		 */
		bigNumber(2, 1000);
		/*
		 * 문제 3] 20세기에서 매월 1일이 일요일인 경우의 개수 다음은 달력에 관한 몇 가지 일반적인 정보입니다 (필요한 경우 좀 더 연구를 해
		 * 보셔도 좋습니다). 1900년 1월 1일은 월요일이다. 4월, 6월, 9월, 11월은 30일까지 있고, 1월, 3월, 5월, 7월, 8월,
		 * 10월, 12월은 31일까지 있다. 2월은 28일이지만, 윤년에는 29일까지 있다. 윤년은 연도를 4로 나누어 떨어지는 해를 말한다.
		 * 하지만 400으로 나누어 떨어지지 않는 매 100년째는 윤년이 아니며, 400으로 나누어 떨어지면 윤년이다. 20세기 (1900년 1월
		 * 1일 ~ 1999년 12월 31일) 에서, 매월 1일이 일요일인 경우는 총 몇 번입니까?
		 */
		
		getSunday();
		
	}

	private static void getSunday() {
		String week = "일월화수목금토일";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
		System.out.println(sdf.format(cal.getTime()));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK) + "요일");
		System.out.println(week.charAt(cal.get(Calendar.DAY_OF_WEEK)-1) + "요일");
		int count=0;
		for(int i=1900;i<2000;i++) {
			for(int j=1;j<=12;j++) {
				cal.set(i, j,1);
				if(cal.get(Calendar.DAY_OF_WEEK)==1) {
					count++;
					System.out.println(sdf.format(cal.getTime()));
				}
			}
		}
		System.out.println(count + "일");
		System.out.println("-----------------------------------------");
		LocalDate date = LocalDate.of(1900, 1, 1);
        count = 0;
        while (date.getYear() < 2000) {
            date = date.plusMonths(1);
            count += date.getDayOfWeek().getValue() == 7 ? 1 : 0;
        }
        System.out.println(count + "일");
	}

	private static void bigNumber(int num, int exponent) {
		int bigSum = 0;
		BigInteger big = new BigInteger(Integer.toString(num)).pow(exponent);
		String bigNumStr = big.toString();
		//System.out.println(bigNumStr);
		
		for(char bigNum : bigNumStr.toCharArray()) {
			bigSum += (bigNum - '0');
		}
		System.out.println(bigSum);
	}

	private static void findFriendlyNum(int num) {
		for (int i = 1; i <= num; ++i) {
			for (int j = 1; j <= num; ++j) {
				if (i == func(j) && j == func(i) && j > i) {
					System.out.println(i + "와 " + j + "는 친화수");
					break;
				}
			}
		}
	}

	private static int func(int num) {
		int sum = 0;
		for (int i = 1; i <= num / 2; ++i) {
			if (num % i == 0) {
				sum += i;
			}
		}
		return sum;
	}
}
