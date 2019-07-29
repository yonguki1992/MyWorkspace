package Ch10;

import java.util.*;
import static java.lang.System.out;

public class CalendarEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 2) {
			out.print("Usage : java CalendarEx01 2019 2");
			return;
		}
		int year = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		
		Calendar sDay = Calendar.getInstance();
		Calendar eDay = Calendar.getInstance();
		
		sDay.set(year, month - 1, 1);
		eDay.set(year, month - 1, sDay.getActualMaximum(Calendar.DATE));
		
		sDay.add(Calendar.DATE, 1 - sDay.get(Calendar.DAY_OF_WEEK));
		eDay.add(Calendar.DATE, 7 - eDay.get(Calendar.DAY_OF_WEEK));
		
		if(isLeapYear(year)) {
			out.println(year + "는 윤년입니다.");
		} else {
			out.println(year + "는 윤년이 아닙니다.");			
		}
		out.println("       " + year + "년 " + month + "월\n" + " SU MO TU WE TH FR SA");
		
		
		for(int n = 1; eDay.after(sDay) || eDay.equals(sDay); sDay.add(Calendar.DATE, 1), n++) {
			int day = sDay.get(Calendar.DATE);
			out.print( (day < 10) ? "  " + day : " " + day );
			if(n%7==0) {
				out.println();
			}
		}
	}
	
	public static boolean isLeapYear(int year) {
		return ((year%4 == 0) && (year%100 != 0) || (year%400 ==0));
	}
	
}