
package com.kyu.pcCafeManager;

import static java.lang.System.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PCmanager {
	// try - catch 사용 하여 메서드에서 넘어온 예외 처리 할 것
	// while 사용하고 printUi의 리턴값에 따라 루프 유지 여부 결정할 것.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UImanager ui = UImanager.getUImanagerInstance();
		ui.init();
		ui.printUI();

	}
}

