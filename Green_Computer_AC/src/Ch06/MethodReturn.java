package Ch06;

public class MethodReturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = adder(4,5);
		System.out.println("4와 5의 합 : " + result);
		System.out.println("3.5의 제곱 : " + square(3.5));
	}
	
	static int adder(int a, int b) {
		return a + b;
	}
	
	static double square(double num) {
		return num * num;
	}
	
}
