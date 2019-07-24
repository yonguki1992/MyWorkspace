package Ch06;

public class PostboxEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date();
		d.setYear(2019);
		d.setMonth(7);
		d.setDay(12);
		
		SalesStatus[] sa = new SalesStatus[2];
		sa[0] = new SalesStatus();
		sa[0].setDate(d.toString());
		sa[0].setDestination("영등포");
		sa[0].setProduct("견과 세트");
		sa[0].setQuantity(25);
		sa[0].setUnit(16000);
		
		sa[1] = new SalesStatus();
		sa[1].setDate(d.toString());
		sa[1].setDestination("송파구");
		sa[1].setProduct("버섯 세트");
		sa[1].setQuantity(10);
		sa[1].setUnit(8000);
		
		System.out.println("날짜( 년 월 일 )   배송지     물품      수량       단가             금액               세금              판매금액");
		System.out.println("================================================================");
		for(SalesStatus s : sa) {
			System.out.println(s.toString());
		}
		
		
	}

}

class SalesStatus {
	private String date;
	private String destination;
	private String product;
	private int quantity;
	private int unit;


	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return this.date;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDestination() {
		return this.destination;
	}
	
	public void setProduct(String product) {
		this.product = product;
	}
	public String getProduct() {
		return this.product;
	}
	
	public void setQuantity(int quantity) {
		if(quantity < 0 || quantity > 100) return;
		this.quantity = quantity;
	}
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setUnit(int unit) {
		if(unit < 1000 || unit > 100000) return;
	
		this.unit = unit;
	}
	public int getUnit() {
		return this.unit;
	}
	
	public int getPrice() {
		return this.quantity * this.unit;
	}
	public int getVat() {
		return (int)(getPrice() * 0.1);
	}
	public int getSalePrice() {
		return (int)(getPrice() * 1.1);
	}
	
	//매출현황 출력
	public String toString() {
		return String.format("%s   %s  %s  %3d %6d %9d %8d %9d", date, destination, product, quantity, unit, getPrice(), getVat(), getSalePrice() );
	}
}



class Date {
	private int year;
	private int month;
	private int day;
	
	public int getYear() { return this.year;	}
	public int getMonth() { return this.month;	}
	public int getDay() { return this.day;	}
	
	public void setYear(int year) { 
		if(year < 0 || year > 2999) return;
		this.year = year;
	}
	public void setMonth(int month) { 
		if(month < 0 || month > 12) {
			this.month = 1;
			return;
		}
		this.month = month;
	}
	public void setDay(int day) { 
		if(this.month == 0 ) {
			this.day = 1;
			return;
		}
		if(this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12) {
			if(day < 0 || day > 31) { 
				this.day = 1;
				return;	
			}
		} else if(this.month == 2) { 
			if(day < 0 || day > 28) { 
				this.day = 1;
				return;	
			}
		} else {
			if(day < 0 || day > 30) { 
				this.day = 1;
				return;	
			}
		}
		this.day = day;
	}
	
	//날짜 출력
	public String toString() {
		return year+"년 "+month+"월 "+day+"일";
	}
}






