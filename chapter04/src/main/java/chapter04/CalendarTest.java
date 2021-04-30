package chapter04;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		// new Calendar();
		// 추상메소드 x 특별한 메소드를 호출해야됨
		Calendar cal = Calendar.getInstance();
		printDate(cal);
		
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 11); // MONTH -1
		cal.set(Calendar.DATE, 25);
		printDate(cal);
		
		cal.set(2010,10,10);
		cal.add(Calendar.DATE,1000);
		printDate(cal);
	}

	private static void printDate(Calendar cal) {
		final String[] DAYS = {"일","월","화","수","목","금","토"};

		final int I = 10;
		// # final
		// 10이라는 값을 마지막으로 넣겠다.
		// 클래스에 붙으면 상속금지
		// 메소드에 붙으면 오버라이드 금지

		// 년
		int year = cal.get(Calendar.YEAR); // 1
		
		// 월 (0~11, +1)
		int month = cal.get(Calendar.MONTH)+1; // 2

		// 일
		int date = cal.get(Calendar.DATE);

		// 요일
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		// 시
		int hours = cal.get(Calendar.HOUR);

		// 분
		int minutes = cal.get(Calendar.MINUTE);

		// 초
		int seconds = cal.get(Calendar.SECOND);
		
		System.out.println(year+"-"+month+"-"+date+" "+DAYS[day-1]+" "+ hours+ ":"+ minutes+":"+seconds);

	}

}
