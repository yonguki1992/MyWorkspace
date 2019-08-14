package Ch13;

public class ThreadEx15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunImplEx15 r1 = new RunImplEx15("*");
		RunImplEx15 r2 = new RunImplEx15("**");
		RunImplEx15 r3 = new RunImplEx15("***");

		r1.start();
		r2.start();
		r3.start();

		// 교착상태를 발생시킬 수 있어 supend와 stop 사용은 권장되지 않음
		// 해결 : run(), sleep() 오버라이드
		// suspend resume 을 사용하면 바쁜 대기상태가 됨,
		// yield()를 사용하는 것이 더 나음(양보 후 실행 대기 상태로 들어감)
		
		try {
			Thread.sleep(2000);
			r1.suspend(); // th1 을 잠시 중단
			Thread.sleep(2000);
			r2.suspend();
			Thread.sleep(3000);
			r1.resume(); // th1 을 다시 동작하도록 함
			Thread.sleep(3000);
			r1.stop(); // th1 을 강제 종료
			r2.stop();
			Thread.sleep(2000);
			r3.stop();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

class RunImplEx15 implements Runnable {

	volatile boolean suspended = false;
	volatile boolean stopped = false;

	Thread th;

	public RunImplEx15(String name) {
		// TODO Auto-generated constructor stub
		th = new Thread(this, name);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		String name = th.getName();
		while (!stopped) {
			if (!suspended) {
				System.out.println(name);
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			} else {
				Thread.yield();
			}
		}
		System.out.println(name + " - stopped!");
	}

	public void suspend() {
		suspended = true;
		th.interrupt();
		System.out.println(th.getName() + " - interrupt() by suspend()");
	}

	public void stop() {
		stopped = true;
		th.interrupt();
		System.out.println(th.getName() + " - interrupt() by stop()");
	}
	
	public void resume() {
		suspended = false;
	}
	public void start() {
		th.start();
	}
}