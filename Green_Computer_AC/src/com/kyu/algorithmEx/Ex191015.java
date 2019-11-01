package com.kyu.algorithmEx;

import java.util.Stack;

public class Ex191015 {
	public static void main(String[] args) {
		System.out.println(largestPrimeFactor(13195));
		System.out.println(simpleBalancedParentheses("(1+2)+(3+4)") ? "balance" : "not balance");
		System.out.println(decToAnyNumeral(10, 2));
		
		System.out.println(String.format("%.20f", 10/3.0));
	}
/*
 * 문제 1] Largest prime factor
어떤 수를 소수의 곱으로만 나타내는 것을 소인수분해라 하고, 이 소수들을 그 수의 소인수라고 한다.
예를 들면 13195의 소인수는 5, 7, 13, 29 이다.
1 ~ 13195 / 2 까지 나눠떨어지는 것만 체크하면 될듯
600851475143의 소인수 중에서 가장 큰 수를 구하시오.
*/
	private static long largestPrimeFactor(long number) {
		long max = 0;
		long tmp = number;
		for(int i = 2; i <= number/2; ++i) {
			if(tmp%i == 0) {
				tmp /= i;
				
				if(max < i) {
					max = i;
				}
			}
		}
		return max;
	}
	
/*
문제 2]Simple Balanced Parentheses
아래는 괄호를 이용한 연산식이다.
(5+6)∗(7+8)/(4+3)
우리는 여는 괄호가 있으면 닫는 괄호가 반드시 있어야 한다는 것을 잘 알고 있다.
다음은 정상적인(balanced) 괄호 사용의 예이다.
(()()()())
(((())))
다음은 비정상적인(not balanced) 괄호 사용의 예이다.
((((((())
()))
(()()(()
여는 괄호 만날 때 마다
list에 추가하고
닫는 괄호 만날 때 마다 list에서 제거해서
최종적으로 list가 비었는지 확인할 것
괄호의 사용이 잘 되었는지 잘못 되었는지 판별 해 주는 프로그램을 작성하시오.
*/
	private static boolean simpleBalancedParentheses(String expression) {
		boolean isCorrect = false;
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < expression.length(); ++i) {
			char ch = expression.charAt(i);
			if(ch=='(') {
				stack.push(ch);
			} else if (ch==')') {
				if(stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		isCorrect = stack.isEmpty();
		return isCorrect;
	}
/*
문제 3] 10진수를 n진수로 변환하기
라이브러리를 사용하지 말고 10진수를 n진수로 변환하는 프로그램을 작성하시오.. (단, n의 범위는 2 <= n <= 16)
예)
2진수로 변환 : 23310 --> 111010012
8진수로 변환 : 23310 --> 3518
16진수로 변환 : 23310 --> E916
 */
	private static String decToAnyNumeral(int number, int base) {
		StringBuilder sb = new StringBuilder();
		String[] str = "0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F".split(",");
		
		while(number >= base) {
			sb.append(str[number%base]);
			number /= base;
		}
		sb.append(str[number]);
		sb.reverse();
		return sb.toString();
	}
}
