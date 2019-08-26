package Ch14;

import java.util.Arrays;
import java.util.stream.*;

public class StreamEx5 {

	public static void main(String[] args) {
		Stream<Integer> dice = IntStream.rangeClosed(1, 6).boxed();
		dice.map(i-> Stream.of(1,2,3,4,5,6)
			.map(i2->new int[] {i,i2}) )
			.forEach(i3 -> i3.forEach(i4 -> System.out.println(Arrays.toString(i4))));

		//map
		Stream<Integer> dice2 = IntStream.rangeClosed(1, 6).boxed();
		Stream<Stream<int[]>> diceStreamStream = dice2.map(i-> Stream.of(1,2,3,4,5,6)
													.map(i2->new int[] {i,i2}));
		
		//flatmap
		System.out.println("flatmap");
		Stream<Integer> dice3 = IntStream.rangeClosed(1, 6).boxed();
		Stream<int[]> diceStream = dice3.flatMap(i-> Stream.of(1,2,3,4,5,6)
										.map(i2->new int[] {i,i2}));
		diceStream.forEach(i -> System.out.println(Arrays.toString(i) ));
		
		
		Stream<Integer> dice4 = IntStream.rangeClosed(1, 6).boxed();
		// 주사위 두개 굴리는 예제
		//dice.flatMap(i->Stream.of(1,2,3,4,5,6).map(i2->new int[] {i,i2}))
		//	 .filter(iArr -> iArr[0]+iArr[1] == 6)
		//	 .forEach(iArr -> System.out.println(Arrays.toString(iArr)));
		
		// 주사위 세개 굴리는 예제
		dice4.flatMap(i->Stream.of(1,2,3,4,5,6).map(i2->new int[] {i,i2}))
			.flatMap(iArr -> Stream.of(1,2,3,4,5,6).map(i3->new int[] {iArr[0],iArr[1], i3}))
			.filter(iArr -> iArr[0]+iArr[1]+iArr[2] == 6)
			.forEach(iArr -> System.out.println(Arrays.toString(iArr)));

	}
	

}
