package Ch15;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
//내가 만든 클래스도 Set에 저장 가능?

import Ch11.HanjaVo;

public class SetEx02 {
	public static void main(String[] args) {
		
		/*
		 * 사용자가 만든 클래스를 해쉬셋(정렬을 지원하는 셋)에 넣을 수 있을 까?
		 * HashSet에 사용자 클래스를 저장하려면 
		 * 반드시 정렬 기준을 정하는 인터페이스를 구현해 줘야 함.
		 */
		Set<HanjaVo> set = new HashSet<>();
		
		set.add(new HanjaVo("1","天","천","하늘 천"));
		set.add(new HanjaVo("1","天","천","하늘 천"));
		set.add(new HanjaVo("1","天","천","하늘 천"));
		set.add(new HanjaVo("1","天","천","하늘 천"));
		set.add(new HanjaVo("1","天","천","하늘 천"));
		
		System.out.println(set.size()+"개");
		
		
		/*
		 * 사용자가 만든 클래스를 트리셋(정렬을 지원하는 셋)에 넣을 수 있을 까?
		 * TreeSet에 사용자 클래스를 저장하려면 
		 * 반드시 정렬 기준을 정하는 인터페이스를 구현해 줘야 함.
		 */
		Set<HanjaVo> treeset = new TreeSet<>();
		treeset.add(new HanjaVo("1","天","천","하늘 천"));
		treeset.add(new HanjaVo("3","天","천","하늘 천"));
		treeset.add(new HanjaVo("2","天","천","하늘 천"));
		treeset.add(new HanjaVo("1","天","천","하늘 천"));
		treeset.add(new HanjaVo("1","天","천","하늘 천"));
		
		System.out.println(treeset.size()+"개");
		System.out.println(treeset);
	}
}
