package java_seven;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
	//  First non repeated character
	public static void main(String[] args) {

		String s = "zyxzcadxsyx";
		Character c;
		int a = 1;

		Map<Character, Integer> m = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (m.containsKey(c)) {
				m.put(c, m.get(c) + 1);
			} else {
				m.put(c, a);
			}
		}

		System.out.println(m);

		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (m.get(c) == 1) {
				System.out.println(c + " First non repeatable Character");
				break;
			}
		}

	}
}
