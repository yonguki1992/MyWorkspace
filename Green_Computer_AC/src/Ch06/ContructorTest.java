package Ch06;

public class ContructorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardEx c1 = new CardEx();
		System.out.println();
		CardEx c2 = new CardEx("홍길동", 10);
		System.out.println();
		CardEx c3 = new CardEx(true, 12.89);
		System.out.println();
		CardEx c4 = new CardEx(1, 'c', 10L);
	}
	
}

class CardEx {
	CardEx(){
		System.out.println("기본 생성자 호출");
	}
	
	CardEx(String str, int n){
		this();
		System.out.println("두번째 생성자 호출");		
	}
	
	CardEx(boolean b, double d){
		this("김", 1);
		System.out.println("세번째 생성자 호출");
	}

	CardEx(int n, char c, long longNum){
		this(true, 1.0);
		System.out.println("네번째 생성자 호출");
	}
}