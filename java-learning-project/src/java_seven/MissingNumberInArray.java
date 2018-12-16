package java_seven;

import java.util.BitSet;

public class MissingNumberInArray {

	public static void main(String[] args) {
		missingNumber(new int[] { 1, 2, 3, 4, 7, 8, 9 }, 10);

	}

	public static void missingNumber(int[] missing, int count) {
		int missingCount = count - missing.length;
		BitSet bit = new BitSet(count);
		for (int m : missing) {
			bit.set(m - 1);
		}
		int index = 0;
		for (int i = 0; i < missingCount; i++) {
			index = bit.nextClearBit(index);
			System.out.println(++index);
		}
	}

}