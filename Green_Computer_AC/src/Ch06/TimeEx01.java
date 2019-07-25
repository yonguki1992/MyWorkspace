package Ch06;

public class TimeEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time t = new Time();
		t.setHour(4);
		t.setMin(50);
		t.setSec(15);
		
		System.out.printf("현재 시각 - %02d : %02d : %02.2f ", t.getHour(), t.getMin(), t.getSec());
	}
	
}


class Time {
	private int hour;
	private int min;
	private float sec;
	
	public int getHour() { return this.hour;	}
	public int getMin() { return this.min;	}
	public float getSec() { return this.sec;	}
	
	public void setHour(int hour) { 
		if(hour < 0 || hour > 23) return;
		this.hour = hour;
	}
	public void setMin(int min) { 
		if(min < 0 || min > 59) return;
		this.min = min;
	}
	public void setSec(float sec) { 
		if(sec < 0f || sec > 59.99f) return;
		this.sec = sec;
	}
	
	
}