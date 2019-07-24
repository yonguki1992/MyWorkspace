package Ch03;

import static java.lang.System.*;
import java.util.Scanner;

public class OperatorEx25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(in);
		
		char ch[] = new char[30];
		for(int i = 0; i < ch.length; i++) {
			ch[i] = (char)(i + 32);
		}

		out.println("문자를 하나 입력하세요. >");
		
		char tmpCh = scan.nextLine().charAt(0);
		
		if(ch[16] <= tmpCh && tmpCh <= ch[25]) {
			out.println("숫자");
		} else {
			out.println("숫자 아님");
		}
		
	}

}
