package Ch06;

public class AcademyClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//학생1 정보 입력
		Students a = new Students("김영미", "홍길동", 100, 70, 80);
		//학생1 정보 출력
		System.out.println(a.toString());
		a.printScore();
		
		//학생2 정보 입력 
		System.out.println();
		Students b = new Students("최수진", "이순신", 100, 70, 90);
		//학생2 정보 출력
		System.out.println(b.toString());
		b.printScore();
		
		//석차 출력
		System.out.println();
		SungJuk s = new SungJuk(a,b);
		s.rank();
	}

}


class SungJuk {
	private Students[] s;
	
	public SungJuk(Students... s) {
		this.s = new Students[s.length];
		this.s = s;
	}
	
	void rank() {
		int cnt = 0;
		int flag = 0;
		Students temp = new Students();
		
		//버블 정렬 사용해서 석차별로 정렬
		for (int i = 1; i < this.s.length; i++) {
			// 플래그가 일정 횟수 증가하면 더 이상 정렬하지 않아도 된다고 판단 루프 종료
			for (int j = 0; j < this.s.length - i && flag < this.s.length - i; j++) {
				cnt++;
				flag++;
				if (this.s[j].avg() < this.s[j + 1].avg()) {
					flag = 0;
					temp = this.s[j];
					this.s[j] = this.s[j + 1];
					this.s[j + 1] = temp;
				}
			}
			
		}
		
		int n = 0;
		for(Students student : s) {	
			System.out.println( ++n + "등 \n" + student.toString());
		}
	}
	
}


class Students {
	static final int KOR = 0;
	static final int ENG = 1;
	static final int MATH = 2;
	//외부에서 접근할 수 없게 접근 제한
	private String name;
	private int[] score;
	private String professor;
	
	// 기본 생성자 SunJuk 클래스의 rank() 메서드에 쓰려고 만듬.
	public Students () {
	}
	
	//이름과 담당 교수만 입력한 경우, 과목은 3개로 고정
	public Students (String name, String professor) {
		this.name = name;
		this.professor = professor;
		this.score = new int[3];
	}
	
	//이름과 담당 교수만 입력한 경우, 과목은 유동적으로 변경할 수 있음
	public Students (String name, String professor, int... score) {
		int n = 0;
		// 점수가 0~100 사이값이 아니면 0점으로 간주해버림
		for(int scores : score) {
			if(scores < 0 || scores > 100) {
				score[n] = 0;
				System.out.println("올바른 점수 값의 범위가 아닙니다.");
			}
			++n;
		}
		
		this.name = name;
		this.professor = professor;
		this.score = new int[score.length];
		
		for(int i = 0; i < this.score.length; ++i) {
			this.score[i] = score[i];
		}		
	}
	
	//점수 입력
	void scoreInput(int... score) {
		for(int i = 0; i < this.score.length; ++i) {
			this.score[i] = score[i];
		}
	}
	
	//점수 출력
	int scoreOutput(int index) {
		return this.score[index];
	}
	
	//과목 갯수
	int numOfSubject() {
		return this.score.length;
	}
	
	//모든 항목  출력
	void printScore() {
		for(int i = 0; i < score.length; ++i) {
			System.out.printf("점수%d : %d 점\n", i+1, scoreOutput(i));
		}
		System.out.printf("총점 : %d 점\n평균 : %.2f\n", sum(), avg());	
	}
	
	// 총점
	int sum() {
		int sum = 0;
		for(int i = 0; i < score.length; ++i) {
			sum += score[i]; 
		}
		return sum;
	}
	
	// 평균
	float avg() {
		return (float)this.sum()/score.length;
	}
	
	//학생 간단한 정보
	public String toString() {
		return "학생 이름 : " + this.name + "\n담당 교수 이름 : " + this.professor;
	}
}

