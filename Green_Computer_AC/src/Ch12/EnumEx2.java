package Ch12;

import MyLib.IOFunctions;

public class EnumEx2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IOFunctions ioFunc = new IOFunctions("올바른 숫자를 입력해주세요","올바른 문자열을 입력해주세요");
		Kind1[] kArr = Kind1.values();

		for (Kind1 arr : kArr) {
			System.out.println(arr);
		}
		
		Value1[] vArr = Value1.values();
		
		for (Value1 arr : vArr) {
			System.out.println(arr);
		}
		ioFunc.finalize();
	}

}


enum Kind1 {
	CLOVER, HEART, DIAMOND, SPADE
}

enum Value1 {
	ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN
}