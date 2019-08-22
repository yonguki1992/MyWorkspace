package Ch15;

public class Ex02 {

	public static void main(String[] args) {
		int x = 10, y =20;
		
		System.out.println("x = "+x);
		System.out.println("y = "+y);
		
		x ^= y;
		y ^= x;
		x ^= y;
		
		System.out.println("스왑");
		System.out.println("x = "+x);
		System.out.println("y = "+y);

	}

}