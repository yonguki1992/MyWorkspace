package Ch11;
/*
 * Stack : Last In First Out - 나중에 들어온 데이터를 먼저 처리(메서드 호출 스택 등)
 */

import java.util.LinkedList;

public class StackEx2 {

	public static void main(String[] args) {
		LinkedList<Integer> stack = new LinkedList<>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		//맨 윗 데이터 맛보기
		System.out.println(stack.peek());
		System.out.println("스택 사이즈 : "+stack.size());
		//맨 윗 데이터 꺼내기
		System.out.println(stack.pop());
		System.out.println("스택 사이즈 : "+stack.size());
		
		while(!stack.isEmpty())
			System.out.println(stack.pop());
	}

}
