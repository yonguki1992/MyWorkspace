package Ch11;

import java.util.*;


public class CollectionsEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		System.out.println(list);
		
		Collections.addAll(list, 1,2,3,4,5);
		System.out.println(list);
		
		Collections.rotate(list,2);
		System.out.println(list);
		
		Collections.swap(list, 0, 2);
		System.out.println(list);	
		
		Collections.shuffle(list);
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		
		int index = Collections.binarySearch(list, 3);
		System.out.println("index of 3 = "+index);
		
		System.out.println("max = "+Collections.max(list));
		System.out.println("min = "+Collections.min(list));
		System.out.println("min = "+Collections.max(list, Collections.reverseOrder()));
		
		Collections.fill(list, 9);
		System.out.println("list = "+list);
		
		List newList = Collections.nCopies(list.size(), 2);
		System.out.println("newlist = "+newList);
		System.out.println(Collections.disjoint(list, newList));

		Collections.copy(list, newList);
		System.out.println("newlist = "+newList);
		System.out.println("list = "+list);
		
		Collections.replaceAll(list,2,1);
		System.out.println(list);
		
		Enumeration e = Collections.enumeration(list);
		ArrayList list2 = Collections.list(e);
		
		System.out.println("list2 = "+list2);
	
	}
	

}
