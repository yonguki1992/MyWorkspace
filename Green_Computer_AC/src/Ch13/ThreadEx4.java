package Ch13;

public class ThreadEx4 {
	
	static long startTime = System.currentTimeMillis();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		for(int i=0; i < 300; ++i) {
			System.out.printf("%s", new String("-"));
		}
		System.out.println("\n소요 시간1 : "+(System.currentTimeMillis() - startTime));
		
		for(int i=0; i < 300; ++i) {
			System.out.printf("%s", new String("|"));
		}
		System.out.println("\n"
				+ "소요 시간2 : "+(System.currentTimeMillis() - startTime));
	}

}
