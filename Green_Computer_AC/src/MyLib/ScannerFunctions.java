package MyLib;

import static java.lang.System.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class ScannerFunctions {
	
	final String INPUT_MISMATCH_ALERT;
	final String INPUT_ALERT;
	private Scanner s = new Scanner(in);

	public ScannerFunctions() {
		this("올바른 숫자를 입력해 주세요.", "올바른 문자열을 입력해 주세요.");
	}
	
	public ScannerFunctions(String... args) {
		this.INPUT_MISMATCH_ALERT = args[0];
		this.INPUT_ALERT = args[1];
	}

	//destructor
	public void finalize() {
		s.close();
		System.gc();
	}
	
	public void clearCLI() {
		out.println("계속하시려면 아무 버튼이나 눌러주세요...");
		inputText();
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

	public int inputNumber() {
		int num = 0;
		boolean flag = true;
		while (flag) {
			try {
				num = s.nextInt();
				flag = false;
			} catch (InputMismatchException ime) {
				out.print(this.INPUT_MISMATCH_ALERT+" > ");
				s.next(); // 스캐너버퍼 비우기
			} catch (Exception e) {
				out.print(this.INPUT_ALERT+" > ");
				s.next(); // 스캐너버퍼 비우기
			}
		}
		return num;
	}
	
	public String inputText() {
		String str = null;
		while (StringUtils.equals(str, null)) {
			try {
				str = s.next();
			} catch (NoSuchElementException e) {
				out.println(this.INPUT_ALERT+" > ");
				s.next(); // 스캐너버퍼 비우기
			} catch (Exception e) {
				out.println(this.INPUT_ALERT+" > ");
				s.next(); // 스캐너버퍼 비우기
			}
		}
		return str;
	}
	
	public String inputTextLine() {
		String str = null;
		while (StringUtils.equals(str, null)) {
			try {
				str = s.nextLine();
			} catch (NoSuchElementException e) {
				out.println(this.INPUT_ALERT+" > ");
				s.next(); // 스캐너버퍼 비우기
			} catch (Exception e) {
				out.println(this.INPUT_ALERT+" > ");
				s.next(); // 스캐너버퍼 비우기
			}
		}
		return str;
	}
	
}