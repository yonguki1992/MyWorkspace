package com.kyu.algorithmEx;

public class No3InClock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sumH = 0, sumM = 0;

		// 시간(0~23)
		for (int h = 0; h < 24; ++h) {

			// 분(0~59)
			for (int m = 0; m < 60; ++m) {
				
				if ((h - h / 10 * 10) == 3&& h != 0) {
					sumH += h;
					sumM += m;
					System.out.println("현재 시각 " + h+ ":" + m);
				} else if ((m - m / 10 * 10) == 3 || m/10 == 3 && m != 0) {
					sumM += m;
					
					System.out.println("현재 시각 " + h+ ":" + m);
				} 
			}
		}

		System.out.println("3이 들어가는 시간의 총 합은 " + (sumH * 3600 + sumM * 60));
	}

}
