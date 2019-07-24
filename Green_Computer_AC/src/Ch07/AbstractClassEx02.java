package Ch07;

public class AbstractClassEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Unit[] group = new Unit[4];
		group[0] = new Marine1();
		group[1] = new Tank1();
		group[2] = new Dropship1();
		group[3] = new Marine1();
		
		for(Unit Unit : group) {
			Unit.move(100, 40);
		}
		
	}

}

abstract class Unit {
	int x, y;
	abstract void move(int x, int y);
	void stop() {
		
	}
}

class Marine1 extends Unit {
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println(this.getClass().getName()+"을 ("+this.x +", "+this.y+")로 이동함.");
	}

	void stimPack() {
		
	}
}

class Tank1 extends Unit {
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;		
		System.out.println(this.getClass().getName()+"을 ("+this.x +", "+this.y+")로 이동함.");
	}

	void changeMode() {
		
	}
}


class Dropship1 extends Unit {
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println(this.getClass().getName()+"을 ("+this.x +", "+this.y+")로 이동함.");
	}

	void load() {
		
	}
	void unload() {
		
	}
}
