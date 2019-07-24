package Homework;

public class Fourthweek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		example6_01to02();
//		example6_03to04();
//		example6_5();
//		example6_06();
//		example6_07();
//		example6_20();
//		example6_21();
//		example6_22();
//		example6_23();
		example6_24();
	}

	static void example6_01to02() {
		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();

		System.out.println(card1.info());
		System.out.println(card2.info());
	}

	static void example6_03to04() {
		Student s = new Student();
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;

		System.out.println("이름:" + s.name);
		System.out.println("총점:" + s.getTotal());
		System.out.println("평균:" + s.getAverage());
	}

	static void example6_5() {
		Student s = new Student("홍길동", 1, 1, 100, 60, 76);

		System.out.println(s.info());
	}

	// 6-6 (1)
	static void example6_06() {
		System.out.println(getDistance(1, 1, 2, 2));
	}

	// 정답
	static Double getDistance(int x, int y, int x1, int y1) {
		return Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
	}

	// 6-7
	static void example6_07() {
		MyPoint p = new MyPoint(1, 1);
		System.out.println(p.getDistance(2, 2));
	}

	// 6-20
	static void example6_20() {
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(java.util.Arrays.toString(original));

		int[] result = suffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}

	// 정답
	static int[] suffle(int[] arr) {
		int[] result = arr;
		int tmp = 0;
		for (int i = 0; i < 20; ++i) {
			int a = (int) (Math.random() * 9);
			int b = (int) (Math.random() * 9);
			tmp = result[a];
			result[a] = result[b];
			result[b] = tmp;
		}
		return result;
	}

	// 6-21
	static void example6_21() {
		MyTV t = new MyTV();

		t.channel = 100;
		t.volume = 0;
		System.out.println("CH:" + t.channel + ", VOL:" + t.volume);

		t.channelUp();
		t.volumeDown();
		System.out.println("CH:" + t.channel + ", VOL:" + t.volume);

		t.volume = 100;
		t.channelDown();
		t.volumeUp();
		System.out.println("CH:" + t.channel + ", VOL:" + t.volume);
	}

	// 6-22
	static void example6_22() {
		String str = "123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));

		str = "1234o";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
	}

	// 정답
	static boolean isNumber(String str) {
		char ch = ' ';
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (!('0' <= ch && ch <= '9')) {
				break;
			}
			cnt = i;
		}
		if (cnt < str.length() - 1) {
			return false;
		}
		return true;
	}

	// 6-23
	static void example6_23() {
		int[] data = {3,2,9,4,7}; 
		System.out.println(java.util.Arrays.toString(data)); 
		System.out.println("최대값  :"+max(data)); 
		try {	
			System.out.println("최대값  :"+max(null));	// NullPointerException 뜸  
		} catch(NullPointerException ne) {
			System.out.println("최대값  :"+ (-999999));	// NullPointerException 뜸 
		}
		System.out.println("최대값  :"+max(new int[]{})); // 크기가 0인 배열
	}

	// 정답
	static int max(int[] arr) throws NullPointerException {
		if(arr.length == 0 || arr == null) {
			return -999999;
		}
		int max = arr[0];
		for(int i = 0; i < arr.length - 1; ++i) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
	
	//6-24
	static void example6_24() {
		int value = 5;
		System.out.println(value+"의 절대값:"+abs(value));
		value = -10;
		System.out.println(value+"의 절대값:"+abs(value));
	}
	//정답
	static int abs(int value) {
		if(value < 0) {
			return -1*value;
		} else {
			return value;
		}
	}
}

//6-1, 6-2
class SutdaCard {
	// 6-2 (1)
	int num; // 카드의 숫자. (1~10 사이의 정수)
	boolean isKwang; // 광이면 true, 아니면 false

	public SutdaCard() {
		this.num = 1;
		this.isKwang = true;
	}

	public SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	String info() {
		if (isKwang) {
			return this.num + "k";
		}
		return String.format("%d", this.num);
	}

}

//6-3, 6-4, 6-5
class Student {
	// 6-4, 6-5(1)
	static final int BAN = 0;
	static final int NO = 1;
	static final int KOR = 2;
	static final int ENG = 3;
	static final int MATH = 4;

	String name;// 학생 이름
	int ban; // 반
	int no; // 번호
	int kor; // 국어점수
	int eng; // 영어점수
	int math; // 수학점수

	public Student() {

	}

	public Student(String name, int... num) {
		this.name = name;
		this.ban = num[BAN];
		this.no = num[NO];
		this.kor = num[KOR];
		this.eng = num[ENG];
		this.math = num[MATH];
	}

	int getTotal() {
		return this.kor + this.eng + this.math;
	}

	float getAverage() {
		return Math.round(getTotal() / 3.0f * 10) / 10.0f;
	}

	String info() {
		return this.name + "," + this.ban + "," + this.no + "," + this.kor + "," + this.eng + "," + this.math + ","
				+ getTotal() + "," + getAverage();
	}
}

//6-7
class MyPoint {
	int x;
	int y;

	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Double getDistance(int x1, int y1) {
		return Math.sqrt(Math.pow(this.x - x1, 2) + Math.pow(this.y - y1, 2));
	}
}

//6-8
class PlayingCard {
	int kind;
	int num;

	static int width;
	static int height;

	public PlayingCard(int k, int n) {
		// TODO Auto-generated constructor stub
		kind = k;
		num = n;
	}

	/*
	 * 메인 두 개 되면 에러 생길 수 있음 public static void main(String args[]) { PlayingCard
	 * card = new PlayingCard(1, 1); }
	 */
	// 정답
	// - 클래스 변수(static) : width, height
	// - 인스턴스 변수 : kind, num
	// - 지역 변수 : k, n

}

//6-9 답
class Marine {
	int x = 0, y = 0; // Marine 의 위치 좌표(x,y)
	int hp = 60; // 현재 체력
	// 모든 병사의 공격력과 방어력은 같아야 하므로 static 이 붙어야 함.
	static int weapon = 6; // 공격력
	static int armor = 0; // 방어력

	void weaponUp() {
		weapon++;
	}

	void armorUp() {
		armor++;
	}

	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

//6-21
class MyTV {
	boolean isPowerOn;
	int channel;
	int volume;

	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;

	void turnOnOff() {
		// (1) isPowerOn의 값이 true면 false로, false 면 그 반대로
		if (isPowerOn) {
			isPowerOn = false;
		} else {
			isPowerOn = true;
		}
	}

	void volumeUp() {
		// (2)volume의 값이 max 보다 작을 때만 값을 증가시킨다.
		if (this.volume < MAX_VOLUME) {
			++this.volume;
		}
	}

	void volumeDown() {
		// (3)volume의 값이 보다 min 클 때만 값을 감소시킨다.
		if (this.volume > MIN_VOLUME) {
			--this.volume;
		}
	}

	void channelUp() {
		// (4)채널의 값을 증가시킨다.
		// max 채널이면 min 으로
		if (this.channel == MAX_CHANNEL) {
			this.channel = MIN_CHANNEL;
			return;
		}
		++this.channel;
	}

	void channelDown() {
		// (5)채널의 값을 감소시킨다.
		// min 채널이면 max로
		if (this.channel == MIN_CHANNEL) {
			this.channel = MAX_CHANNEL;
			return;
		}
		--this.channel;
	}
}
