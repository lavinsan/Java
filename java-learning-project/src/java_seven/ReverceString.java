package java_seven;

public class ReverceString {

	public static void main(String[] args) {

		String name = "vinod lakhani";
		StringBuffer bf = new StringBuffer(name);
		String reverse = new String(bf.reverse());
		System.out.println(reverse);
		
		reverseString(name);
		
	}
	
	public static void reverseString(String s) {
		
		for (int i = s.length()-1; i >= 0; i--) {
			System.out.print(s.charAt(i));
		}
		
	}

}
