package Ch11;

import java.util.HashSet;
import java.util.Objects;

public class HashSetEx4 {
	public static void main(String[] args) {
		HashSet set = new HashSet();
		
		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new String("abc"));
		/*
		 *객체를 해쉬셋에 담고, 중복요소 제거하려면 
		 *해당 객체의 클래스에 
		 *public boolean equals() 및 public  int hashCode() 메서드를 작성해줘야 한다
		 *왜냐면 HashSet.add(Object) 메서드를 할 때 
		 *equals()와 hashCode() 메서드를 호출하기 때문이다
		 * %% .add(Object) 처리 순서 : 
		 * hashCode() 리턴값 참 -> eqauls() 리턴값이 참 -> 동등객체 -> 저장 X
		 * hashCode() 리턴값 거짓 -> 다른객체 -> 저장 O
		*/
		set.add(new Person2("david",10));
		set.add(new Person2("david",10));
		
		Person2 p = new Person2("tom",11);
		set.add(p);
		set.add(p);
		
		System.out.println(set);
	}
}


class Person2 {
	String name;
	int age;
	
	Person2(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Person2) {
			Person2 tmp = (Person2)o;
			return name.equals(tmp.name) && age == tmp.age;
		}
		return false;
	}
	
	public int hashCode() {
		return Objects.hash(name, age);
	}
	
	public String toString() {
		return name+":"+age;
	}
	
}