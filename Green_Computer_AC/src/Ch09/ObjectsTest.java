package Ch09;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

public class ObjectsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		String str = null;
		t.setName(str);
		System.out.println(t.name + t.name);
		System.out.println(StringUtils.equals(str, t.name));
//		String[][] str2d = new String[][] {{"AA", "BB"},{"CC", "DD"}};
//		String[][] str2d2 = new String[][] {{"AA", "BB"},{"CC", "DD"}};
//		
//		if(Objects.deepEquals(str2d, str2d2)) {
//			System.out.println("둘은 같음");
//		}
	}

}

class Test {
	
	String name;
	
	void setName(String name) {
//		this.name = Objects.requireNonNull(name, "널값 들어갔다.");
		this.name = StringUtils.trim(name);			//공백 제거, null은 null로, ""는 ""로 리턴
		this.name = StringUtils.trimToNull(name);	//공백 제거, null은 null로, ""도 null로 리턴
		this.name = StringUtils.trimToEmpty(name);	//공백 제거, null은 ""로, ""도 ""로 리턴
	}
}