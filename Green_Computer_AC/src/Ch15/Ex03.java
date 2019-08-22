package Ch15;

public class Ex03 {
	public static void main(String[] args) {
		int color = 0xAABBCCDD;

		int aErase = 0x00FFFFFF;
		int rErase = 0xFF00FFFF;
		int gErase = 0xFFFF00FF;
		int bErase = 0xFFFFFF00;

		int setA = 0x77000000;
		int setR = 0x00770000;
		int setG = 0x00007700;
		int setB = 0x00000077;

		//toHexS
		System.out.println(Integer.toHexString(color));

		// 특정 값 지우는 소스코드
		// 0으로 & 연산하면 제거
		// 1로 & 연산하면 통과
		System.out.println(Integer.toHexString(color & rErase));

		// 0 으로 | 연산하면 통과
		// 1 로  | 연산하면 설정
		System.out.println(Integer.toHexString((color & rErase) | setR ));
		
		System.out.println("alpha = "+Integer.toHexString(color >> 24 & 0xFF));
		System.out.println("red = "+Integer.toHexString(color >> 16 & 0xFF));
		System.out.println("green = "+Integer.toHexString(color >> 8 & 0xFF));
		System.out.println("blue = "+Integer.toHexString(color & 0xFF));
		
		
		
		System.out.println("alpha = "+Integer.toHexString(color << 24 | 0x01));
		System.out.println("red = "+Integer.toHexString(color << 16 | 0x01));
		System.out.println("green = "+Integer.toHexString(color << 8 | 0x01));
		System.out.println("blue = "+Integer.toHexString(color | 0x0));
	}
}
