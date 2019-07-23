package Ch07;

public class CastingTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewCar car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		car = fe;
		
		NewCar car1 = new FireEngine();
		((FireEngine)car).water();
		car.drive();
		car.door = 10;
		
//		FireEngine fe3 = new NewCar();
		fe2 = (FireEngine)car;
		fe2.water();
	}

}
class NewCar {
	String color;
	int door;
	
	void drive() {
		System.out.println("drive, Brrrr~");
	}
	
	void stop() {
		System.out.println("stop!");
	}
}

class FireEngine extends NewCar {
	void water() {
		System.out.println("water!");
	}
}