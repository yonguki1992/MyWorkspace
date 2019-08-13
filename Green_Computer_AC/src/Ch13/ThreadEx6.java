package Ch13;

import javax.swing.JOptionPane;

public class ThreadEx6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
	}
	
	static void init() {
		//스레드의 우선순위는 따로 지정하지 않았다면 5
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 100; i > 0; --i) {
					System.out.print("-");
					try {
						Thread.sleep(100);
					} catch (Exception e) {	}
				}
				System.out.println("\nt1 작업끝");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 100; i > 0; --i) {
					System.out.print("|");
					try {
						Thread.sleep(100);
					} catch (Exception e) {	}
				}
				System.out.println("\nt2 작업끝");
			}	
		});
		
		//우선 순위는 100% 반영되는게 아니라, 스케쥴러의 처리 순서에 따른다. 
		//이미 실행 중인 스레드는 우선순위가 낮더라도 빠지지 않음
		t1.setPriority(1);	//우선순위가 낮다 - 
		t2.setPriority(7);	//우선순위가 높다 - 인터럽트, vip 처리 등등
		System.out.println();
		System.out.println("t1 우선순위(-) " + t1.getPriority());
		System.out.println("t2 우선순위(|) " + t2.getPriority());		
		
		t1.start();
		t2.start();
		String input = JOptionPane.showInputDialog("아무 값이나 입력하시오. ");
		System.out.println("입력하신 값은 " + input +" 입니다.");
	}
	
}
