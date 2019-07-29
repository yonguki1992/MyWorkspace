package Ch09;

import java.util.Random;

public class RandomEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int[] number = new int[100];
		int[] counter = new int[10];
		String[] local = new String[] { "서울", "인천", "부산", "대구", "대전", "제주", "분당", "성남", "공주", "상주" };

		for (int i = 0; i < number.length; ++i) {
			number[i] = rand.nextInt(10);
		}

		for (int i = 0; i < number.length; ++i) {
			counter[number[i]]++;
		}

		for (int i = 0; i < counter.length; ++i) {
			System.out.println(local[i] + "의 개수 : " + printGraph('#', counter[i]) + " " + counter[i]);
		}
	}

	public static String printGraph(char ch, int value) {
		char[] bar = new char[value];
		for (int i = 0; i < bar.length; ++i) {
			bar[i] = ch;
		}
		return new String(bar);
	}

}
