package Ch14;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strArr1 = {"dd","aaa", "CC", "bbb", "ccc"};
		int[] intArr1 = {1, 3, 2, 8};
		
		Stream<String> strStream = Stream.of(strArr1);
		IntStream stream2 = IntStream.of(1,3,2,8);
		
		int sum = strStream.parallel().mapToInt(s -> s.length()).sum();
		
		Stream<String> strStream1 = Stream.of("A","B", "C");
		Stream<String> strStream2 = Stream.of(new String[] {"a","b","c"});
		Stream<String> strStream3 = Arrays.stream(new String[] {"a","b","c"});
		// 0~2 까지의 요소를 스트림으로 만들기(3은 제외)
		Stream<String> strStream4 = Arrays.stream(new String[] {"a","b","c"},0,3);
		
		IntStream intStream1 = IntStream.range(1, 5);	// 5가 포함 안 됨(1~4)
		IntStream intStream2 = IntStream.rangeClosed(1, 5);	// 5가 포함 됨(1~5)
		IntStream intStream3 = new Random().ints(0, 100);
		//스트림 중간 연산(limit() 등등) - 스트림에 대해 각각의 연산을 시작함
		//스트림 최종 연산 처리 단계(forEach(Consumer) 등등) - 중간 연산 단계의 결과물을 종합하여 최종 결과 도출
		// sequential() 순차 처리 스트림(기본)
		// parallel() - 병렬 처리 스트림 
		// 위 두 처리방법은 중간 연산에 명시하여 사용함
		// ex)intStream3.parallel().limit(5).forEach(i -> System.out.print(i + ", "));
		intStream3.limit(5).forEach(i -> System.out.print(i + ", "));
		
		LongStream longStream1 = LongStream.range(1, 5);	// 5가 포함 안 됨
		LongStream longStream2 = LongStream.rangeClosed(1, 5);	// 5가 포함 됨
		
		System.out.println();
		DoubleStream doubleStream1 = new Random().doubles(1.0 , 10.0);
		doubleStream1.limit(1).forEach(i -> System.out.print(i + ", "));
		
		System.out.println();
		Stream<Integer> evenStream = Stream.iterate(0, n -> n-2);
		evenStream.limit(4).forEach(i -> System.out.print(i + ", "));
		
		System.out.println();
		Stream<Double> randomStream = Stream.generate(Math::random);
		randomStream.limit(7).forEach(i -> System.out.print(i + ", "));
		

	}
	
}
