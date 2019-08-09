package Ch07;

public class FighterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fighter f = new Fighter();
		Fightable fa = new Fighter();
		

		
		if(f instanceof Units) {
			System.out.println("f는 Unit 클래스의 자손");
		}
		
		if(f instanceof Fightable) {
			System.out.println("f는 Fightable 인터페이스의 자손");
		}
		
		if(f instanceof Attackable) {
			System.out.println("f는 Attackable 인터페이스의 자손");
		}
		
		if(f instanceof Object) {
			System.out.println("f는 Object의 자손");
		}
		
		method1( new Fightable() {
			@Override
			public void attack(Units u) {
				// TODO Auto-generated method stub
			
			}
			
			@Override
			public void move(int x, int y) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	static void method1(Fightable f) {
		f.move(0, 0);
	}
}

interface Fightable extends Movable, Attackable {
	
}

interface Movable {
	void move(int x, int y);
}

interface Attackable {
	void attack(Units u);
}

class Fighter extends Units implements Fightable {
	@Override
	public void attack(Units u) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}

class Units {
	int currentHP;
	int x;
	int y;
	
}