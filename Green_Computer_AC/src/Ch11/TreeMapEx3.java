package Ch11;

import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		tm.put("apple",10);
		tm.put("f",30);
		tm.put("c",30);
		tm.put("cherry",30);
		tm.put("guess",70);
		tm.put("base",10);
		tm.put("ever",10);
		tm.put("zoo",20);
		tm.put("description",50);
		tm.put("forever",10);
		
		System.out.println("c~f 사이의 단어 검색");
		SortedMap<String, Integer> rangeMap = tm.subMap("c","f");
		for(Map.Entry<String, Integer> dmEntrySet : rangeMap.entrySet()) {
			System.out.println(dmEntrySet.getKey() + " -  "+ dmEntrySet.getValue());
		}
		System.out.println();
		
		NavigableMap<String, Integer> rangeMap2 = tm.subMap("c",true,"f",true);
		for(Map.Entry<String, Integer> dmEntrySet : rangeMap2.entrySet()) {
			System.out.println(dmEntrySet.getKey() + " -  "+ dmEntrySet.getValue());
		}
		
	}

}
