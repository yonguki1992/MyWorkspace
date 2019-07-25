package Ch04;

public class FlowEx21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 5; i > 0; --i) {
			for(int j = 5; j > 0; --j) {
				if(i+j == 6) {
					System.out.printf("[%2d,%2d] ",j,i);
				} else {
					System.out.print("        ");
				}
			}
			System.out.println();
		}
	}

}
