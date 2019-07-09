package Ch04;

public class ForEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, sum = 0;
		for(i = 0; i <= 100; ++i) {
			if(sum + i >= 4000) {
				break;
			}
			sum += i;
		}
		System.out.println(i + " " + sum);
		
		sum = 0;
		for(i = 0; i <= 100; ++i) {
			if(i % 5 == 0) {
				continue;
			}

			System.out.println(i);
		}
	}

}
