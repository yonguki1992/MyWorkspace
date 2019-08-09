package Ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data = { "A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D" };

		// HashMap<Key, Value>
		TreeMap map = new TreeMap();

		for (int i = 0; i < data.length; ++i) {
			if (map.containsKey(data[i])) {
				Integer value = (Integer) map.get(data[i]);
				map.put(data[i], new Integer(value.intValue() + 1));
			} else {
				map.put(data[i], new Integer(1));
			}
		}
		System.out.println("====기본정렬====");
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			System.out.println(
					e.getKey() + " : " + printSharp('#', ((Integer) e.getValue()).intValue()) + " " + e.getValue());
		}

		System.out.println();

		// TreeMap을 ArrayList로 변환한 후 Collections.sort로 정렬

		ArrayList treeMapList = new ArrayList(set);

		Collections.sort(treeMapList, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				if(o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
					Map.Entry e1 = (Map.Entry)o1;
					Map.Entry e2 = (Map.Entry)o2;
					//return compare(e1.getKey(),e2.getKey())*-1;	// 키값에 대해 정렬
					return ((Integer)e2.getValue()-(Integer)e1.getValue());	// 밸류값에 대해 정렬
				}
				
				return -1;
			}
		});

		System.out.println("====오름차순정렬====");
		Iterator it2 = treeMapList.iterator();
		while (it2.hasNext()) {
			Map.Entry e = (Map.Entry) it2.next();
			System.out.println(
					e.getKey() + " : " + printSharp('#', ((Integer) e.getValue()).intValue()) + " " + e.getValue());
		}
	}

	static String printSharp(char c, int value) {
		char[] arr = new char[value];
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = c;
		}
		return new String(arr);
	}
}
