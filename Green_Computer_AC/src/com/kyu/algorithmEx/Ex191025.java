package com.kyu.algorithmEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex191025 {

	public static void main(String[] args) {
		
		fingerSnap(2, 3, 1, 5, 7);
		
		int[] numArr = {6,20,15};
		for(int num : numArr) {
			whatIsThisNumber(num);
		}

	}

	private static void whatIsThisNumber(int num) {
		int sum = getSumRealDivisor(num);
		if(num == sum) {
			System.out.println(num+"은 완전수.");
		} else {			
			System.out.println(num < sum ? num+"은 과잉수.":num+"은 부속수.");
		}
	}

	private static int getSumRealDivisor(int num) {
		if(num == 1) {
			return 1;
		}
		int sum = 0;
		for(int i = 1; i <= num/2; ++i) {
			if(num%i==0) {
				sum += i;
			}
		}
		return sum;
	}

	private static void fingerSnap(int... num) {
		List<Integer> list = new ArrayList<>();
		for (int number : num) {
			list.add(number);
		}

		Random random = new Random();
		int length = list.size();

		System.out.println("타노스가 손가락을 튕겼다");
		for (int i = 0; i < length / 2 + (length % 2 == 0 ? 0 : random.nextInt(2)); ++i) {
			System.out.println(list.remove(random.nextInt(list.size())));
		}
		System.out.println("효과는 굉장했다.");
		System.out.println("살아남은 원소 : "+list);
	}

}
