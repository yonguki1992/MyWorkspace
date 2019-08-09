package Ch11;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class HashSetEx2 {

	static int getGroupCount(TreeSet set, int from, int to) {
		Student s1 = new Student("", 0, 0, from, from, from);
		Student s2 = new Student("", 0, 0, to, to, to);
		return set.subSet(s1, s2).size();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet set = new TreeSet(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				if (o1 instanceof Student && o2 instanceof Student) {
					Student s1 = (Student) o1;
					Student s2 = (Student) o2;
					return (int) (s1.getAverage() - s2.getAverage());
				}
				return -1;
			}
		});

		set.add(new Student("홍길동", 1, 1, 100, 100, 100));
		set.add(new Student("김자바", 1, 2, 90, 70, 80));
		set.add(new Student("이자바", 1, 3, 80, 80, 90));
		set.add(new Student("안자바", 1, 4, 70, 90, 70));
		set.add(new Student("이순신", 1, 5, 60, 100, 50));
		set.add(new Student("안자바", 1, 4, 70, 90, 20));
		set.add(new Student("이순신", 1, 5, 60, 100, 10));

		Iterator i = set.iterator();

		while (i.hasNext()) {
			System.out.println(i.next());
		}
		System.out.println();
	}

}

class Student {
	String name;
	int ban;
	int num;
	int kor;
	int eng;
	int math;

	public Student(String name, int ban, int num, int kor, int eng, int math) {
		super();
		this.name = name;
		this.ban = ban;
		this.num = num;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	int getTotal() {
		return kor + eng + math;
	}

	float getAverage() {
		return (int) ((getTotal() / 3.0f) * 10 + 0.5) / 10.0f;
	}

	public String toString() {
		return name + "," + ban + "," + num + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
	}

}