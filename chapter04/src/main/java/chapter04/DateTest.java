package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		printDate01(now);
		printDate02(now);
	}

	private static void printDate02(Date d) {
		// 년도 -> +1900
		int year = d.getYear() + 1900;

		// 월 -> +1
		int month = d.getMonth() + 1;

		// 일
		int date = d.getDate();

		// 일
		int hours = d.getHours();

		// 일
		int minutes = d.getMinutes();

		// 일
		int seconds = d.getSeconds();
		
		System.out.println(year+"-"+month+"-"+date+" "+ hours+ ":"+ minutes+":"+seconds);

	}

	private static void printDate01(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String date = sdf.format(d);
		System.out.println(date);
	}

}
