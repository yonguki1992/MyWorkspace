package Ch05;

import java.util.Scanner;
import static java.lang.System.*;


public class ArrayEx19 {

	static final int STUDENT = 3;
	static final int SUBJECT = 6;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(in);
		String[][] score = new String[STUDENT][SUBJECT];
		int perTot = 0, korTot = 0, engTot = 0, mathTot = 0;
		float[] perTotAvg = new float[STUDENT];
		float maxAvg = 0;
		
		out.println("학생의 이름과 점수를 입력해 주세요. (이름, 국어, 영어, 수학 순으로 입력)");
		
		
		for(int i = 0; i < score.length; ++i) {
			out.println(i+1 + "번째 학생의 정보를 입력해 주세요.");
			for(int j = 0; j < score[i].length - 2; ++j) {
				score[i][j] = s.nextLine();
			}	
		}
		out.println("번호     이름     국어     영어     수학      총점      평균");
		out.println("=================================");

		int cnt = 0;
		
		
		for(int i = 0; i < score.length; ++i) {
			cnt = 0;
			perTot = 0;
			for(int j = 0; j < score[i].length; ++j) {
				
				if(cnt != 0 && cnt < 4) {
					perTot += Integer.parseInt(score[i][j]);

					if (cnt == 1){
						korTot += Integer.parseInt(score[i][j]);
					} else if (cnt == 2) {
						engTot += Integer.parseInt(score[i][j]);
					} else if (cnt == 3) {
						mathTot += Integer.parseInt(score[i][j]);
					}
				}
				 
				perTotAvg[i] = (float)((int)((float)perTot/3 * 100 + 0.5f))/100; 
				score[i][4] = Integer.toString(perTot);
				score[i][5] = Float.toString(perTotAvg[i]);
				
				cnt++;
			}
		}
		
		
		int num = 0;
		for(String[] i : score) {
			out.printf("%2d", ++num);
			for(String j : i) {
				out.printf(" %3s ", j);
			}
			out.println();
		}
		
		out.println("=================================");
		out.printf("총점 :    %3d  %3d  %3d\n", korTot, engTot, mathTot );
		
		int index = 0;
		for(int i = 0; i < perTotAvg.length; ++i) {
		    if(maxAvg < perTotAvg[i]) {
		    	maxAvg = perTotAvg[i];
		    	index = i;
		    }
		}
		out.printf("1등 : %s\n1등의 평균점수 : %3.1f\n", score[index][0], maxAvg );
		
		
		cnt = 0;
		int flag = 0;
		String[] temp = new String[1];
		for (int i = 1; i < score.length; i++) {
			for (int j = 0; j < score.length - i && flag < score.length - i; j++) {
				// 플래그가 일정 횟수 증가하면 더 이상 정렬하지 않아도 된다고 판단 루프 종료
				cnt++;
				flag++;
				if (Float.parseFloat(score[j][5]) < Float.parseFloat(score[j + 1][5])) {
					flag = 0;
					temp = score[j];
					score[j] = score[j + 1];
					score[j + 1] = temp;
				}

			}
		}
		for(int i = 0; i < score.length; ++i) {
			out.printf((i+1) + "등 : " + score[i][0] + " ");			
		}

	}
}
