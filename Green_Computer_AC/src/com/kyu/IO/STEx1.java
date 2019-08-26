package com.kyu.IO;

import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

public class STEx1 {
	public static void main(String[] args) {
		String data = "사과= 300,배= 600,딸기= 200,감= 900";
		// 위의 데이터를 아래와 같이 출력 하시오!!
		// 사과(300원)
		// 배(600원)

		StringTokenizer st = new StringTokenizer(data, "=, ");	// 구분자는 "=" 과 "," 및 " " 
		while (st.hasMoreTokens())
			System.out.println(st.nextToken() + "(" + st.nextToken() + "원)");

		StringTokenizer st2 = new StringTokenizer(data, "=, ", true);
		while (st2.hasMoreTokens()) {
			String token = st2.nextToken();
			if (StringUtils.equals(token, ","))
				System.out.println("원)");
			else if (StringUtils.equals(token, "="))
				System.out.print("(");
			else if(StringUtils.equals(token, " "))
				System.out.print(StringUtils.EMPTY);
			else
				System.out.print(token);
		}
		System.out.println("원)");
	}
}
