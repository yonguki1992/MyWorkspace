package Ch07;

public class AbstractClassEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}

//추상메서드를 포함하려면 추상클래스로 선언해야함.
//추상클래스는 추상메서드를 갖고 있어도 되고 가지지 않아도 됨.
abstract class Player {
	int a;
	
	public Player() {
		
	}

	void method1() {
		System.out.println("일반 메소드");
	}
	abstract void play(int currentPos);
	abstract void stop();
}

//추상클래스 상속 시 부모의 추상메서드를 반드시 오버라이드 해줘야 함.
//자손클래스가 반드시 추상 메서드를 재정의해서 사용하도록 강제하기위해 이용.
class AudioPlayer extends Player {
	@Override
	void play(int currentPos) {
		
	}
	
	@Override
	void stop() {
		
	}
}

abstract class AbstractPlayer extends Player {
	void method2() {
		System.out.println("일반 메소드");
	}
	abstract void pause();
}

class PCPlayer extends AbstractPlayer {
	@Override
	void pause() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	void play(int currentPos) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	void stop() {
		// TODO Auto-generated method stub
		
	}
}