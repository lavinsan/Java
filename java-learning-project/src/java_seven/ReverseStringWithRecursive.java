package java_seven;

public class ReverseStringWithRecursive {
//
	public static void main(String[] args) {
		String data = "vinod";
		System.out.println(reverseWithRecursive(data));
	}

	private static String reverseWithRecursive(String data) {
		String s = "";
		if (data.length() == 1) {
			return data;
		} else {
			s += data.charAt(data.length() - 1) + reverseWithRecursive(data.substring(0, data.length() - 1));
			return s;
		}
	}
}