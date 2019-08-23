package Ch11;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapEx1 {

	public static void main(String[] args) {
		/*
		 * 해시테이블과 해시맵의 차이는 
		 * 각각 벡터와 어레이리스트의 차이와 같음
		 */
		//Map<Integer, String> map = new HashTable<>();
		//Map<Integer, String> map = new HashMap<>();
		Map<Integer, String> map = new TreeMap<>();	//정렬 지원(키에 대해)
		
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(4, "D");
		map.put(5, "E");
		map.put(6, "F");
		Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
		Map.Entry<Integer, String> entry = it.next();

		System.out.println(map);

		String data = map.get(4);
		System.out.println(data);

		Set<Integer> keySet = map.keySet();

		for (int key : keySet)
			System.out.println(key + " : " + map.get(key));
		for (String val : map.values()) 
			System.out.println(val);
		
		map.remove(4);
		System.out.println(map);
		
	}

}
