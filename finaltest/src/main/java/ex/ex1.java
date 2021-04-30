package ex;


public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ex1Test a1 = new ex1Test();
		ex1Test a2 = new ex1Test();
		ex1Test a3 = a1;
		System.out.println(a1.toString());
		System.out.println(a1==a2);
		System.out.println(a3==a2);
		
		System.out.println(a1.equals(a2));
		System.out.println(a3.equals(a2));
		
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
	}

}
