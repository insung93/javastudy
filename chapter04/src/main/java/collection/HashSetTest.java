package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();
		String s1 = new String("도우너");
		String s2 = new String("도우너");

		s.add("둘리");
		s.add("마이콜");
		s.add("또치");
		s.add(s1);

		System.out.println(s.size());
		System.out.println(s.contains(s2));
		// 동질 (내용으로 찾음)
		// List에서 지울때 내용으로 찾아서 지움
		
		// 순회1
		Iterator<String> it = s.iterator();
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
	}

}
