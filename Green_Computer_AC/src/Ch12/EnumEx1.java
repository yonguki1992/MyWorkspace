package Ch12;

import org.apache.commons.lang3.StringUtils;

import MyLib.IOFunctions;

public class EnumEx1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IOFunctions ioFunc = new IOFunctions("올바른 숫자를 입력해주세요","올바른 문자열을 입력해주세요");
		Kind[] kArr = Kind.values();

		for (Kind arr : kArr) {
			System.out.println(arr);
		}

		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Direction.SOUTH;
		Direction d4 = Direction.valueOf(Direction.class, "NORTH");
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("d3 = " + d3);
		System.out.println("d4 = " + d4);

		System.out.println("d1==d2 ? " + (d1 == d2));
		System.out.println("d1==d3 ? " + (d1 == d3));
		System.out.println("d1.eqauls(d3) ? " + d1.equals(d3));
		// System.out.println("d2 > d3 = "+(d2>d3));
		System.out.println("d1.compareTo(d4) ? " + d1.compareTo(d4));
		System.out.println("d2.compareTo(d4) ? " + d2.compareTo(d4));

		switch (d4) {
			case EAST:
				System.out.println("동");
				break;
			case WEST:
				System.out.println("서");
				break;
			case SOUTH:
				System.out.println("남");
				break;
			case NORTH:
				System.out.println("북");
				break;
			default:
				System.out.println("그런방향 없음");
				break;
		}
		
		Direction[] dArr = Direction.values();
		
		for(Direction d : dArr) {
			System.out.println(d.name()+"("+d.getSymbol()+")"+" = "+d.getValue());
		}
		
		System.out.print("숫자를 하나 입력해 주세요. > ");
		int i = ioFunc.inputNumber();
		try {
			System.out.println(dArr[i].name()+"("+dArr[i].getSymbol()+")"+" = "+dArr[i].getValue());			
		} catch(IndexOutOfBoundsException iobe) {
			System.out.println("0 ~ 3 까지 입력 바랍니다.");
		}


		System.out.print("방향 문자를 하나 입력해 주세요.(<,>,V,^) > ");
		String str = ioFunc.inputText();
		
		int key = -1;
		for(int idx = 0; idx < dArr.length; ++idx) {
			if(StringUtils.equals(dArr[idx].getSymbol(), str)) {		
				key = idx;
				break;
			}
		}
		if(key != -1) {
			System.out.println(dArr[key].name()+"("+dArr[key].getSymbol()+")"+" = "+dArr[key].getValue());
		} else {
			System.out.println("그런 방향은 없습니다.");
		}
	
		Transport[] t = Transport.values();
		System.out.print("이동 거리를 입력해 주세요. > ");
		int dist = ioFunc.inputNumber();
		for (Transport arr : t) {
			System.out.println(arr + "의 운송료는 " + arr.fare(dist));
		}
		ioFunc.finalize();
	}

}

//열거형 getter 추가 (setter는 만들 수 없음)
enum Direction {
	EAST(-3, ">"), WEST(10, "<"), SOUTH(9, "V"), NORTH(0, "^");
	
	private final int value;
	private final String symbol;
	private Direction(int value, String symbol) {
		this.value = value;
		this.symbol = symbol;
	}
	
	public int getValue() {
		return value;
	}
	public String getSymbol() {
		return symbol;
	}
}

//열거형의 abstract 구현
enum Transport {
	BUS(100){	int fare(int dist) { return dist * BASIC_FARE; } },
	TRAIN(150){	int fare(int dist) { return dist * BASIC_FARE; } },
	SHIP(200){	int fare(int dist) { return dist * BASIC_FARE; } },
	AIRPLANE(300){	int fare(int dist) { return dist * BASIC_FARE; } };
	
	protected final int BASIC_FARE;
	private Transport(int basicFare) {
		BASIC_FARE = basicFare;
	}
	public int getBasicFare() {
		return BASIC_FARE;
	}
	abstract int fare(int dist);
}

enum Kind {
	CLOVER, HEART, DIAMOND, SPADE
}

enum Value {
	ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN
}