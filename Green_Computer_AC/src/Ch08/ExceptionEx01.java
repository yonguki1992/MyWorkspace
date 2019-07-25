package Ch08;

public class ExceptionEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 10;
		int result = 0;
		try {
//			for(int i = 0; i < 10; ++i) {
//				System.out.println("예외 전");
//				result += num/(int)(Math.random()*10);
//				System.out.println("예외 후");
//			}
			throw new ArithmeticException("그냥 해봄");
		} catch (ArithmeticException ae) {
			// TODO: handle exception
			System.out.println("0으로 나눌 수 없습니다.");
			System.out.println(ae.getMessage());
		} finally {
			System.out.println("꼭 실행해야하는 기능, 파일 닫기, db닫기, 접속 끊기, 자동 저장 등");
			System.out.println(result);
		}
		
	}

}
