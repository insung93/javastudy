package thread;

public class ThreadEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 메인쓰레드가 종료되도 다른 쓰레드가 모두 종료되어야 프로그램 종료
		Thread thread1 = new DigitThread();
		Thread thread2 = new AlpabetThread();
		thread2.start();
		thread1.start();
		System.out.println("메인종료");
	}

}
