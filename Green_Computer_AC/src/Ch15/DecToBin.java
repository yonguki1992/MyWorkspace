package Ch15;

import MyLib.*;

public class DecToBin {
	// & 지울때
	// | 설정할때

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ScannerFunctions io = new ScannerFunctions("", "");
		System.out.println("1~255 이내의 정수를 입력하시오");
		int dec = io.inputNumber();
		int exponent = 1;

		while (dec > 255 || dec < 1) {
			System.out.println("1~255 이내의 정수를 다시 입력하시오");
			dec = io.inputNumber();
		}

//		for(int i = dec; i > 0; i/=2) 
//			if(i < dec) 
//				exponent *= 2;
//			
//		for(int j = exponent; j > 0; j/=2) {
//			System.out.print(dec/j);
//			dec = dec%j;
//		}
		
		//지수로그 활용
		for (int j = (int) Math.pow(2, (int)logB(dec,2.0)); j > 0; j /= 2) {
			System.out.print(dec / j);
			dec = dec % j;
		}
		System.out.println();
		int num = 1;

		while (num != 0) {
			num = io.inputNumber();
			if (num == 0)
				continue;

			if (num < 0 || num > 255) {
				continue;
			}

			int mask = 0x80;

			for (int i = 0; i < 8; ++i) {
				System.out.print((mask & num) == mask ? 1 : 0);
				mask >>= 1;
			}

		}

		io.finalize();
	}

	public static double logB(double x, double base) {
		return Math.log(x) / Math.log(base);
	}
}
