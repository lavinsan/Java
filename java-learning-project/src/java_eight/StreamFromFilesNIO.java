package java_eight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Vinod Lakhani
 *
 */
public class StreamFromFilesNIO {

	public static void main(String[] args) throws Exception {

		filesListMethod();
		filesListMethodForFile();
		filesLinesMethod();
		filesFindMethod();
		filesReadAllLinesMethod();
		filesNewBufferedReaderMethod();
		filesWriteMethod();
		filesWalkMethod();
		bufferedReaderLinesMethod();

	}

	private static void bufferedReaderLinesMethod() throws Exception {
		// their is new lines method in bufferedReader
		BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt"));
		Stream<String> lines = bufferedReader.lines();
		lines.forEach(System.out::println);
		bufferedReader.close();
	}

	private static void filesWalkMethod() throws Exception {

		// files.walk will give all the files and directory
		// and also files inside directory
		Stream<Path> walk =
			Files.walk(Paths.get("."), Integer.MAX_VALUE, FileVisitOption.FOLLOW_LINKS);
		walk.forEach(System.out::println);
		walk.close();
	}

	private static void filesWriteMethod() throws Exception {

		// files.write function has overloaded methods to write to files
		// to get path of the file we use toUri and getPath methods.
		String names = "we are the world";
		Path path = Files.write(Paths.get("file1.txt"), names.getBytes(), StandardOpenOption.WRITE);
		String string =
			path.toUri()
				.getPath();
		System.out.println(string);

		List<String> list = Arrays.asList("deepa", "vinod", "lavina", "mohini");
		Path path2 =
			Files.write(Paths.get("file2.txt"), list, Charset.forName("UTF-8"),
				StandardOpenOption.WRITE);
		String string2 =
			path2	.toUri()
					.getPath();
		System.out.println(string2);
	}

	private static void filesNewBufferedReaderMethod() throws IOException {
		// newBufferedReader method is used to get path of files
		// and lines method is used to read the lines
		BufferedReader newBufferedReader = Files.newBufferedReader(Paths.get("file.txt"));
		Stream<String> lines = newBufferedReader.lines();
		lines.forEach(System.out::println);
		newBufferedReader.close();
		System.out.println();
	}

	private static void filesReadAllLinesMethod() throws IOException {
		// readAllLines will read all lines and store in list
		List<String> readAllLines = Files.readAllLines(Paths.get("file.txt"));
		readAllLines.forEach(System.out::println);
		System.out.println();
	}

	private static void filesFindMethod() throws IOException {
		// Files.find gives exact types of files we need with extension
		Path path = Paths.get(".");
		Stream<Path> find =
			Files.find(path, 2, (paths, files) -> String.valueOf(paths)
														.endsWith(".txt"));
		find.forEach(System.out::println);
		find.close();
		System.out.println();
	}

	private static void filesLinesMethod() throws IOException {
		// Files.lines will give all the lines inside the files
		// onClose will inform us that the file is close
		Stream<String> lines1 =
			Files	.lines(Paths.get("file.txt"))
					.onClose(() -> System.out.println("File is now closed"));
		lines1.forEach(System.out::println);
		lines1.close();
		System.out.println();
	}

	private static void filesListMethodForFile() throws IOException {
		// Files.isRegular will give use only files
		Stream<Path> list2 = Files.list(Paths.get(".\\src"));
		list2	.filter(Files::isRegularFile)
				.forEach(System.out::println);
		list2.close();
		System.out.println();
	}

	private static void filesListMethod() throws IOException {
		// Paths.get give location of path
		// Files.list give the list of files from given path
		// close will close the file
		Stream<Path> list1 = Files.list(Paths.get(".\\src"));
		list1.forEach(System.out::println);
		list1.close();
		System.out.println();
	}

}
