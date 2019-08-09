package Ch07;

import org.apache.commons.lang3.StringUtils;

class Car {
	
	enum CarName {
		morning("morning", 1),
		spark("spark", 2),
		sonata("sonata", 3);
		
		private String name;
		private int code;
		private CarName(String name, int code) {
			this.name = name;
			this.code = code;
		}
		
		public static CarName findBy(String name) {
			for(CarName carName : CarName.values()) {
				if(StringUtils.equals(carName.name, name)) {
					return carName;
				}
			}
			return null;
		}
		
		@Override
		public String toString() {
			//return String.format("%s[%d:%s]", super.toString(), code, name);
			return String.format("%s", super.toString());
		}
		
		public String getName() { return this.name; }
		
		public int getCode() { return this.code; }
	}	
	
}


class CarInfo extends Car{
	private String name;
	private String color;
	private String gearType;
	private int door;
	private static int count = 0;
		
	{
		count = (count)%3 + 1;
	}
	
	CarInfo(String carName) {
		this(carName ,"white", "auto", 4);
	}
	
	CarInfo(String carName, String color) {
		this(carName, color, "auto", 4);
	}

	CarInfo(String carName, String color, String gearType, int door) {
		super();
		this.name = carName;
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
	
	public String toString() {
		return "차량 종류 : " + this.name + ", 색상 : " + this.color + ", 변속기 종류 : " + this.gearType + ", 문 갯수 : " + Integer.toString(this.door);
	}
	
		
}

public class ExtendsEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarInfo morning = new CarInfo("morning");
		CarInfo spark = new CarInfo("spark", "blue");
		CarInfo sonata = new CarInfo("sonata", "gray", "manual", 5);

		System.out.println(morning.toString());
		System.out.println(spark.toString());
		System.out.println(sonata.toString());
		
		String str = "black";
		if(Car.CarName.findBy(str) == null) {
			System.out.println("그런차는 없습니다.");
		} else {
			CarInfo car = new CarInfo(str);
			System.out.println(car.toString());
		}		

	}

}
