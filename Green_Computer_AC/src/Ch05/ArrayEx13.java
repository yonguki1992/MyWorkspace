package Ch05;

public class ArrayEx13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] hex = {'3', 'C', 'A', 'F', 'E'};
		
		String[] binary = { "0000", "0001", "0010", "0011"
						   ,"0100", "0101", "0110", "0111"
						   ,"1000", "1001", "1010", "1011"
						   ,"1100", "1101", "1110", "1111"};
		
		String result = "";
		
		for(int i = 0; i < hex.length; ++i) {
			if(hex[i] >= '0' && hex[i] <= '9') {
				result += binary[hex[i] - '0'];
			} else {
				result += binary[hex[i] - 'A' + 10];
			}
		}
		
		System.out.println("hex:" + new String(hex));
		System.out.println("binary:" + result);
	}
}


