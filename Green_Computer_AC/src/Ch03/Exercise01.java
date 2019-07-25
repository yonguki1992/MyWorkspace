package Ch03;

import static java.lang.System.*;

public class Exercise01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 20;
		out.append(Integer.toString(a+b) + "\n")
		.append(Integer.toString(a-b) + "\n")
		.append(Integer.toString(a*b) + "\n")
		.append(Integer.toString(a%b) + "\n")
		.append(Integer.toString(a>>2) + "\n")
		.append(Integer.toString(a<<3) + "\n")
		.append(Integer.toString((a>b)?a:b) + "\n")
		.println(a/b);
		
		out.flush();
	}
// 
}
