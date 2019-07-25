package Homework;

public class SeventhWeek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method1(true);
		method1(false);
	}
	
	static void method1(boolean b)  {
		try {

			System.out.println(1);
			if(b) throw new ArithmeticException();
			System.out.println(2);
			
		} catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println(3);
			return;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(4);
			return;
		} 
		finally {
			// TODO: handle finally clause
			System.out.println(5);
		}
		System.out.println(6);
	}
	
	static void method2() {
		throw new NullPointerException();
	}
}
