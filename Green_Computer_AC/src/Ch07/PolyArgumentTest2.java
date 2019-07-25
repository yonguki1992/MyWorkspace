package Ch07;

import static java.lang.System.out;

import java.util.Vector;

class Product {
	private int price = 1000;
	private int bonusPoint;
	
	Product(int price){
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	
	public String toString() {
		return "애플";
	}

}

class IPad_mini_5th extends Product {
	IPad_mini_5th(){
		super(50);
	}
	
	public String toString() {
		return "아이패드 미니 5세대";
	}
}

class Airpods_1th extends Product{
	Airpods_1th(){
		super(17);
	}
	
	public String toString() {
		return "에어팟 1세대";
	}	
}

class BlackCow {
	private int money;
	private int bonusPoint = 0;
	
//	private Product[] item = new Product[10];
//	private int i = 0;
	private Vector item = new Vector();
	
	
	public BlackCow(int money) {
		this.money = money;
	}
	
//	private boolean isFull() {
//		return (this.i+1) >  item.size();
//	}
//	
//	private boolean isEmpty() {
//		return this.i == 0;
//	}
	
	void summary() {
//		if(isEmpty()) {
//			out.println("아무것도 구입한적 없습니다.");
//			return;
//		}
		if(item.isEmpty()) {
			out.println("아무것도 구입한적 없습니다.");
			return;
		}
		
		int sum = 0;
		String itemList = "";
		
		for(int i = 0; i < item.size(); ++i) {
			if(item.get(i) == null) {
				break;
			}
			Product p = (Product)item.get(i);
			sum += p.getPrice();
			itemList += (i==0) ? p :", " + p;
		}
		
		out.println("구입하신 제풀의 총 금액은 " + sum + "만원입니다.");
		out.println("구입하신 제품은 " + itemList + "입니다.");
	}
	
	BlackCow buy(Product p) {		
//		if(isFull()) {
//			out.println("장바구니가 미어터지려고 합니다. 대국적으로 쇼핑하십시오.");
//			return this;
//		}
		
		if(money < p.getPrice()) {
			out.println("돈이 " + (p.getPrice() - money) + "만원 부족합니다. 대국적으로 쇼핑하십시오.");
			this.checkTheMoney().checkThePoint();
			return this;
		}
		
		money -= p.getPrice();
		bonusPoint += p.getBonusPoint();
		item.add(p);
		
		out.println(p.toString() + "을(를) " + p.getPrice() + "만원에 구입하셨습니다. 포인트가 " + p.getBonusPoint() + "만큼 적립됩니다.");
		return this;
	}
	
	BlackCow refund(Product p) {
		if(item.remove(p)) {
			money += p.getPrice();
			bonusPoint -= p.getBonusPoint();
			out.println(p + "를 반품하셨습니다.");
			return this;
		} else {
			out.println("해당 제품을 구입한 적 없습니다.");
			return this;
		}
	}
	
	BlackCow checkTheMoney() {
		out.println("통장잔고 : " + money + "만원");
		return this;
	}
	
	BlackCow checkThePoint() {
		out.println("포인트 : " + bonusPoint + "점");
		return this;
	}
}

public class PolyArgumentTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IPad_mini_5th ipad = new IPad_mini_5th();
		Airpods_1th airPod = new Airpods_1th();
		
		BlackCow bc = new BlackCow(100);
		bc.buy(ipad);
		bc.buy(airPod);
		bc.checkTheMoney();
		bc.checkThePoint();
		bc.summary();
		
		System.out.println();
		BlackCow bc2 = new BlackCow(240);
		bc2.buy(ipad)
		   .buy(airPod)
		   .buy(airPod)
		   .buy(airPod)
		   .buy(airPod)
		   .buy(airPod)
		   .buy(airPod)
		   .buy(airPod)
		   .buy(airPod)
		   .buy(airPod)
		   .buy(airPod)
		   .refund(ipad)
		   .checkTheMoney()
		   .checkThePoint()
		   .summary();
		
		System.out.println();
		new BlackCow(100)
		   .checkTheMoney()
		   .checkThePoint()
		   .summary();
	}

}
