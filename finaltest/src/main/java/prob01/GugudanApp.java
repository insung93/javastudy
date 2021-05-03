package prob01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GugudanApp {

	public static void main(String[] args) {

		Set<Gugudan> s = new HashSet<>();
		int left, right, answer=0;
		while (s.size() != 9) {
			left = (int) (Math.random() * 9 + 1);
			right = (int) (Math.random() * 9 + 1);
			s.add(new Gugudan(left, right));
			if (s.size() == 1) {
				answer = left * right;
				System.out.println(left+" * "+right+" = ?\n");
			}
		}
		
		
		int cnt = 0;
		for (Gugudan g : s) {
			System.out.print(g.getLeft() * g.getRight() + "\t");
			cnt++;
			if (cnt == 3 || cnt == 6 || cnt == 9) {
				System.out.println();
			}
		}
		System.out.print("answer : ");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		if(input==answer) {
			System.out.println("정답");
		}else {
			System.out.println("오답");
		}

	}

}
