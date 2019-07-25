package Ch03;

import static java.lang.System.*;
import java.util.Scanner;

public class CompareEx01 {
	static final int SIZE = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(in);
		int a[] = new int[3];
		
		out.println("숫자 3개를 입력해 주세요. >");
		for(int i = 0; i < a.length; ++i) {
			a[i] = scan.nextInt();
		}
		
		int max = a[0], min = a[0], mid = a[0];
		
		for(int i = 0; i < a.length; ++i) {
			max = (max < a[i]) ? a[i] : max;
			min = (min > a[i]) ? a[i] : min;
		}
		
		for(int i = 0; i < a.length; ++i) {
			mid = (max > a[i] && min < a[i]) ? a[i] : mid;
		}
		out.println("최대 : " + max + ", 최소 : " + min + ", 중간 : " + mid);
		if(scan instanceof Object) {
			out.println("scan은 Object의 인스턴스다.");
		}
		scan.close();
	}

}
