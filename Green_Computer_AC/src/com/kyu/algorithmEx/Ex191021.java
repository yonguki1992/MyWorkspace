package com.kyu.algorithmEx;

import java.util.ArrayList;
import java.util.List;

public class Ex191021 {
	public static void main(String[] args) {
		String str1 = "photography";
		String str2 = "autograph";
		List<String> subStr1 = makeSubString(str1);
		List<String> subStr2 = makeSubString(str2);
		List<String> tmp1 = new ArrayList<>();
		List<String> tmp2 = new ArrayList<>();
		
		tmp1 = subStr1.size() >= subStr2.size()? subStr2 : subStr1;
		tmp2 = subStr1.size() < subStr2.size()? subStr2 : subStr1;
		//System.out.println(tmp1.get(tmp1.size()-1));
		for(int i = tmp1.size()-1 ; i >= 0; --i) {
			if(tmp2.contains(tmp1.get(i))) {
				System.out.println("공통 인자 : "+tmp1.get(i)+" : size : "+tmp1.get(i).length());
				break;
			}
		}
		
	}

	private static List<String> makeSubString(String str) {
		List<String> subStr = new ArrayList<String>();
		for(int i = 0; i <= str.length(); ++i) {
			for(int j = 0; j < str.length(); ++j) {
				if(i==0) {
					//System.out.println(str.substring(j,i+j));
					subStr.add(str.substring(j,i+j));
					break;
				}
				if(i+j > str.length()) {
					break;
				}
				//System.out.println(str.substring(j,i+j));
				subStr.add(str.substring(j,i+j));
			}
		}
		return subStr;
	}
}
