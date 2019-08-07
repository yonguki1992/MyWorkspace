package Ch11;

import java.util.*;

public class PropertiesEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		
		prop.setProperty("timeout", "30");
		prop.setProperty("language", "kr");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		//열거형
		Enumeration e = prop.propertyNames();
		while(e.hasMoreElements()) {
			String element = (String)e.nextElement();
			System.out.println(element + "=" + prop.getProperty(element));
//			arr.add(element.hashCode());
			arr.add(prop.getProperty(element).hashCode());
		}
		
		System.out.println();
		
		prop.setProperty("size", "20");
		System.out.println("size = " + prop.getProperty("size"));
		System.out.println("capcity = " + prop.getProperty("capacity", "20"));
		System.out.println("loadfactor = " + prop.getProperty("loadfactor", "0.75"));
		
		System.out.println(prop);
		prop.list(System.out);


		//properties는 value.hashCode() 값으로 정렬함.
		System.out.println("\n정렬 전 해시코드값");
		for(Integer a : arr) {
			System.out.println(a);
		}
		System.out.println();
		
		System.out.println("정렬 후 해시코드값");
		Collections.sort(arr);
		
		for(Integer a : arr) {
			System.out.println(a);
		}

	}

}
