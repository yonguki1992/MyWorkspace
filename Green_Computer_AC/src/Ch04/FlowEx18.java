package Ch04;

public class FlowEx18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 2; i <= 9; ++i) {
			System.out.print(i + "´Ü :");
			for(int j = 1; j <= 9; ++j) {
				System.out.printf("%2dX%2d=%3d ", i, j, j*i );
			}
			System.out.println();
		}
	}

}
