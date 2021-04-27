package prob2;

public class Prob2 {
	public static void main(String[] args) {
		/* 코드 작성 */
		int i = 1;

		for (int j = 1; j < 10; j++) {
			for (int k = 0; k < 10; k++) {
				System.out.print(i + k + " ");
			}
			i += 1;
			System.out.println();
		}

	}
}
