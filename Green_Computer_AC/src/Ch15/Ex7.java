package Ch15;

public class Ex7 {

	public static void main(String[] args) {
//		final int MAX_NUM = 10000;
//		int cnt = 0;
//		for (int i = 1; i <= MAX_NUM; ++i) {
//			for (int k = (int)Math.log10(i); k >= 0; --k) 
//				if (i/(int)Math.pow(10, k) % 10 == 8) 
//					cnt++;
//		}
//		System.out.print(cnt);
		byte b = 126;
		
		System.out.println(b);
		
		b++;
		System.out.println(b);
		
		b++;
		System.out.println(b);
		
		b--;	//형변환 안 일어남
		b-=1;	//형변환 안 일어남
		//b=b-1;	//형변환이 일어남
	}

}
