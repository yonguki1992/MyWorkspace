package Ch06;

import static java.lang.System.*;

public class CardTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out.println("Card.width = " + Card.width);
		out.println("Card.height = " + Card.height);
		
		Card c1 = new Card();
		c1.kind = "Heart";
		c1.num = 7;
		
		Card c2 = new Card();
		c2.kind = "Spade";
		c2.num = 4;
		
		out.println("c1은 " + c1.kind +", " + c1.num + "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
		out.println("c2는 " + c2.kind +", " + c2.num + "이며, 크기는 (" + c2.width + ", " + c2.height + ")");
		
		out.println("c1의 크기를 50, 80 으로 변경합니다.");
		c1.width = 50;
		c1.height = 80;
		
		out.println("c1은 " + c1.kind +", " + c1.num + "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
		out.println("c2는 " + c2.kind +", " + c2.num + "이며, 크기는 (" + c2.width + ", " + c2.height + ")");
	}

}

class Card {
	String kind;
	int num;
	static int width = 100;
	static int height = 250;
}