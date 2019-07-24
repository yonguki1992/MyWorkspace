package Ch05;

public class ArrayEx16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("매개변수의  갯수 : " + args.length);
		int i = 0;
		for(String arg : args) {
			System.out.println("args["+ i++ +"] : " + arg);
		}
	}

}
