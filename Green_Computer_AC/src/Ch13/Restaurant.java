package Ch13;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang3.StringUtils;

public class Restaurant {
	public static void main(String[] args) throws InterruptedException {
		Table table = new Table();

		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"), "Customer1").start();
		new Thread(new Customer(table, "burger"), "Customer2").start();

		Thread.sleep(2000);
		System.exit(0);
	}
}

class Customer implements Runnable {
	private Table table;
	private String food;

	Customer(Table table, String food) {
		this.table = table;
		this.food = food;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
			String name = Thread.currentThread().getName();

//			if (eatFood()) {
//				System.out.println(name + " ate a " + food);
//			} else {
//				System.out.println(name + " failed to eat. :-( ");
//			}
			table.remove(food);
			System.out.println(name + " ate a " + food);

		}
	}

}

class Cook implements Runnable {

	private Table table;

	Cook(Table table) {
		this.table = table;
	}

	@Override
	public void run() {
		while (true) {
			// 임의의 요리를 하나 선택해서 table에 추가한다.
			int index = (int) (Math.random() * table.dishNum());
			table.add(table.dishNames[index]);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {

			}
		}

	}
}

class Table {

	String[] dishNames = { "donut", "donut", "buger" };
	final int MAX_FOOD = 6;

	private ArrayList<String> dishes = new ArrayList<String>();
	private ReentrantLock lock = new ReentrantLock();
	private Condition forCook = lock.newCondition();
	private Condition forCust = lock.newCondition();

//	public synchronized void add(String dish) {
//		while (dishes.size() >= MAX_FOOD) {
//			String name = Thread.currentThread().getName();
//			System.out.println(name + " is waiting.");
//			try {
//				wait();
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO: handle exception
//			}
//		}
//		dishes.add(dish);
//		notify();
//		System.out.println("Dishes : " + dishes.toString());
//	}
	// lock 활용
	public void add(String dish) {
		lock.lock();
		try {
			while (dishes.size() >= MAX_FOOD) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is waiting.");
				try {
					forCook.await();	//wait(); //cook 쓰레드를 기다리게 함
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
			dishes.add(dish);
			System.out.println("Dishes : " + dishes.toString());
		} finally {
			lock.unlock();
		}

	}

	public void remove(String dishName) {
		lock.lock();
		// synchronized (this) { // synchronized 블록 추가함
		String name = Thread.currentThread().getName();
		try {
			while (dishes.size() == 0) {
				System.out.println(name + " is waiting.");
				try {
					forCust.await(); // wait(); //cust 쓰레드를 기다리게 함
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
			while (true) {
				for (int i = 0; i < dishes.size(); ++i) {
					if (StringUtils.equals(dishName, dishes.get(i))) {
						dishes.remove(i);
						forCook.signal();// notify(); //잠자고 있는 cook을 깨움
						return;
					}
				}
				try {
					System.out.println(name + " is waiting...");
					forCust.await(); // wait(); //cust 쓰레드를 기다리게 한다.
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
			// }
		} finally {
			lock.unlock();
		}
	}

	public int dishNum() {
		return dishNames.length;
	}

}