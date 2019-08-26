package Ch11;

import java.util.Iterator;
import java.util.ArrayList;

public class ListEx2 {
	public static void main(String[] args) {
		// 객체 생성시 크기를 지정하면 메모리 확보에 드는 시간을 절약함
		ArrayList<String> v = new ArrayList<>(10);

		printArrayList(v);

		for (int i = 0; i < 15; ++i)
			v.add("숫자 " + (int) (Math.random() * 10)); // 용량이 10을 넘겼지만 자동으로 늘어남.
		printArrayList(v);

		// 데이터 삽입
		v.add(0, "ABC");
		printArrayList(v);

		//v.insertElementAt("bbb", 2); // 구버전
		printArrayList(v);

		// 수정
		v.set(0, v.get(0).toLowerCase());
		printArrayList(v);

		//v.setElementAt(v.get(2).toUpperCase(), 2); // 구버전
		printArrayList(v);

		// 삭제
		v.remove(0);
		v.remove(0);
		v.remove(0);
		v.remove(0); // 용량을 줄이려면 setSize() 사용할 것
		printArrayList(v);

		//v.setSize(15);
		printArrayList(v);
		
		/**
		 * Vector는 옛 버전에서 지원하는 컬렉션으로 멀티스레드에서 안전하게 설계?
		 * ArrayList는 Vector의 신버전으로 단일 스레드에서만 안전하게 설계?
		 * ArrayList를 멀티스레드에서 사용하려면 Collections.synchronizedCollection(리스트);
		 * 동기화 해주면 된다.
		 */
		
		//v.setSize(13);

		// 조회
		for (int i = 0; i < v.size(); ++i)
			System.out.print(i == 0 ? v.get(i) : " " + v.get(i));
		System.out.println();

		for (String arr : v)
			System.out.print(arr + " ");
		System.out.println();

		//신버전 - 구버전보다 조회속도 살짝 빠름(거의 차이 안남)
		Iterator<String> it = v.iterator();
		while (it.hasNext())
			System.out.print(it.next()+" ");
		System.out.println();

		//구버전
//		Enumeration<String> em = v.elements();
//		while (em.hasMoreElements()) {
//			String string = (String) em.nextElement();
//			System.out.print(string+" ");
//		}
//		System.out.println();
		
	}

	private static void printArrayList(ArrayList<String> v) {
//		System.out.println("용량 : " + v.capacity() + ", 길이 : " + v.size());
		System.out.println(", 길이 : " + v.size());
		System.out.println("내용 : " + v);
	}
}
