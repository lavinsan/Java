package java_seven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

	public void readFile() {

		List<String> list = new ArrayList<>();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(""));
			String line;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
