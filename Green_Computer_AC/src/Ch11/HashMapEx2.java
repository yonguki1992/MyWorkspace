package Ch11;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx2 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("김자바", new Integer(90));
		map.put("김자바", new Integer(70));
		map.put("박자바", new Integer(70));
		map.put("강자바", new Integer(80));
		map.put("안자바", new Integer(50));
		
		Set set = map.entrySet();
		Iterator i = set.iterator();
		
		while(i.hasNext()) {
			//Map.Entry<K, V> e1 = (Map.Entry<K, V>)i.next();
			Map.Entry e = (Map.Entry)i.next();	//Map.Entry 타입으로 형변환, HashMap의 내부 클래스인 Entry
			System.out.println("이름 : "+e.getKey() + ", 점수 : "+e.getValue());
		}
		
		set = map.keySet();	//HashMap에 저장된 모든 Key에 대한 Set 반환
		System.out.println("명단 : "+ set.toString());
		
		Collection values = map.values();
		i = values.iterator();
		
		int total = 0;
		while(i.hasNext()) {
			Integer n = (Integer)i.next();
			total += n;
		}
		System.out.println("점수합계 "+total);
	}
}
