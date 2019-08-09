package Ch03;

import static java.lang.System.*;

public class OperatorEx23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch = "abcde".charAt(4);
		String str1 = "abc";
		String str2 = new String("abc");
		
		out.printf("\"abc\"==\"abc\" ? %b\n", "abc"=="abc");
		out.printf(" str1 == \"abc\" ? %b\n", str1=="abc");
		out.printf(" str2 == \"abc\" ? %b\n", str2=="abc");
		out.printf("str1.equals(\"abc\") ? %b\n", str1.equals("abc"));
		out.printf("\"abc\".equals(str2) ? %b\n", "abc".equals(str2.toString()));
		out.printf("\"ABC\".equals(str2) ? %b\n", "ABC".equals(str2.toString()));
		out.printf("\"abc\".equalsIgnoreCase(str2) ? %b\n", "ABC".equalsIgnoreCase(str2.toString()));
	}

}
