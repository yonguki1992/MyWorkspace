package Ch11;

import java.util.ArrayList;

public class ArrayListEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list1 = new ArrayList(3);
		ArrayList list0 = new ArrayList(10);
		
		list1.add(1);
		list1.add(3);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		list1.add(6);
		
		for(int i = 0; i < list1.size(); ++i) {
			System.out.print( i==0 ? list1.get(i) : ", " + list1.get(i)  );
		}
		
		System.out.println();
		list1.remove(0);
		for(int i = 0; i < list1.size(); ++i) {
			System.out.print( i==0 ? list1.get(i) : ", " + list1.get(i) );
		}

		list1.add(2, 10);
		list0.addAll(list1);
		
		System.out.println();
		
		for(int i = 0; i < list0.size(); ++i) {
			System.out.print( i==0 ? list0.get(i) : ", " + list0.get(i) );
		}
		
		ArrayList list2 = new ArrayList();
		
		if(list2.addAll(list0)) {
			System.out.println("\n복사 성공");
		}
		
		for(int i = 0; i < list2.size(); ++i) {
			System.out.print( i==0 ? list2.get(i) : ", " + list2.get(i) );
		}
		
		ArrayList list3 = new ArrayList();
		list3.add(1);
		list3.add(1);
		list3.add(1);
		if(list3.addAll(3, list0)) {
			System.out.println("\n복사 성공");
		}
		
		for(int i = 0; i < list3.size(); ++i) {
			System.out.print( i==0 ? list3.get(i) : ", " + list3.get(i) );
		}
		
		ArrayList list4 = new ArrayList();
		list4.addAll(list3);
		
		if(list4.contains(7)) {
			System.out.println("\nlist3를 포함함");
		}

		if(list4.retainAll(list2)) {
			System.out.println("\nlist1과 공통만 남김");
		} else {
			System.out.println("\nlist1과 공통된게 없음");
		}
		for(int i = 0; i < list4.size(); ++i) {
			System.out.print( i==0 ? list4.get(i) : ", " + list4.get(i) );
		}		
	}

}
