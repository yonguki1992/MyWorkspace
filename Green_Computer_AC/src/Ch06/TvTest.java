package Ch06;

class Tv {
	static int Num;
	int tvNum;
	String color;
	boolean power;
	int channel;
	public Tv() {
		// TODO Auto-generated constructor stub
		tvNum = ++Num;
	}
	void power() { this.power = !this.power; }
	int channelUp() { return ++this.channel; }
	int channelDown() { return --this.channel; }
}

public class TvTest{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tv t1 = new Tv();
		t1.channel = 8;
		t1.color = "RED";
		
		System.out.println(t1.tvNum +"번 tv의 색상 " + t1.color);
		System.out.println("현재 채널은 " + t1.channel);
		System.out.println(t1.power);
		t1.power();
		System.out.println("현재 채널은 " + t1.channelUp());
		
		Tv t2 = new Tv();
		t2.channel = 9;
		t2.color = "Blue";
		
		System.out.println(t2.tvNum +"번 tv의 색상 " + t2.color);
		System.out.println("현재 채널은 " + t2.channel);
		System.out.println(t2.power);
		t2.power();
		System.out.println("현재 채널은 " + t2.channelUp());
				
		
	}
}