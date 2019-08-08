package Ch11;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSetEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] objArr = {"2", "1", new Integer(1).toString(), "2", "2", "3", "3", "3", "4", "4", "4"};
		
		Set set = new HashSet();
		
		for(int i = 0; i < objArr.length; ++i) {
			set.add(objArr[i]);
		}
		System.out.println(set);
		
		Set iSet = new HashSet();
		for(int i = 0; i < 10; ++i) {
			int num = ((int)(Math.random()*45)+1);
			iSet.add(num);
		}
		
		List list = new LinkedList(iSet);
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Comparable && o2 instanceof Comparable) {
					Comparable c1 = (Comparable)o1;
					Comparable c2 = (Comparable)o2;
					return c2.compareTo(c1) * -1;
				}
				return -1;
			};
		});
		
		Iterator i = list.iterator();
		
		while(i.hasNext()) {
			System.out.print(i.next() + " ");
		}
	}

}
