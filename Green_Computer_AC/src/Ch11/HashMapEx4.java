package Ch11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapEx4 {

	public static void main(String[] args) {
		String[] data = {"A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D"};
		
		//HashMap<Key, Value>
		HashMap map = new HashMap();
		
		for(int i = 0; i < data.length; ++i) {
			if(map.containsKey(data[i])) {
				Integer value = (Integer)map.get(data[i]);
				map.put(data[i], new Integer(value.intValue() + 1));
			} else {
				map.put(data[i], new Integer(1));
			}
		}
		
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			System.out.println(e.getKey() + " : "+printSharp('#', ((Integer)e.getValue()).intValue())+" "+e.getValue() );
		}
	}
	static String printSharp(char c, int value) {
		char[] arr = new char[value];
		for(int i = 0; i < arr.length; ++i) {
			arr[i] = c;
		}
		return new String(arr);
	}
}
