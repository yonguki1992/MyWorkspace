package Ch14;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface TriFunction<T, U, V, R> {
	R apply(T t, U u, V v);
}


public class LamdaEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Predicate<String> isEmptyStr = str -> str.length() == 0;
		
		String s = "null";
		
		if(isEmptyStr.test(s)) {
			System.out.println("빈 문자열");
		} else {
			System.out.println(s);
		}
		
		
		Supplier<String> getStr = () -> s;
		System.out.println(getStr.get());
		
		BiFunction<String, String, String> func1 = (a , b) -> a + b;
		System.out.println(func1.apply(s, s));		
		
		TriFunction<String, String, String, Integer> func2 = (a, b, c) -> Integer.parseInt(a)+Integer.parseInt(b)+Integer.parseInt(c);
		System.out.println(func2.apply("10", "20", "30"));
		
		BinaryOperator<Integer> func3 = (a, b) -> {
			int result = 1;
			for(int i = 0; i < b; ++i) {
				result *= a;
			}
			return result;
		};
		System.out.println(func3.apply(2, 10));
	}

}
