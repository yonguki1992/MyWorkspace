package Ch14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LamdaEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < 10; ++i) 
			list.add(i);
		//list의 요소 출력
		list.forEach(i -> System.out.print(i==0 ? i : ","+i));
		System.out.println();
		
		list.removeIf(x -> x%2==0 || x%3==0);
		System.out.println(list);
		
		list.replaceAll(i -> i*10);
		System.out.println(list);
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		
		map.forEach((k, v) -> System.out.print("{"+k+","+v+"}"));
	}

}
