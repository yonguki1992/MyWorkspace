package Ch03;

import static java.lang.System.*;

public class OperatorEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=5, j=0;
		
		j = i++;
		out.println("j=i++; 하고 난 뒤 , i=" + i + ", j=" + j);
		i=5;
		j=0;
		j=++i;
		out.println("j=++i; 하고 난 뒤 , i=" + i + ", j=" + j);
	}

}
