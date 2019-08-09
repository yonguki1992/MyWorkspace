package Ch09;

public class ObjectEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Circle c1 = new Circle(new Point(1,1), 2.0);
//		Circle c2 = c1.clone();
//		Circle c3 = c1.deepClone();
//		
//		System.out.println("c1="+c1);
//		System.out.println("c2="+c2);
//		System.out.println("c3="+c3);
//		
//		c1.p.x = 100;
//		c1.p.y = 100;
//
//		System.out.println("c1="+c1);
//		System.out.println("c2="+c2);
//		System.out.println("c3="+c3);
//
//		c1.p.x = 0;
//		c1.p.y = 0;
//
//		System.out.println("c1="+c1);
//		System.out.println("c2="+c2);
//		System.out.println("c3="+c3);
		//문제 1) String name = "kim, lee, park, choi, jung, song" 을 배열의 각 요소에 담기
		//문제 2) 801212-3041234 에서 3을 1로 바꾸기
		
		String[] name = new String("kim, lee, park, choi, jung, song").split(", ");
		for(String names : name) {
			System.out.println(names);
		}
		String id = new String("801212-3041234");
		System.out.println(id);		
		System.out.println(id.replaceAll("3", "1"));
		
		StringBuffer sb = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		System.out.println("sb == sb2 "+(sb==sb2));
		System.out.println("sb == sb2 "+(sb.equals(sb2)));	//equals 가 Object의 메서드임, 객체 내용이 아니라 객체로 비교함 즉 ==과 같음
		String s = sb.toString();
		String s2 = sb2.toString();
		System.out.println("s == s2 "+(s ==s2));
		System.out.println("s == s2 "+(s.equals(s2)));
		StringBuffer sbappend = sb.append("defg");
		System.out.println(sbappend.capacity());
		System.out.println(sbappend.toString());
		for(int i = sbappend.length()-1; i >= 0 ; --i) {
			System.out.print(sb.charAt(i));
		}
		System.out.println("\n"+sbappend.replace(0, 3, "aaa"));	//0~3 만큼을 aaa로 치환
		System.out.println(sbappend.reverse());	
		System.out.println(sbappend.capacity());
		System.out.println(sbappend.length());
		sbappend.setLength(20);
		System.out.println(sbappend.capacity());
		System.out.println(sbappend.length());
		sbappend.append("abcdefgh");
		System.out.println(sbappend.substring(1,25));
	}

}

class Point {
	int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "("+x+", "+y+")";
	}


	
}

//clone()을 오버라이딩 하려면 cloneable 인터페이스를 구현하고 
//clone()을 오버라이딩 하면서 접근 제어자를 protected -> public으로 바꿔야함.
//interface 를 구현해서 메소드를 오버라이딩 할 때는 반드시 접근 제한자를 public 으로 해야 하기 때문.
class Circle implements Cloneable {
	Point p;
	double r;
	
	public Circle(Point p, double r) {
		// TODO Auto-generated constructor stub
		this.p = p;
		this.r = r;
	}
	
	//공변 반환 타입 이용
	@Override
	public Circle clone() {		//얕은 복사
		// TODO Auto-generated method stub
		Object obj = null;
		
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO: handle exception
			
		}
		return (Circle)obj;	
	}
	
	public Circle deepClone() {		//깊은 복사
		// TODO Auto-generated method stub
		Object obj = null;
		
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO: handle exception
			
		}
		//얕은 복사와의 차별점
		Circle c = (Circle)obj;
		c.p = new Point(this.p.x, this.p.y);
		return c;	
	}	
	
	@Override
	public String toString() {
		return "[p="+p+", r="+r+"]";
	}

}
