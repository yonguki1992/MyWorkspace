package Ch14;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LamdaEx7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
		Function<Integer, String> g = (i) -> Integer.toBinaryString(i);
		
		Function<String, String> h = f.andThen(g);
		Function<Integer, Integer> h2 = f.compose(g);
		
		System.out.println(h.apply("FF"));	// "FF" -> 255 -> 11111111
		System.out.println(h2.apply(2));	// 2 -> "10" -> 16
		
		Function<String, String> f2 = x -> x;
		System.out.println(f2.apply("AAA"));
		
		Predicate<Integer> p = i -> i <100;
		Predicate<Integer> q = i -> i< 200;
		Predicate<Integer> r = i -> i%2 == 0;
		Predicate<Integer> notP = p.negate();
		
		Predicate<Integer> all = notP.and(q.or(r));
		System.out.println(all.test(150));
		
		String str1 = "abc";
		String str2 = "abc";
		
		Predicate<String> p2 = Predicate.isEqual(str1);
		boolean res = p2.test(str2);
		System.out.println(res);
		
	    NewClass obj = new NewClass();
		Function<String, Boolean> tmp1 = (x) -> obj.equals(x);
		Function<String, Boolean> tmp2 = obj::equals;
		Function<String, Boolean> tmp3 = new NewClass()::equals;
		
		Supplier<NewClass> s5 = () -> new NewClass();
		Supplier<NewClass> s6 = NewClass::new;
		
		Function<Integer, NewClass> tmp4 = (i) -> new NewClass(i);
		Function<Integer, NewClass> tmp5 = NewClass::new;
		
		BiFunction<Integer, Integer, NewClass> tmp6 = (i, j) -> new NewClass(i, j);
		BiFunction<Integer, Integer, NewClass> tmp7 = NewClass::new;
		
		Function<Integer, int[]> tmp8 = int[]::new;
	}

}


class NewClass<T> {
	public NewClass() {
		System.out.println(0);
	}
	public NewClass(T i) {
		// TODO Auto-generated constructor stub
		System.out.println(i);
	}
	public NewClass(T i, T j) {
		// TODO Auto-generated constructor stub
		System.out.println(i.toString()+j.toString());
	}
}