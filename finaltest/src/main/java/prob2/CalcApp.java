package prob2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CalcApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("두 정수와 연산자를 입력하시오 >> ");
		String input = sc.nextLine();
		String[] token = input.split(" ");

		int leftValue = Integer.parseInt(token[0]);
		int rightValue = Integer.parseInt(token[1]);

		switch (token[2]) {
		case "/":
			Div div = new Div();
			System.out.println(div.calculate(leftValue, rightValue));
			break;
		case "*":
			Mul mul = new Mul();
			System.out.println(mul.calculate(leftValue, rightValue));
			break;
		case "+":
			Add add = new Add();
			System.out.println(add.calculate(leftValue, rightValue));
			break;
		case "-":
			Sub sub = new Sub();
			System.out.println(sub.calculate(leftValue, rightValue));
			break;
		default:
			System.out.println("알 수 없는 식입니다.");
			break;
		}

		sc.close();
	}

}
