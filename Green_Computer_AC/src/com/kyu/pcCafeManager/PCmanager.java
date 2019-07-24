package com.kyu.pcCafeManager;

import static java.lang.System.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PCmanager {
	//try - catch 사용 하여 메서드에서 넘어온 예외 처리 할 것
	//while 사용하고 printUi의 리턴값에 따라 루프 유지 여부 결정할 것.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UImanager ui = UImanager.getUImanagerInstance();
		ui.init();
		ui.printUI();

		
	}
}

class UImanager {
	private static UImanager instance;
	
	private int pcNum = 0;
	private int iMem = 0;
	private int iMenu;
	private String strCpu = " ";
	private PCinfo[] pc;

	private UImanager() {

	}
	
	//pc방 매니저는 한 사람뿐임.
	//인스턴스 생성에 제한을 둠
	public static UImanager getUImanagerInstance() {
		if(instance == null) {
			instance = new UImanager();
		}
		return instance;
	}
	
	public void init() {
		Scanner scan = new Scanner(in);
		while(this.pcNum == 0) {
			try {
				out.print("등록할 컴퓨터의 수량을 입력하세요 > ");
				this.pcNum = scan.nextInt();

			} catch (Exception e) {
				scan.next();
				out.println("잘못 입력하셨습니다. 올바른 수량을 입력해 주세요.");
				
				continue;
			}
		}
		this.pc = new PCinfo[this.pcNum];
		for (int i = 0; i < pcNum; ++i) {
			this.pc[i] = new PCinfo();
		}

		for (int id = 0; id < this.pc.length; ++id) {

			try {
				managingPCinfo(id);	
			} catch(Exception e) {

				out.println("잘못 입력하셨습니다. 올바른 수량을 입력해 주세요.");
				id--;
				continue;
			}
			
		}
		// scan.close();
	}

	// 리턴타입 switch 문 파라미터로 할 것
	public void printUI() {
		boolean flag = true;
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Scanner scan = new Scanner(in);
		do {
			out.println("======================");
			out.println("1. PC 사용시작[1]~[" + (this.pc.length) + "]");
			out.println("2. PC 사용종료[1]~[" + (this.pc.length) + "]");
			out.println("3. PC 사용시간[1]~[" + (this.pc.length) + "]");
			out.println("4. PC 관리");
			out.println("5. 매출 정보 출력");
			out.println("6. 프로그램 종료...");
			out.println("======================");
			out.print("메뉴의 번호를 선택하세요(1~6) > ");
			String input = scan.next();

			flag = true;
			out.flush();

			switch (input) {
			// 관리자로부터 PC번호를 입력받아 해당 PC의 start 메서드를 호출
			// 갱신할 수 없게 만들어야함
			case "1":
				try {
					out.print("컴퓨터의 번호를 입력하세요. > ");
					pcNum = scan.nextInt()-1;
					pc[pcNum].start(Calendar.getInstance().getTimeInMillis());
				} catch (Exception e) {
					continue;
				}
				
				break;
			// 관리자로부터 PC번호를 입력받아 해당 PC의 stop 메서드를 호출
			//갱신할 수 없게 만들어야함.
			case "2":
				try {
					out.print("컴퓨터의 번호를 입력하세요. > ");
					pcNum = scan.nextInt()-1;
					pc[pcNum].stop(Calendar.getInstance().getTimeInMillis());
				} catch (Exception e) {
					continue;
				}
				
				break;
				
			//특정 pc의 사용시간 출력
			case "3" :
				try {
					Calendar c = Calendar.getInstance();
					out.print("컴퓨터의 번호를 입력하세요. > ");
					pcNum = scan.nextInt()-1;
					if (pc[pcNum].getIStop() == 0) {
						//out.println((pcNum+1) + "번 PC 사용 시간 > " + format.format(new Long(Calendar.getInstance().getTimeInMillis())));
						
						out.println((pcNum+1) + "번 PC 사용 시간 > " + format.format(this.pc[pcNum].getTotalTime(c.getTimeInMillis() - 9*3600*1000)));
					} else {
						
						out.println((pcNum+1) + "번 PC 사용 시간 > " + format.format(this.pc[pcNum].getTotalTime(pc[pcNum].getIStop() - 9*3600*1000)));
					}
				} catch (Exception e) {
					continue;
				}
				
				

				
				break;
			// pc 관리
			case "4":
				try {
					out.print("컴퓨터의 번호를 입력하세요. > ");
					pcNum = scan.nextInt()-1;
					managingPCinfo(pcNum);
				} catch (Exception e) {
					continue;
				}
				break;
			// 매출 정보 출력
			case "5":
				
				for (int i = 0; i < pc.length; ++i) {
					if (this.pc[i].getIStart() == 0) {
						out.println(i + "번 PC는 사용하고 있지 않습니다.");
						continue;
					}try {
						if (this.pc[i].getIStop() == 0) {
							out.println((i+1) + "번 PC의 사용금액 > " + pc[i].getTotal(Calendar.getInstance().getTimeInMillis()) + " 원");
						} else {
							out.println((i+1) + "번 PC의 사용금액 > " + pc[i].getTotal() + " 원");
						}	
					}catch (Exception e) {
						// TODO: handle exception
					}
					
				}
				
				break;
			//프로그램 종료
			case "6":
				out.println("프로그램을 종료합니다...");
				flag = false;
				break;
				
			// 잘못된 선택지 입력시
			default:
				out.println("올바른 메뉴의 번호를 입력해 주세요. (1~6)");
				break;
			}

		} while (flag);
		// scan.close();
	}

	// 매장 내 PC를 새로 추가하거나 정보를 고칠 때 사용
	public void managingPCinfo(int id) throws Exception{
		if (this.pc == null) {
			out.println("등록하신 PC가 없습니다.");
			return;
		}

		Scanner scan = new Scanner(in);
		if (this.pc.length <= id) {
			PCinfo[] newPC = new PCinfo[id];
			PCinfo[] temp = this.pc;
			this.pc = newPC;

			for (int i = 0; i < newPC.length; ++i) {
				if (i < temp.length) {
					this.pc[i] = temp[i];
				} else {
					out.println("PC " + (i + 1) + "번");

					out.print("추가할 PC의 기종을 입력하세요. > ");
					this.strCpu = scan.next();

					out.print("추가할 PC의 메모리용량을 입력하세요. > ");
					this.iMem = scan.nextInt();
					this.pc[i].setPCinfo(i + 1, this.strCpu, this.iMem);
				}
			}

		} else {
			
			if (pc[id].getIStart() <= 0) {
				out.println("PC " + (id + 1) + "번");

				out.print("변경할 PC의 기종을 입력하세요. > ");
				this.strCpu = scan.next();

				out.print("변경할 PC의 메모리용량을 입력하세요. > ");
				this.iMem = scan.nextInt();
				pc[id].setPCinfo(id + 1, this.strCpu, this.iMem);
			} else {
				out.println("사용중인 PC의 정보를 변경할 수 없습니다.");
			}
		}
		// scan.close();
	}
}