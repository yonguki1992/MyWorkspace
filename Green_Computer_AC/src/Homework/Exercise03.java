package Homework;
import java.util.Scanner;
import static java.lang.System.*;

public class Exercise03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(in);
		char ch = scan.nextLine().charAt(0);
		char b = 'A'<=ch&&ch<='Z' ? (char)(ch + 32) : ch;
		
		out.println(b);
		scan.close();
	}

}
