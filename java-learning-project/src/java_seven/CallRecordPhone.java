package java_seven;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to find the rate of call after promotions
 * 
 * @author Vinod
 *
 */
public class CallRecordPhone {

	static Map<Integer, Integer> phoneDetails = new HashMap<>();

	public static void main(String[] args) {
		String data = "00:01:07,400-234-090 00:05:01,701-080-080 00:05:00,400-234-090";
		callRecordCheck(data);
	}

	/**
	 * Static method to get rate after promotions
	 * 
	 * @param data
	 *            String data of call and time
	 */
	public static void callRecordCheck(String data) {

		String[] callRecords = data.split(" ");

		for (int i = 0; i < callRecords.length; i++) {
			uniqueNumber(callRecords[i]);
		}

		System.out.println("Map Records :  " + phoneDetails);
		promotionApplied();
		System.out.println("Map Records :  " + phoneDetails);

		for (Map.Entry<Integer, Integer> entry : phoneDetails.entrySet()) {
			System.out.print("Phone # : " + entry.getKey() + "  Time in Seconds : ");
			rateCalculate(entry.getValue());
		}
	}

	/**
	 * Static method to apply promotions its will remove record with highest
	 * call records
	 * 
	 */
	public static void promotionApplied() {
		int value = 0;
		int key = 0;
		for (Map.Entry<Integer, Integer> entry : phoneDetails.entrySet()) {
			if (value == 0) {
				key = entry.getKey();
				value = entry.getValue();
			} else if (entry.getValue() > value) {
				key = entry.getKey();
				value = entry.getValue();
			}
		}
		System.out.println("Record Deleted As condition applied : " + key + "  " + value);
		phoneDetails.remove(key, value);
	}

	/**
	 * Static method to add call durations of unique number in map
	 * 
	 * @param record
	 *            Combine String value of time and phone number
	 */
	public static void uniqueNumber(String record) {

		int hh = Integer.parseInt(record.substring(0, 2));
		int mm = Integer.parseInt(record.substring(3, 5));
		int ss = Integer.parseInt(record.substring(6, 8));
		Integer time = (hh * 3600) + (mm * 60) + ss;

		Integer phone = Integer.parseInt(record.substring(9, 12) + record.substring(13, 16) + record.substring(17, 20));

		if (phoneDetails.containsKey(phone)) {
			phoneDetails.put(phone, phoneDetails.get(phone) + time);
		} else {
			phoneDetails.put(phone, time);
		}
	}

	/**
	 * Static method to calculate call rate
	 * 
	 * @param callDurationInSecond
	 *            Duration in seconds
	 */
	public static void rateCalculate(int callDurationInSecond) {

		int total;
		if (callDurationInSecond < 300) {
			total = callDurationInSecond * 3;
		} else if (callDurationInSecond == 300) {
			total = 750;
		} else {
			if (callDurationInSecond % 60 != 0) {
				total = (callDurationInSecond / 60 + 1) * 150;
			} else {
				total = (callDurationInSecond / 60) * 150;
			}
		}
		System.out.println(callDurationInSecond + "    Rate : " + total + " cents");
	}
}
