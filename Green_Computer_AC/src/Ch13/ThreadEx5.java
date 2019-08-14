package Ch13;

//싱글 스레드에 비해 작업 시간이 차이나는 이유
//작업 전환 = 문맥 교환 = context switching
//	1. 바꿔주는 조건
//	2. 다음에 수행할 자료주소(PC) 저장
//	3. 문맥 교환 시간이 작업처리 시간보다 크면 비효율적인 쓰레드(피하자)

public class ThreadEx5 {
	
	static long startTime = System.currentTimeMillis();
	
	public static void main(String[] args) {	
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i < 300; ++i) {
					System.out.printf("%s", new String("|"));
				}
				System.out.println("\n소요 시간1 : "+(System.currentTimeMillis() - startTime));
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i < 300; ++i) {
					System.out.printf("%s", new String("-"));
				}
				System.out.println("\n소요 시간2 : "+(System.currentTimeMillis() - startTime));
			}
		});
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i < 300; ++i) {
					System.out.printf("%s", new String("/"));
				}
				System.out.println("\n소요 시간3 : "+(System.currentTimeMillis() - startTime));
			}
		}).start();
		t1.start();
		t2.start();
	}

}
