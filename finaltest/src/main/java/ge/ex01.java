package ge;

public class ex01 {

	public static void main(String[] args) {
		Ge<Integer, String> g1 = new Ge<Integer,String>(5,"aaaa");
		Ge<String, Integer> g2 = new Ge<String, Integer>("bbbb",7);
		g1.pr();
		g2.pr();

	}

}
