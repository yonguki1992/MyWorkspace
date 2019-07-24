package Ch05;

public class ArrayEx18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][][] score2 = new int[4][3][2];
		int[][] score = new int[4][3];
		int sum = 0, sum2 = 0;
		for(int i = 0; i < score.length; ++i) {
			for(int j = 0; j < score[i].length; ++j) {
				score[i][j] = 10*(i+1);
		
				System.out.print(score[i][j]+ " ");
			}	
			System.out.println();
		}
		
		for(int[] i : score) {
			for(int j : i) {
				sum += j;
			}
		}
		System.out.println(sum);
		
		for(int i = 0; i < score2.length; ++i) {
			for(int j = 0; j < score2[i].length; ++j) {
				for(int k = 0; k < score2[i][j].length; ++k) {
					score2[i][j][k] = i+j+k+1;	
					System.out.print(score2[i][j][k]+ " ");
				}
				System.out.println("행 끝");	
			}	
			System.out.println("면 끝");
		}
		
		
		for(int[][] i : score2) {
			for(int[] j : i) {
				for(int k : j) {
					sum2 += k;
				}
			}
		}
		System.out.println(sum2);

	}

}
