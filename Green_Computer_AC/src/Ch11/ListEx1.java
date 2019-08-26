package Ch11;

import java.util.ArrayList;
import java.util.Random;

public class ListEx1 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Random rnd = new Random();

		for (int i = 0; i < 20; ++i)
			list.add(rnd.nextInt(101));
		System.out.println("list : " + list);

		// 리스트에서 반복문을 이용하여 삭제할 때는 주의해야함
		// 삭제하면 idx 값이 바뀌므로 뒤에서부터 작업을 하는게 좋다.

		// 잘못된 소스 : 반복문에서 반복횟수와 관련된 변수는 수정하지 않는 것이 좋다.
		// 이유 : 오류 찾기 힘들 수 있음.
//		for (int i = 0; i < list.size(); ++i)
//			if (list.get(i) >= 50)
//				list.remove(i--);
		
		int i = 0;
		while(i < list.size()) {
			if(list.get(i) >= 50) {
				list.remove(i);
				continue;
			}
			++i;
		}
		
//		for (int i = list.size() - 1; i >= 0; --i)
//			if (list.get(i) >= 50)
//				list.remove(i);

		System.out.println("list : " + list);
	}

}
