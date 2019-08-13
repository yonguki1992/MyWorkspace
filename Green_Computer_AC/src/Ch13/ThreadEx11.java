package Ch13;

import java.util.Iterator;
import java.util.Map;

public class ThreadEx11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new ThreadEx11_1(), "Thread 1");
		Thread t2 = new Thread(new ThreadEx11_2(), "Thread 2");
		
		t1.start();
		t2.start();
	}

}

class ThreadEx11_1 implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5 * 1000);
		} catch (Exception e) {	}
	}
}

class ThreadEx11_2 implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Map map = Thread.getAllStackTraces();
		Iterator it = map.keySet().iterator();
		
		int x = 0;
		
		while(it.hasNext()) {
			Object obj = it.next();
			Thread t = (Thread)obj;
			StackTraceElement[] ste = (StackTraceElement[])(map.get(obj));
			
			System.out.println("[" + ++x + "] name : " + t.getName()
							   + ", group : " + t.getThreadGroup().getName()
							   + ", daemon : " + t.isDaemon());
			
			for(int i = 0; i < ste.length; ++i) {
				System.out.println(ste[i]);
			}
			System.out.println();
		}
		
	}
}