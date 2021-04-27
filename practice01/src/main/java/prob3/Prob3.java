package prob3;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		System.out.print("숫자를 입력하세요 : ");
		int number = scanner.nextInt();
		System.out.println("결과 값 : " + cal(number));
		System.out.print("숫자를 입력하세요 : ");
		number = scanner.nextInt();
		System.out.println("결과 값 : " + cal(number));
		System.out.print("숫자를 입력하세요 : ");
		number = scanner.nextInt();
		System.out.println("결과 값 : " + cal(number));

		scanner.close();
	}

	public static int cal(int number) {
		int sum = 0;
		if (number % 2 == 0) {
			for (int i = 0; i <= number; i = i + 2)
				sum += i;
		} else {
			for (int i = 1; i <= number; i = i + 2) {
				sum += i;
			}

		}
		return sum;
	}
}
