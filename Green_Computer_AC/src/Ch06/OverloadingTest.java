package Ch06;

public class OverloadingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyMath3 mm = new MyMath3();
		
		System.out.println("mm.add(3, 3) 결과 : " + mm.add(3,3));
		System.out.println("mm.add(3L, 3) 결과 : " + mm.add(3L,3));
		System.out.println("mm.add(3, 3L) 결과 : " + mm.add(3,3L));
		System.out.println("mm.add(3L, 3L) 결과 : " + mm.add(3L,3L));
		//오버로딩 연습
		System.out.println("mm.add(\"a\", 3) 결과 : " + mm.add("a", 3));
		System.out.println("mm.add(3, 'a', 3, 3) 결과 : " + mm.add(3,'a',3, 3));
		System.out.println("mm.add(true, 10.0, 3) 결과 : " + mm.add(true, 10.0, 3));
		System.out.println("mm.add(\"100\", 100, false) 결과 : " + mm.add("100", 100, false));
		
		
		int[] a = {100, 200, 300};
		System.out.println("mm.add(a) 결과 : " + mm.add(a));
		System.out.println("mm.add() 결과 : " + mm.add());
		System.out.println("mm.add(null) 결과 : " + mm.add(null));
	}

}

class MyMath3 {
	
	String add(String a, int b) {
		return a+b;
	}
	
	boolean add(String a, int b, boolean isRun) {
		if(!isRun) {
			if(a.equals(Integer.toString(b))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	boolean add(boolean isRun, double a, int b) {
		if(isRun) {
			if(a*b < 10.0) {
				return true;
			}else {
				return  false;
			}
		} else {
			return false;
		}
	}
	
	int add(int a, int b) {
		System.out.print("int add(int a, int b) - ");
		return a+b;
	}
	
	long add(int a, long b) {
		System.out.print("long add(int a, long b) - ");
		return a+b;
	}
	
	long add(long a, int b) {
		System.out.print("long add(long a, int b) - ");
		return a+b;
	}
	
	long add(long a, long b) {
		System.out.print("long add(long a, long b) - ");
		return a+b;
	}
	
	int add(int... arr) {
		if(arr != null) {
			System.out.print("int add(int... arr) - ");
			int result = 0;
			for(int i = 0; i < arr.length; ++i) {
				result += arr[i];
			}
			return result;
		} else {
			System.out.print("int add(null) - ");
			return -1;
		}
	}
}