package Ch03;

public class Flowchart01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		
		for(int i = 0; i < 99; ++i) {
			if(i%2 == 1) {
				sum += i*i;
			}
		}
		System.out.println(sum);
	}

}
