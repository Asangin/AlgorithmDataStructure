package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
	public static void main(String[] args) {
		String[] str = {"list1", "list2", "list3"};
		ArrayList<Map<String, String>> group;
		
		Map<String, String> m = null;
		group = new ArrayList<>();
		
		for (String st : str) {
			m = new HashMap<>();
			m.put("groupName", st);
			group.add(m);
		}
		System.out.println(group.toString());
	}
}
