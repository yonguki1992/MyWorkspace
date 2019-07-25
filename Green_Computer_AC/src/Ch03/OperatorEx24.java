package Ch03;

import static java.lang.System.*;

public class OperatorEx24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0;
		char ch = " ".charAt(0);
	
		x = 15;
		out.println(x + Boolean.toString(10 < x && x < 20));
		
		x = 6;
		out.println(x + Boolean.toString(x%2 == 0 || x%3 == 0 && x%6 != 0));
		out.println(x + Boolean.toString(((x%2 == 0 || x%3 == 0) && x%6 != 0)) );
		
		ch = "1".charAt(0);
		out.println(ch + Boolean.toString('0' <= ch && ch <= '9'));
		
		ch = "a".charAt(0);
		out.println(ch + Boolean.toString('a' <= ch && ch <= 'z'));
		
		ch = 'A';
		out.println(ch + Boolean.toString('A' <= ch && ch <= 'Z'));
		
		ch = 'q';
		out.println(ch + Boolean.toString('q' == ch || ch == 'Q'));
	}

}
