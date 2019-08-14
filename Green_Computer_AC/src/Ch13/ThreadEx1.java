package Ch13;

public class ThreadEx1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ThreadEx1_1 t0 = new ThreadEx1_1();

		Thread t1 = new Thread(new ThreadEx1_2());

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//for(int i=0;i<15;++i) {
				//	System.out.println(Thread.currentThread().getName());
				//}				
				throwException();

			}

			public void throwException() {
				try {
					throw new Exception();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

		});

		// 호출 시 call stack 생성 -> run() 이 새로 생성된 call stack에서 수행됨.
		// t1.start(); //에러!! : 작업 종료된 객체는 다시 사용할 수 없음, 다시 생성해야함.
		t0.start();
		t1.start();
		t2.start();
		
//		t0.run();
//		t1.run();
//		t2.run();
	}

}

//상속
class ThreadEx1_1 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		for(int i=0;i<15;++i) {
//			System.out.println(getName());
//		}
		throwException();
	}

	public void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

//구현(자주씀)
class ThreadEx1_2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		for(int i=0;i<15;++i) {
//			System.out.println(Thread.currentThread().getName());
//		}
		throwException();

	}

	public void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

//프레임워크를 이용
