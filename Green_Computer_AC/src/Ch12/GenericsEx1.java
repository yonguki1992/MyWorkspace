package Ch12;

import java.util.ArrayList;

public class GenericsEx1 {
	//<? extends T> // T 타입과 T 타입을 상속받는 자손 클래스 타입만을 사용할 수 있음.
	//<? super T>   // T 타입과 T 타입이 상속받은 조상 클래스 타입만을 사용할 수 있음.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Box<Fruit> fruitBox = new Box<Fruit>();
		Box<Fruit> fruitBox = new Box<Fruit>();
		fruitBox.add(new Fruit("Fruit"));
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
//		fruitBox.add(new Toy());
		System.out.println(fruitBox);
		
		
	}

}

class Box<B> {
	private B o;
	ArrayList<B> list = new ArrayList<B>();
	public Box(){
	}
	public void add(B o) {
		this.o = o;
		list.add(o);
	}

	public B get() {
		return this.o;
	}
	public String toString() {
		return (String) list.toString();
	}
}

class Fruit{ 
	String name;
	public Fruit(String name) {
		this.name = name;
	}
	public String toString() {
		return name;
	}
}
class Grape extends Fruit {

	public Grape() {
		super("Grape");
		// TODO Auto-generated constructor stub
	} 
	
}
class Apple extends Fruit {

	public Apple() {
		super("Apple");
		// TODO Auto-generated constructor stub
	} 
}
class Toy { }
