package Ch10;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormatClassEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double num = -12345.678;
		DecimalFormat df = new DecimalFormat("#.##");
		String result = df.format(num);
		
		System.out.println(result);
		
		Calendar cal = Calendar.getInstance();
		cal.set(2019, 0, 1);
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4;
		SimpleDateFormat sdf5, sdf6, sdf7, sdf8;
		
		sdf1 = new SimpleDateFormat("yy-M-d");
		sdf2 = new SimpleDateFormat("''yy년 MM월 dd일 E요일");
//		System.out.println(sdf1.format(new Date(cal.getTimeInMillis())));
//		System.out.println(sdf2.format(new Date(cal.getTimeInMillis())));
		
		for(int i = 0; i < 12; ++i) {
			int weekDay = cal.get(Calendar.DAY_OF_WEEK);
			int secondSunday = (weekDay == 1)? 8 : 16 - weekDay;
			cal.set(Calendar.DAY_OF_MONTH, secondSunday);
			
			System.out.println(sdf2.format(new Date(cal.getTimeInMillis())));
			cal.add(Calendar.MONTH, 1);
			cal.set(Calendar.DAY_OF_MONTH, 1);
		}
		
	}

}
