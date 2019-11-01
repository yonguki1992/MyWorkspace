package com.kyu.algorithmEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.apache.commons.lang3.StringUtils;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import MyLib.ScannerFunctions;

public class StringToInteger {
	public static void main(String[] args) {
		ScannerFunctions scannerFunctions = new ScannerFunctions();
		q1(scannerFunctions);
		q2(scannerFunctions);
		q3(scannerFunctions);
		scannerFunctions.finalize();
	}

	private static void q3(ScannerFunctions scannerFunctions) {
		// 문자열 연산이 많으면 스트링 빌더랑 스트링 버퍼 써야함.
		/*
		 * StringBuffer, StringBuilder 차이는 "스레드에 안전한 가" 임.
		 * StringBuffer 는 멀티 스레드에 안전하게 설계
		 * StringBuilder 는 싱글 스레드에만 안전하게 설계됨.
		 */
		System.out.print("반복 횟수 입력(0은 종료) > ");
		int times = scannerFunctions.inputNumber();
		System.out.print("반복 문자열 입력 > ");
		String input = scannerFunctions.inputText();
		StringBuffer sb = new StringBuffer();

		for (int j = 0; j < input.length(); ++j) {
			for (int i = 0; i < times; ++i) {
				sb.append(input.charAt(j));
			}
		}
		System.out.print("결과는 ");
		System.out.println(sb.toString());
	}

	private static void q2(ScannerFunctions scannerFunctions) {
		int[] alphabet = new int[26];

		System.out.println("소문자로 이뤄진 문자를 입력해 주세요.");
		String input = scannerFunctions.inputText();

		for (int i = 0; i < input.length(); ++i) {
			alphabet[(input.charAt(i) - 'a')]++;
		}

		System.out.append("결과는 ").println(Arrays.toString(alphabet));
		System.out.flush();

	}

	private static void q1(ScannerFunctions scannerFunctions) {

		System.out.println("공백없이 숫자를 입력해 주세요.");
		String input = scannerFunctions.inputText();
		int sum = 0;
		for (int i = 0; i < input.length(); ++i) {

			sum += (input.charAt(i) - '0');
		}

		System.out.println("합계는 " + sum);

	}

}
