package Ch07;

interface Repairable {
	default void method() {
		
	}
}

class PlayerUnit {
	int hitPoint;
	final int MAX_HP;
	public PlayerUnit(int hp) {
		// TODO Auto-generated constructor stub
		MAX_HP = hp;
	}
}

class GroundUnit extends PlayerUnit {
	public GroundUnit(int hp) {
		// TODO Auto-generated constructor stub
		super(hp);
	}
}

class AirUnit extends PlayerUnit {
	public AirUnit(int hp) {
		// TODO Auto-generated constructor stub
		super(hp);
	}
}

class Tank extends GroundUnit implements Repairable {
	Tank() {
		super(150);
		hitPoint = MAX_HP;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Tank";
	}
}

class Dropship extends AirUnit implements Repairable {
	Dropship() {
		super(125);
		hitPoint = MAX_HP;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Dropship";
	}
}

class Marine extends GroundUnit {
	Marine() {
		super(40);
		hitPoint = MAX_HP;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Marine";
	}
}

class SCV extends GroundUnit implements Repairable {
	SCV() {
		super(60);
		hitPoint = MAX_HP;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "SCV";
	}
	
	@Override
	public void method() {
		// TODO Auto-generated method stub
		Repairable.super.method();
	}
	
	void repair(Repairable r) {
		PlayerUnit u = (PlayerUnit)r;
		while (u.hitPoint != u.MAX_HP) {
			u.hitPoint++;
		}
		System.out.println(u.toString() + "의 수리가 끝났습니다.");
	}
}


public class RepairableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tank tank = new Tank() {
			@Override
			public void method() {
				// TODO Auto-generated method stub
				
			}
		};
		Dropship dropship = new Dropship();
		
		Marine marine = new Marine();
		SCV scv = new SCV();
		
		
		
		scv.repair(tank);
		scv.repair(dropship);
		scv.repair(scv);
	}

}


