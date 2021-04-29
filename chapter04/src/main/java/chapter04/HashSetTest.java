package chapter04;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {

		Set<Rect> set = new HashSet<>();

		Rect r1 = new Rect(10, 20);
		Rect r2 = new Rect(10, 20);
		
		set.add(r1);
		set.add(r2);
		
		for(Rect rect: set) {
			System.out.println(rect);
		}
		//set에서는 1. hashcode 비교
		//			2. equals로 비교
	}

}
