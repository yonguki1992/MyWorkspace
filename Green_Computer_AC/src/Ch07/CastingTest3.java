package Ch07;

public class CastingTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p = new Child();
		Child c = new Child();
		System.out.println("p.x = " + p.x);
		p.method();
		
		System.out.println("p.x = " + c.x);
		c.method();
	}

}

class Parent {
	int x = 100;
	void method() {
		System.out.println("부모 메소드 부분!!");
	}
}

class Child extends Parent {
	int x = 200;
	void method() {
		//super.method();
		System.out.println("자식 메소드 부분!!");
	}
}