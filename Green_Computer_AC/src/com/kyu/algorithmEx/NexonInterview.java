package com.kyu.algorithmEx;

public class NexonInterview {
	
	public static void main(String[] args) {
		selfNum();
	}

	private static void selfNum() {
		boolean[] notSelfNum = new boolean[100000];
		int sum = 0;
		for(int i = 1; i<= 60000; ++i ) {
			sum = 0;
			for(int j = i; j > 0; j/=10) {
				sum += j%10;
			}
			sum += i;
			notSelfNum[sum] = true;
			//System.out.println(sum);
		}
		
		for(int i = 1; i <= 5000; ++i) {
			if(!notSelfNum[i]) {
				//System.out.println("셀프넘버 :"+(i));
			}
		}
	}
	
}
