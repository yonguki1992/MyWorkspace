package Ch06;

public class FactorialTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(12));
		
	}
	
	static int factorial(int n) {
		if(n < 0 || n > 12) {
			System.out.println(n + "!을 구할 수 없습니다.");
			return -1;
		} else if(n == 0) {
			return 1;
		} else {
			return n * factorial(n-1);
		}
	}
}