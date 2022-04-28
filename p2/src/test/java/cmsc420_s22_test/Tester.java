package cmsc420_s22_test;

// YOU SHOULD NOT MODIFY THIS FILE, EXCEPT TO ALTER THE INPUT/OUTPUT SOURCES

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Testing program for Tour data structure
 */

public class Tester {

	// --------------------------------------------------------------------------------------------
	// Uncomment these to read from standard input and output
	// private static final boolean USE_STD_IO = true;
	// private static String inputFileName = "";
	// private static String outputFileName = "";
	// --------------------------------------------------------------------------------------------
	// Uncomment these to read from files
	private static final boolean USE_STD_IO = false;
	// --------------------------------------------------------------------------------------------

	public static void main(int test) {

		// configure to read from file rather than standard input/output
		if (!USE_STD_IO) {
			try {
				String inputFileName = "test%02d-input.txt";
				System.setIn(new FileInputStream(Paths.get("src", "test", "resources", String.format(inputFileName, test)).toString()));
				String outputFileName = "test%02d-output.txt";
				System.setOut(new PrintStream(Paths.get("src", "test", "resources", String.format(outputFileName, test)).toString()));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		try {
			Scanner scanner = new Scanner(System.in); // input scanner
			CommandHandler commandHandler = new CommandHandler(); // initialize command handler
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine(); // input next line
				String output = commandHandler.processCommand(line); // process this command
				System.out.print(output); // output summary
			}
			scanner.close();
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
			e.printStackTrace(System.err);
		}
	}

	@Test void test01() { main(1); }
	@Test void test02() { main(2); }
	@Test void test03() { main(3); }
	@Test void test04() { main(4); }
	@Test void test05() { main(5); }
	@Test void test06() { main(6); }
	@Test void test07() { main(7); }
	@Test void test08() { main(8); }
	@Test void test09() { main(9); }
	@Test void test10() { main(10); }

}
