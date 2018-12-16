package java_seven;
/*
 * we can have return keyword in try and catch block
 * but it should be the last sentence of try and catch block
 * both should have return keyword
 * we don't need if we have return key in finally block
 */
public class ReturnInTryCatch {
	public static void main(String[] args) {

	}

	@SuppressWarnings("finally")
	public int add() {
		try {
			System.out.println("d");
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		} finally {
			return 1;
		}
	}
}
