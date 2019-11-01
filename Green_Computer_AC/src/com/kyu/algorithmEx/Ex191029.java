package com.kyu.algorithmEx;

public class Ex191029 {
	/*
	 * input:
	a b c d e f
	| | | | | |
	|-| | |-| |
	| | |-| | |
	| |-| | |-|
	| | |-| | |
	|-| | |-| |
	| | | | | |
	1 2 3 4 5 6

	output:
	a - 5
	b - 2
	c - 3
	d - 6
	e - 1
	f - 4
	 */
	public static void main(String[] args) {
		String[] player = "a,b,c,d,e,f".split(",");
		int result = 0;
		int playerNum = 6;
//		String selectOne = player[playerNum-1];
//		switch(selectOne) {
//			case "a":
//				getResult(playerNum);
//				break;
//			case "b":
//				break;
//			case "c":
//				break;
//			case "d":
//				break;
//			case "f":
//				break;
//			case "e":
//				break;
//			default :
//				break;
//		}
		for(int i = 0; i < 6; i++) {
			System.out.println(player[i]+" - "+getResult(i));
		}
	}

	private static int getResult(int playerNum) {
		String[][] ladder = {
				{"|"," ","|"," ","|"," ","|"," ","|"," ","|"},
				{"|","-","|"," ","|"," ","|","-","|"," ","|"},
				{"|"," ","|"," ","|","-","|"," ","|"," ","|"},
				{"|"," ","|","-","|"," ","|"," ","|","-","|"},
				{"|"," ","|"," ","|","-","|"," ","|"," ","|"},
				{"|","-","|"," ","|"," ","|","-","|"," ","|"},
				{"|"," ","|"," ","|"," ","|"," ","|"," ","|"}
		};
		int[] result = new int[]{1,2,3,4,5,6};
		// 시작은 ladder[0][2playerNum] 부터 시작(n이 선택한 번호)
		int pX = 2*playerNum;
		int pY = 0;
		while(pY < 7) {
			//System.out.println(pX+", "+pY);
			//포인터x가 0 일 때(맨 왼쪽)
			if(pX == 0) {
				if(ladder[pY][pX+1].equals("-")) {
					pX+=2;
					pY++;
				} else {
					pY++;
				}
			}
			
			//포인터x가 이 10일 때(맨 오른쪽)
			else if(pX == 10) {
				if(ladder[pY][pX-1].equals("-")) {
					pX-=2;
					pY++;
				} else {
					pY++;
				}
			}
			
			// 사이일 때
			else {
				if(ladder[pY][pX+1].equals(" ") && ladder[pY][pX-1].equals(" ")) {
					pY++;
				} else if(ladder[pY][pX-1].equals(" ") && ladder[pY][pX+1].equals("-")) {
					pX+=2;
					pY++;
				} else if(ladder[pY][pX-1].equals("-") && ladder[pY][pX+1].equals(" ")) {
					pX-=2;
					pY++;
				}  else if(ladder[pY][pX-1].equals("-") && ladder[pY][pX+1].equals("-")) {
					pX+=2;
					pY++;
				}
			}
			
		}
		return result[pX/2];
	}
	
}
