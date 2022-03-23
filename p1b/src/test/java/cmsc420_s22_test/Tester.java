package cmsc420_s22_test;

// list-heap regex
// rg "^  (\{lev: \d+ nodeCt: \d+\}|\[\d+ .+\]|\(\d+\)|\[null\])$" test01-expected.txt --context 1 --replace="\"\$1\","

// YOU SHOULD NOT MODIFY THIS FILE, EXCEPT TO ALTER THE INPUT/OUTPUT SOURCES

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Testing program for Part 0. By default, this reads from tests/test01-input.txt and
 * writes the output to tests/test01-output.txt. Change inputFileName and outputFileName
 * below to change this behavior.
 */

public class Tester {

	@Test
	public void test() throws FileNotFoundException {
		final var test = 5;
		final var inputFileName = String.format("test%02d-input.txt", test);
		System.out.printf("@Test\n    void test%02d() {%n", test);
		try(var scanner = new Scanner(new FileInputStream(String.valueOf(Path.of(System.getProperty("user.dir"), "src", "test", "resources", inputFileName))))) {
			var commandHandler = new CommandHandler(); // initialize command handler
			while (scanner.hasNextLine()) {
				var line = scanner.nextLine(); // input next line
				var output = commandHandler.processCommand(line); // process this command
				System.out.print(output); // output summary
			}
		}
		System.out.println("}");
	}
}
