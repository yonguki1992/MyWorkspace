package Ch14;

import java.util.*;
import static java.lang.System.*;

public class OptionalEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Optional<String> optStr = Optional.of("abcde");
		Optional<Integer> optInt = optStr.map(s -> s.length());
		out.println("optStr="+optStr.get());
		out.println("optInt="+optInt.get());
		
		int result1 = Optional.of("123")
						.filter(x -> x.length() > 0)
						.map(s -> Integer.parseInt(s))
						.get();
		int result2 = Optional.of("")
				.filter(x -> x.length() > 0)
				.map(s -> Integer.parseInt(s))
				.orElse(-1);
		
		out.println("result1="+result1);
		out.println("result2="+result2);
		
		Optional.of("456").map(s -> Integer.parseInt(s))
						.ifPresent(x -> out.printf("result3=%d\n", x));
		
		OptionalInt optInt1 = OptionalInt.of(0);
		OptionalInt optInt2 = OptionalInt.empty();
		
		out.println(optInt1.isPresent());
		out.println(optInt2.isPresent());
		
		out.println(optInt1.getAsInt());
		//out.println(optInt2.getAsInt());	//NoSuchElementException 발생
		out.println("optInt1="+optInt1);
		out.println("optInt2="+optInt2);
		out.println("optInt1.equals(optInt2)?"+optInt1.equals(optInt2));
		
		Optional<String> opt1 = Optional.ofNullable(null);
		Optional<String> opt2 = Optional.empty();
		
		out.println("opt1="+opt1);
		out.println("opt2="+opt2);
		out.println("opt1.equals(opt2)?"+opt1.equals(opt2));
		
		int result3 = optStrToInt(Optional.of("123"), 0);
		int result4 = optStrToInt(Optional.of(""), 0);
		
		out.println("result3="+result3);
		out.println("result4="+result4);
	}
	
	static int optStrToInt(Optional<String> optStr, int defaultValue) {
		try {
			return optStr.map(s -> Integer.parseInt(s)).get();
		}catch (Exception e) {
			return defaultValue;
		}
	}
}
