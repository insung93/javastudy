package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String text = scanner.nextLine();
		String out = "";
		for (int i = 0; i < text.length(); i++) {
			out += text.charAt(i);
			System.out.println(out);
		}

		scanner.close();
	}

}
