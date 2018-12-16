package java_seven;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FileRepeatedWords {
//
	public static void main(String[] args) throws Exception {

		File file = new File("d://vin.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		Map<String, Integer> fileMap = new HashMap<>();
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			StringTokenizer st = new StringTokenizer(line);
			while (st.hasMoreTokens()) {
				String temp = st.nextToken().toLowerCase();
				if (fileMap.containsKey(temp)) {
					fileMap.put(temp, fileMap.get(temp) + 1);
				} else {
					fileMap.put(temp, 1);
				}
			}
		}
		br.close();
		System.out.println(fileMap);
	}
}
