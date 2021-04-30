package prob01;

public class Printer {
//	void println(Object str) {
//		System.out.println(str);
//	}
	public <T> void println(T t) {
		System.out.println(t);
	}

	public <T> void println(T... ts) {
		for(T t : ts) {
			System.out.print(t);
			System.out.print(" ");
		}
		System.out.print("\n");
	}
	
	public int sum(Integer... nums) {
		Integer sum = 0;
		for(Integer i : nums) {
			sum += i;
		}
		return sum;
	}
}
