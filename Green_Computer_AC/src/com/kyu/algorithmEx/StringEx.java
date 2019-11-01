package com.kyu.algorithmEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class StringEx {
	public static void main(String[] args) {
		String str = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경현";

		String[] data = str.split(",");

		int cntKim 	= 0;
		int cntLee 	= 0;
		int cnt 	= 0;
		
		for (int i = 0; i < data.length; ++i) {
			if (data[i].startsWith("김")) {
				cntKim++;
			}
			if (data[i].startsWith("이")) {
				cntLee++;
			}
			if(data[i].equals("이재영")) {
				cnt++;
			}
		}

		System.out.println("김씨 : " + cntKim + "명\n이씨 : " + cntLee + "명\n이재영 : " + cnt+"명");

		// 중복 제거
		Set<String> set1 = new HashSet<>(Arrays.asList(data));
		System.out.println(set1);
		// 오름차순으로 중복 제거
		Set<String> set2 = new TreeSet<>(set1);
		System.out.println(set2);

		ArrayList<String> list = new ArrayList<>(set2);
		Collections.reverse(list);
		System.out.println(list);
		
		int ar[] = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(Arrays.toString(ar));
		
		//반복문 한개로 배열 뒤집어라
		for(int i = 0; i < ar.length/2; ++i) {
			ar[i] 				^= ar[ar.length-1-i];
			ar[ar.length-1-i]	^= ar[i];
			ar[i] 				^= ar[ar.length-1-i];	
		}
		System.out.println(Arrays.toString(ar));
		
		//반복문 한개로 배열 뒤집어라
		int ar2[] = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(Arrays.toString(ar2));
		List<Integer> list2 = new ArrayList<>();
		for(int num : ar2) {
			list2.add(num);
		}
		Collections.reverse(list2);
		System.out.println(list2);
	}
}
