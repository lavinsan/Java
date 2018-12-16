package java_seven;

public class FindMissingNumber {

	public static void main(String[] args) {
		int[] list1 = { 7, 6, 4, 0, 1, 2, 8, 3 };
		new FindMissingNumber().findNumber(list1);
	}

	public void findNumber(int[] list) {
		int presentNumber = 0;
		int missingNumber = 0;
		int totalNumber = 0;

		for (int i = 0; i < list.length; i++) {
			presentNumber += list[i];
			totalNumber += i + 1;
			if (list[i] == 0) {
				missingNumber = i;
			}
		}
		System.out.print("Value missing : " + (totalNumber - presentNumber));
		System.out.println(" at index number " + (missingNumber + 1));
	}
}
