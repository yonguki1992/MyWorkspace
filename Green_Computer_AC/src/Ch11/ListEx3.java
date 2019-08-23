package Ch11;

import java.util.LinkedList;

public class ListEx3 {

	public static void main(String[] args) {
		
		// 자바에선 queue는 LinkedList를 이용하여 사용.
		LinkedList<Integer> queue = new LinkedList<>();

		queue.addFirst(0);
		queue.addFirst(1);
		queue.addFirst(2);
		queue.addFirst(3);

		queue.addLast(0);
		queue.addLast(1);
		queue.addLast(2);
		queue.addLast(3);
		
		queue.offer(11);
		queue.offer(22);
		queue.offer(33);
		
		System.out.println(queue.size());
		System.out.println("내용 : " + queue);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());

		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		
		System.out.println(queue.pollLast());
		
	}

}
