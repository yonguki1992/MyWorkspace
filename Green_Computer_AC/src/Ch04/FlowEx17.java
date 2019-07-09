package Ch04;

import java.util.Scanner;

public class FlowEx17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		for(int i = 0; i < size ; ++i) {
			for(int j = 0; j < i + 1; ++j) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = size; i > 0; --i) {
			for(int j = 0; j < i; ++j) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// 1 + (1+2) + (1+2+3) ...... + (1+2+.....+49+50)
		int sum = 0;
		int sumTmp = 0;
		for(int i = 0; i < 50; ++i) {
			sumTmp = 0;
			for(int j = 0; j < i + 1; ++j) {
				sumTmp += (j+1);

			}
			sum += sumTmp;
			

		}

		System.out.println(sum);
		scan.close();
	}

}
