package Ch03;

import static java.lang.System.*;
import static java.lang.Math.*;

public class OperatorEx18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double pi = 3.141592;
		
		double shortPi = round(pi * 1000) / 1000.0;
//		double shortPi = (int)(pi * 1000 + 0.5) / 1000.0;
		out.println(shortPi);
		out.println((int)(random()*100));
		out.println(random()*100);
	}

}
