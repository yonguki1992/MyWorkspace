package Ch14;

import java.util.Optional;
import static java.lang.System.*;

public class OptionalEx1 {

	public static void main(String[] args) {
		String str = "ABC";
		//optional 생성
		Optional<String> optVal1 = Optional.of(str);
		Optional<String> optVal2 = Optional.of("ABC");
		Optional<String> optVal3 = Optional.ofNullable(new String("ABC"));
		//Optional<String> optVal4 = Optional.of(null);
		Optional<String> optVal5 = Optional.ofNullable(null);
		
		//optional 초기화하기
		Optional<String> optVal6 = null;	//nullpointexception 위험 여전
		Optional<String> optVal7 = Optional.empty();
		
		//optional 사용
		out.println(optVal2.orElse("null"));
		out.println(optVal5.orElse("null"));
		out.println(optVal6.orElseThrow(NullPointerException::new));
		//out.println(optVal6.orElseThrow(() -> new NullPointerException()));
		out.println(optVal7.orElseGet(String::new));
		//out.println(optVal7.orElseGet(() -> new String("")));
	}

}
