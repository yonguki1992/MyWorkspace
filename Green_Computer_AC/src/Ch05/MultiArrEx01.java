package Ch05;

import static java.lang.System.*;
import java.util.Scanner;

public class MultiArrEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(in);
		
		int[][] score = new int[4][];
		
		score[0] = new int[3];
		score[1] = new int[4];
		score[2] = new int[5];
		score[3] = new int[2];
		
		
		for(int i = 0; i < score.length; ++i) {
			for(int j = 0; j < score[i].length; ++j) {
				score[i][j] = s.nextInt();
			}
		}
		
		for(int[] a : score) {
			for(int b : a) {
				out.print(b);
			}
			out.println();
		}
	}

}
