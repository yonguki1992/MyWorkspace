package Ch12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GenericEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FruitBox<Fruit1> fb = new FruitBox<Fruit1>();
		fb.add(new Fruit1("Fruit", 1));
		
		FruitBox<Grape1> gb = new FruitBox<Grape1>();
		gb.add(new Grape1(10));
		
		FruitBox<Apple1> ab = new FruitBox<Apple1>();
		ab.add(new Apple1(15));
		
		//Toy1 클래스는 eatable을 구현하지 않고, Fruit1 클래스를 상속받지 않기 때문에 에러 
		//FruitBox<Toy1> tb = new FruitBox<Toy1>();
		//tb.add(new Toy1());
				
		System.out.println(Juicer.makeJuice(fb));
		System.out.println(Juicer.makeJuice(gb));
		System.out.println(Juicer.makeJuice(ab));
		
		FruitBox<Fruit1> fb2 = new FruitBox<Fruit1>();
		fb2.add(new Fruit1("Fruit", 1));
		fb2.add(new Grape1(10));
		fb2.add(new Apple1(20));
		fb2.add(new Apple1(30));
		fb2.add(new Fruit1("Fruit", 2));
		fb2.add(new Grape1(100));
		fb2.add(new Apple1(2));
		fb2.add(new Apple1(31));
		//상속관계에서 자손들에 대해 지네릭을 구현할 때는 <? super T>
		//상속관계에서 부모에 대한 지네릭을 구현할 때는 <? extends T>

		Collections.sort(fb2.getList(), new Comparator<Fruit1>() {
			@Override
			public int compare(Fruit1 f1, Fruit1 f2) {
				return f1.weight - f2.weight;
			}
		});
		System.out.println(fb2);

	}

}

class Juice {
	String name;
	public Juice(String name) {
		this.name = name +"Juice";
	}
	
	public String toString() {
		return name;
		
	}
}
class Juicer {
	//<? super Apple1> 하면 에러남 Grape1 가 빠지기 때문
	static Juice makeJuice(FruitBox<? extends Fruit1> box) {
		String tmp = "";
		for(Fruit1 f : box.getList()) {
			tmp += f + " ";
		}
		return new Juice(tmp);
	}
	
}


class Fruit1 implements Eatable{
	String name;
	int weight;
	

	public Fruit1() {
	
	}
	public Fruit1(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	public String toString() {
		return name+"("+weight+")";
	}
}

class Grape1 extends Fruit1 {

	public Grape1(int weight) {
		super("Grape", weight);
		// TODO Auto-generated constructor stub
	} 
	
}

class Apple1 extends Fruit1 {

	public Apple1(int weight) {
		super("Apple", weight);
		// TODO Auto-generated constructor stub
	} 
}
class Toy1 { }

//<T extends 상위 인터페이스 명> or <T extends 상위 클래스 명> 
class FruitBox<T extends Fruit1 & Eatable> extends Box1<T> { }

interface Eatable { }

class Box1<T> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) {
		list.add(item);
	}
	ArrayList<T> getList(){
		return list;
	}
	T get(int i) {
		return list.get(i);
	}
	int size() {
		return list.size();
	}
	public String toString() {
		return list.toString();
	}
}