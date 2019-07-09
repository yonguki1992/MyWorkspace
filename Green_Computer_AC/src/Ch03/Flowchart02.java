package Ch03;

import static java.lang.System.out;

public class Flowchart02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int h = 0, sw = 0;
		
		for(int n = 1 ; n < 7; ++n) {
			if(sw == 0) {
				h += n*n;
				sw = 1;
				continue;
			}
			sw = 0;
		}
		out.println(h);
	}

}
