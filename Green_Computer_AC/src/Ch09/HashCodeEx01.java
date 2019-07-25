package Ch09;

public class HashCodeEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.hashCode());	// 객체의 내용을 해쉬코드로 생성
		System.out.println(str2.hashCode());
		System.out.println(System.identityHashCode(str1));	// 객체의 주소 값을 해쉬코드로 생성
		System.out.println(System.identityHashCode(str2));

		System.out.println(new Object().toString());
		
		String str = new String("KOREA");
		java.util.Date today = new java.util.Date();
		
		System.out.println(str);
		System.out.println(str.toString());
		
		System.out.println(today);
		System.out.println(today.toString());
	}

}
