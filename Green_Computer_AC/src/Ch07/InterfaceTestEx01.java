package Ch07;

public class InterfaceTestEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayingCardGame pcg = new PlayingCardGame();
	}

}

interface PlayingCard {
	// 상수 필드
	// 상수를 만들 땐 상수 초기값을 넣는다.
	public static final int MAX = 999;
	public static final int SPADE = 4;
	public int DIAMOND1 = 3;
	final int DIAMOND2 = 3;
	static int DIAMOND3 = 3;
	int DIAMOND4 = 3;
	// DIAMOND4 += 10; // 에러 ) public static final 이 생략된 형태

	// 추상메서드 필드
	public abstract void sum();

	public abstract String getCardKind();

	int setCardKind(); // public abstract 생략된 형태
}

//인터페이스끼리 연결은 extends 상속으로 할 수 있다.
interface StoppingCard extends PlayingCard{
	// 상수
	// 추상 메서드
	void stop1();

	public abstract String stop2();

}


class PlayingCardGame implements StoppingCard {
	@Override
	public void sum() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getCardKind() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int setCardKind() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void stop1() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String stop2() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
