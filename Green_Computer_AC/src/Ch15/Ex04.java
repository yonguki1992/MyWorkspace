package Ch15;

public class Ex04 {
	public static void main(String[] args) {
		
		int num = 0x0660;
		int num2 = 0x6220;
		int num3 = 0x4640;
		int num4 = 0x4620;
		int num5 = 0x4444;
		int rotate;
		int mask = 0x8000;	//2진수 16자리
		
		for(int i =0; i < 16; ++i) {
			System.out.print((mask&num5)==mask ? '■' : '□');
			mask >>= 1;
			if((i+1)%4==0) 
				System.out.println();	//4자리 마다 줄바꿈
		}
	}
}
