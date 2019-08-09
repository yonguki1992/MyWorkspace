package Ch12;

class Produect<T, M> {
	private T kind;
	private M model;

	public T getKind() {
		return this.kind;
	}

	public M getModel() {
		return this.model;
	}

	public void setKind(T kind) {
		this.kind = kind;
	}

	public void setModel(M model) {
		this.model = model;
	}
}

public class GenericsEx2 {
	public static void main(String[] args) {
		Produect<Integer, String> prod = new Produect<Integer, String>();
		prod.setKind(1);
		prod.setModel("TV");
		System.out.print(prod.getKind() + "  " + prod.getModel());

		Produect<String, String> prod1 = new Produect<String, String>();
		prod1.setKind("서울대리점");
		prod1.setModel("에어컨");
		System.out.print(prod1.getKind() + "  " + prod1.getModel());

		// 서울대림점 에어컨
		// 학생클래스, 교수클래스
		Produect<Student, Professor> prod2 = new Produect<Student, Professor>();
		prod2.setKind(new Student());
		prod2.setModel(new Professor());
		System.out.print(prod2.getKind() + "  " + prod2.getModel());

	}
}// end main_class

class Student {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "학생클래스";
	}
}

class Professor {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "교수클래스";
	}
}