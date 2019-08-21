package Ch14;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.*;
import static java.lang.System.*;

public class StreamEx4 {
	//스트림 요소 거르기 : filter(predicate) - 판별식(predicate)으로 거르기 , distinct() - 중복제거
	//변환 : map() - T -> R 타입. ex) mapToInt, mapToLong 등등
	//조회 : peek()
	//mapToInt : Stream<T> -> IntStream,
	//반대 : IntStream -> mapToObj() -> Stream<T>
	//또는 : IntStream -> boxed() -> Stream<Integer>
	//flatMap() : Stream<T[]> --> Stream<T> 로 변환
	
	public static void main(String[] args) {
		
		IntStream iS1 = IntStream.rangeClosed(1, 10);
		iS1.skip(3)
		   .limit(2)
		   .forEach(i -> out.print(i + ", "));
		//iS.skip(3).forEach(System.out::println);
		
		IntStream iS2 = IntStream.of(1,2,2,2,2,3,3,3,3,4,4,5,5,5,5,6,6,7,8,8,9,9,10,10,13,11);
		out.println();
		//iS2.distinct().forEach(i -> out.print(i + ", "));
		iS2.distinct()
		   .filter(i -> i%2 != 0 && i%3 != 0 )
		   .sorted()
		   .forEach(i -> out.print(i+", "));
		
		Stream<String> strS1 = Stream.of("aA","aa","bb","cC","cc", "b", "dd", "aa");
		out.println();
		strS1.distinct()
			 .sorted(Comparator.reverseOrder())
			 .forEach(i->out.print(i+", "));
		
		Stream<String> strS2 = Stream.of("aA","aa","bb","cC","cc", "b", "dd", "ddd");
		out.println();
		strS2.sorted((a,b)->b.compareTo(a))
			 .limit(1)
			 .forEach(out::print);
		
		out.println();
		new Random().ints(1,46)
					.distinct()
					.limit(6)
					.sorted()
					.forEach(i -> out.print(i+", "));
		IntStream intS = new Random().ints(1,46);
		
		out.println();
		Stream<String> lottoStream = intS.distinct()
										 .limit(6)
										 .sorted()
										 .mapToObj(i->i+"/ ");
		lottoStream.forEach(out::print);
		
		Stream<Student> studentS = Stream.of(new Student("이자바", 3, 300),
											 new Student("한자바", 1, 200),
											 new Student("안자바", 2, 100),
											 new Student("강자바", 3, 340),
											 new Student("박자바", 2, 200),
											 new Student("장자바", 3, 280),
											 new Student("김자바", 1, 180));
		out.println();
//		studentS.sorted(Comparator.<Student, Integer>comparing(s -> s.getBan())
//					.thenComparing(Comparator.naturalOrder()))
//				.forEach(out::println);
		
//		studentS.sorted(Comparator.comparing(Student::getBan)
//				.thenComparing(Comparator.naturalOrder()))
//			.forEach(out::println);
		
//		Stream<Integer> scoreS = studentS.map(s -> s.getTotalScore());
//		IntStream is1 = scoreS.mapToInt(s -> s.intValue());
//		int allTotalScore = is1.sum();
//		out.println(allTotalScore);
		//또는 아래 처럼
		IntStream is2 = studentS.mapToInt(s -> s.getTotalScore());
		//out.println(is2.sum());	//스트림의 최종 연산이라 수행하면 스트림 닫힘.
		
		IntSummaryStatistics stat = is2.summaryStatistics();
		long totalCnt = stat.getCount();
		long totalScore = stat.getSum();
		double avgScore = stat.getAverage();
		long minScore = stat.getMin();
		long maxScore = stat.getMax();
		
		out.printf("[%d, %d, %f, %d, %d]\n", totalCnt, totalScore, avgScore, minScore, maxScore);
		
		out.println();
		IntStream charS = "12345".chars();
		int charSum = charS.map(ch -> ch -'0').sum();
		out.println("12345 의 각 자리 숫자의 합은 = "+charSum);
	}

}

class Student implements Comparable<Student> {
	
	private int totalScore;
	private int ban;
	private String name;

	public Student(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public int getBan() {
		return ban;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
	
	@Override
	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore);
	}
}
