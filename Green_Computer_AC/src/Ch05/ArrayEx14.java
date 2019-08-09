package Ch05;

public class ArrayEx14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name1 = "Kim yong uk";
		String name2 = "Kwak yong uk";
		int i = 0;
		for(char str : name1.toCharArray()) {
			char ch = str;
			System.out.println("name1.charAt(" + i++ + ") : " + ch);
		}
		char[] chArr = name1.toCharArray();
	
		System.out.println(chArr);
		
		System.out.println("내 성은 " + name1.substring(0, name1.indexOf(" ")));
		System.out.println("내 이름은 " + name1.substring(name1.indexOf(" ") + 1, name1.length()));
		
		if(name1.substring(name1.indexOf(" ") + 1, name1.length()).equals(name2.substring(name2.indexOf(" ") + 1, name2.length()))) {
			System.out.println("name1과 name2의 이름이 같습니다.");
		} else {
			System.out.println("name1과 name2의 이름이 다릅니다.");
		}
	}

}
