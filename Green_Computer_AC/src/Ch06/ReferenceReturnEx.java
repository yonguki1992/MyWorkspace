package Ch06;

public class ReferenceReturnEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data d = new Data();
		d.x = 20;
		d.y = 10;
		Data d2 = copy(d);
		
		System.out.println("d.x = " + d.x + ", d.y = " + d.y + " " + d.toString());
		System.out.println("d.x = " + d2.x + ", d.y = " + d2.y + " " + d2.toString());
	}
	
	static Data copy(Data d) {
		Data tmp = new Data();
		tmp.x = d.x * d.y;
		tmp.y = d.x;
		return tmp;
	}
}

class Data {
	int x;
	int y;
	
	public String toString() {
		return "나는 d입니다.";
	}
}