package Ch06;

public class MyMathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyMath mm = new MyMath();
		
		long resultAdd = mm.add(10L, 12L);
		long resultSub = mm.sub(12L, 10L);
		long resultMul = mm.mul(12L, 10L);
		double resultDiv = mm.div(12L, 10L);
		
		mm.printResult(resultAdd);
		mm.printResult(resultSub);
		mm.printResult(resultMul);
		mm.printResult(resultDiv);
	}

}

class MyMath {
	
	long add(long a, long b) {
		return a + b;
	}
	
	long sub(long a, long b) {
		return a - b;
	}
	long mul(long a, long b) {
		return a * b;
	}
	double div(long a, long b) {
		if(b == 0) {
			System.out.println("0으로 나눌 수 없습니다.");
			return 0.0;
		} else {
			return (double)a / b;
		}
	}
	public void printResult(Object o) {
		System.out.println(o);
	}
}