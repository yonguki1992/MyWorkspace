package Ch14;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strArr = {"aaa", "bbb", "ccc"};
		List<String> strList = Arrays.asList(strArr);
		
		Stream<String> strStream1 = strList.stream();
		Stream<String> strStream2 = Arrays.stream(strArr);
		
		strStream1.sorted().forEach(i -> System.out.print(i + ", "));
		System.out.println();
		strStream2.sorted().forEach(i -> System.out.print(i + ", "));
		System.out.println();		
		
		Arrays.sort(strArr);
		Collections.sort(strList);
		
		for(String str : strArr) System.out.print(str + ", ");
		System.out.println();
		for(String str : strList) System.out.print(str + ", ");
	}

}
