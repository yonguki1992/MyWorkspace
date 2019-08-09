package Ch06;

public class CallStackTest {
	public static void main(String[] args) {
		System.out.println("main 호출");
		first();
		System.out.println("main 끝남");
	}
	
	static void first() {
		System.out.println("first 호출");
		second();
		System.out.println("first 끝남");
	}
	
	static void second() {
		System.out.println("second 호출");
		System.out.println("second()");
		System.out.println("second 끝남");
	}
}
