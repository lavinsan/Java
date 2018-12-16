package java_eight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author Vinod Lakhani
 *
 */
public class ZipFilesReader {

	public static void main(String[] args) throws Exception {

		zipFilePrintMethod();
		zipFileContentPrintMethod();
	}

	private static void zipFileContentPrintMethod() throws IOException {

		ZipFile zipFile = new ZipFile("File.zip");
		// zipFile entries give enumeration of zipEntry
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			// entries nextElement gives next files and directory
			ZipEntry zipEntry = (ZipEntry) entries.nextElement();
			// zipEntry getName gives name of files and directory
			System.out.println("Directory Or File : " + zipEntry.getName());
			// zipFile getInputStream gives inputStream of files
			InputStream inputStream = zipFile.getInputStream(zipEntry);
			// we pass inputStream to bufferedReader to read content of files
			BufferedReader bufferedReader =
				new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
			Stream<String> lines = bufferedReader.lines();
			lines.forEach(System.out::println);
			System.out.println("-------------------------------------");
		}

		zipFile.close();
	}

	private static void zipFilePrintMethod() throws IOException {
		// It show all the files and folder of zip file
		ZipFile zipFile = new ZipFile("File.zip");
		Stream<? extends ZipEntry> stream = zipFile.stream();
		stream.forEach(System.out::println);
		zipFile.close();
	}

}
