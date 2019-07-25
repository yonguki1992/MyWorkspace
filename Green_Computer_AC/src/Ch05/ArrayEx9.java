package Ch05;

import java.util.Arrays;

public class ArrayEx9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cod = {-4, -1, 3, 6, 11};
		int[] arr = new int[10];

		int temp = 0;
		
		// foreach 문을 통한 값의 변경은 실제 배열에 반영되지 않음.
		// 값 참조의 용도로만 사용할 것.
		for(int var : arr) {
			var = cod[(int)(Math.random()*cod.length)];
		}
		System.out.println(Arrays.toString(arr));
		
		for(int i = 0; i < arr.length; ++i) {
			arr[i] = cod[(int)(Math.random()*cod.length)];
		}
		
		System.out.println(Arrays.toString(arr));
		
	}

}
