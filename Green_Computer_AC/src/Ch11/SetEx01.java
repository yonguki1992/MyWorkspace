package Ch11;

import java.util.HashSet;
import java.util.Set;

public class SetEx01 {

	public static void main(String[] args) {
		// jdk 1.5 부터 <타입명> 사용
		Set<Integer> set1 = new HashSet<Integer>();	//1.5 까지
		Set<Integer> set2 = new HashSet<>(); // 1.6부터
	}

}
