package com.kyu.algorithmEx;

import java.time.LocalTime;

public class GetGoHomeTime {
	public static void main(String[] args) {
		LocalTime time1 = LocalTime.now();
		LocalTime time2 = LocalTime.of(18, 10);
		
		int hour = time2.getHour()-time1.getHour();
		int minutes = time2.getMinute()-time1.getMinute();
		int seconds = time2.getSecond()-time1.getSecond();
		
		if(minutes < 0) {
			hour--;
			minutes+=60;
		}
		if(seconds < 0) {
			minutes--;
			seconds+=60;			
		}
		
		System.out.printf("남은 시간: %02d:%02d:%02d\n", hour, minutes, seconds);
		System.out.printf("남은 시간(초): %d 초\n", hour*3600+ minutes*60 + seconds);
	}
}
