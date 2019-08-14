package Ch13;

public class ThreadEx12 {

	public static void main(String[] args) {
		Thread th1 = new Thread(new ThreadEx12_1());
		Thread th2 = new Thread(new ThreadEx12_2());
		
		th1.start();
		th2.start();
		
		try {
			//th1.sleep(2000);	//오류는 아님.
			Thread.sleep(2000);	//sleep() 은 현재 실행 중인 Thread에 대해 작동함.
		} catch (InterruptedException e) {	}
		
		System.out.println("\n<<main 종료>>");
	}

}

class ThreadEx12_1 implements Runnable {
	
	@Override
	public void run() {
		for(int i = 0; i < 300; ++i) {
			System.out.print("-");
		}
		System.out.print("\n<<th1 종료>>");
	}
	
}


class ThreadEx12_2 implements Runnable {
	
	@Override
	public void run() {
		for(int i = 0; i < 300; ++i) {
			System.out.print("|");
		}
		System.out.println("\n<<th2 종료>>");
	}
	
}