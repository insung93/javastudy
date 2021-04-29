package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
		
		String s1 = new String("ABC");
		String s2 = new String("ABC");
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode() + ":" + s2.hashCode());
		// 내용기반
		System.out.println(System.identityHashCode(s1) + ":" + System.identityHashCode(s2));
		// 주소기반
		System.out.println("=====================================");
		
		String s3 = "ABC";
		String s4 = "ABC";
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		System.out.println(s3.hashCode() + ":" + s4.hashCode());
		// 내용기반
		System.out.println(System.identityHashCode(s3) + ":" + System.identityHashCode(s4));
		// 주소기반
		// 동일객체 string literal pool
		
		System.out.println("=====================================");
		Integer i = 10;
		Integer j = 10;
		System.out.println(i == j);
		System.out.println(i.equals(j));
		System.out.println(i.hashCode() + ":" + j.hashCode());
		// 내용기반
		System.out.println(System.identityHashCode(i) + ":" + System.identityHashCode(j));
		// 주소기반
		
		System.out.println("=====================================");
		int i2 = 10;
		int j2 = 10;
		System.out.println(i2 == j2);
//		System.out.println(i2.equals(j2));
//		System.out.println(i2.hashCode() + ":" + j2.hashCode());
		// 내용기반
		System.out.println(System.identityHashCode(i2) + ":" + System.identityHashCode(j2));
		// 주소기반
		
	}

}
