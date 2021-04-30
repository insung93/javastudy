package chapter04;

public class WrapperClassTest02 {

	public static void main(String[] args) {
		String s1 = "123456";
		int i = Integer.parseInt(s1);

		// cf. 반대로
		String s2 = String.valueOf(i);
		System.out.println(s1 + ":" + s2);

		// cf. 반대로
		String s3 = "" + i;
		System.out.println(s1 + ":" + s2 + ":" + s3);
		
		int a = Character.getNumericValue('A');
		System.out.println(a);
		
		// 2진수
		String s4 = Integer.toBinaryString(15);
		System.out.println(s4);
		
		// 16진수
		String s5 = Integer.toHexString(15);
		System.out.println(s5);
	}

}
