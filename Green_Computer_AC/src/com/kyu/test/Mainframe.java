package com.kyu.test;


import static java.lang.System.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class Mainframe {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintUI ui = new PrintUI();
		ui.uiPrint();
	}

}


class PrintUI {
	
	private int iMenu = -1;
	private boolean bFlag = true;
	
	public void init() {
		out.println("===== 성적 프로그램 ======");
		out.println("1. 학번 입력하기");
		out.println("2. 점수 입력하기");
		out.println("3. 점수 검색하기(학점)");
		out.println("4. 등수 검색하기");
		out.println("5. 종료하기");
		
		iMenu = inputNumber();
		Achievement a = Achievement.getInstance();
		String ID = "";
		int score = -1;
		String YorN = "y";
		switch(iMenu) {
			case 1:
				//학번 입력
				while(StringUtils.equals(YorN, "y")) {
					if(!a.isFull()) {
						out.print((Achievement.getNumOfStudent() + 1) + "번째 학생입니다. 학번을 입력하세요(예:0512001) > ");
						ID = String.format("%07d", inputNumber());
						a.setsList(ID);
						out.print("계속 하시겠습니까?(y/n) ");
						YorN = inputText();
					} else {
						out.println("더 이상 추가할 수 없습니다.");
						break;
					}
				}
				break;
			case 2:
				//점수 입력
				out.print("학번을 입력하세요(예:0512001) > ");
				ID = String.format("%07d", inputNumber());
				out.print("시험 점수를 입력하세요 > ");
				score = inputNumber();
				a.setsList(ID, score);
				break;
			case 3:
				//점수 검색(학점)
				out.print("학번을 입력하세요(예:0512001) > ");
				ID = String.format("%07d", inputNumber());
				if(a.hasID(ID)) {
					if(a.isInputEnd(ID) ) {
						out.println(ID + "의 학생은 "+a.getScore(ID)+"점 이고 "+a.getGrades(ID)+"학점입니다.");
					} else {
						out.println(ID+"의 학생은 아직 점수를 입력하지 않았습니다.");
					}
				} else {
					out.println(ID +"의 학생은 없습니다.");
				}
				break;
			case 4:
				//등수 검색
				out.print("학번을 입력하세요(예:0512001) > ");
				ID = String.format("%07d", inputNumber());
				int rank = a.getRank(ID);
				if(a.isInputEnd(ID)) {
					if(rank  == -1) {
						out.println(ID +"의 학생은 없습니다.");
					} else {
						out.println(ID +"의 학생은 "+rank+"등 입니다.");
					}
				} else {
					out.println(ID+"의 학생은 아직 점수를 입력하지 않았습니다.");
				}
				break;
			case 5:
				//프로그램 종료
				out.println("종료");
				bFlag = false;
				break;
			default :
				out.println("잘못된 메뉴값입니다.");
				break;
		}
		
	}
	
	public String inputText() {
		Scanner s = new Scanner(in);
		String str = null;
		while(StringUtils.equals(str, null)) {
			try {	
				str = s.next();
			} catch (InputMismatchException ime) {
				// TODO: handle exception
				out.println("잘못 입력하셨습니다. 올바른 값을 입력해 주세요.");
			} catch (Exception e) {
				out.println("잘못 입력하셨습니다. 올바른 값을 입력해 주세요.");
			}
		}
		return str;
	}
	
	public int inputNumber() {
		Scanner s = new Scanner(in);
		int num = 0;
		boolean flag = true;
		while(flag) {
			try {
				num = s.nextInt();
				flag = false;
			} catch (Exception e) {
				out.println("잘못 입력하셨습니다. 올바른 값을 입력해 주세요.");
				s.next();
				continue;
			}
		}
		return num;
	}
	
	public void uiPrint() {
		while(bFlag) {
			init();
		}

	}
}