package cmsc420_s22_test;

// YOU SHOULD NOT MODIFY THIS FILE

import cmsc420_s22.DualList;
import cmsc420_s22.EmptyListException;

import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Command handler. This reads a single command line, processes the command (by
 * invoking the appropriate method(s) on the data structure), and returns the
 * result as a string.
 */

public class CommandHandler {

	DualList<String, Integer> dualList; // dual list structure

	/**
	 * Default constructor.
	 */
	public CommandHandler() {
		dualList = new DualList<>(); // initialize
	}

	/**
	 * Process a single command and return the string output. Each command begins
	 * with a command followed by a list of arguments. The arguments are separated
	 * by colons (":").
	 * 
	 * @param inputLine The input line with the command and parameters.
	 * @return A string summary of the command's execution/result.
	 */
	public String processCommand(String inputLine) {
		try (Scanner line = new Scanner(inputLine)) {
			line.useDelimiter(":"); // use ":" to separate arguments
			String cmd = (line.hasNext() ? line.next() : ""); // next command
			final String output; // for storing summary output
			// -----------------------------------------------------
			// INSERT key1 key2
			// - add a pair to the dual list
			// -----------------------------------------------------
			if (cmd.startsWith("insert")) {
				String key1 = line.next(); // read key1
				int key2 = line.nextInt(); // read key2
				dualList.insert(key1, key2);
				output = String.format("dl.insert(\"%s\", %d);\n", key1, key2);
			}
			// -----------------------------------------------------
			// LIST-BY-KEY-1
			// - list in order of key1
			// -----------------------------------------------------
			else if (cmd.startsWith("list-by-key1")) {
				ArrayList<String> list = Objects.requireNonNull(dualList.listByKey1());
				output = "Assertions.assertIterableEquals(List.of(" +
						list.stream().map(it -> '"' + it + '"').collect(Collectors.joining(",")) +
						"), dl.listByKey1());\n";
			}
			// -----------------------------------------------------
			// LIST-BY-KEY-2
			// - list in order of key2
			// -----------------------------------------------------
			else if (cmd.startsWith("list-by-key2")) {
				ArrayList<String> list = Objects.requireNonNull(dualList.listByKey2());
				output = "Assertions.assertIterableEquals(List.of(" +
						list.stream().map(it -> '"' + it + '"').collect(Collectors.joining(",")) +
						"), dl.listByKey2());\n";
			}
			// -----------------------------------------------------
			// EXTRACT-MIN-KEY1
			// -  extract minimum by label but return its value
			// -----------------------------------------------------
			else if (cmd.startsWith("extract-min-key1")) {
				String temp;
				try {
					var min = dualList.extractMinKey1();
					temp = String.format("Assertions.assertEquals(%d, Assertions.assertDoesNotThrow(dl::extractMinKey1));\n", min);
				} catch (EmptyListException e) {
					temp = "Assertions.assertThrows(EmptyListException.class, dl::extractMinKey1);\n";
				}
				output = temp;
			}
			// -----------------------------------------------------
			// EXTRACT-MIN-VALUE
			// -  extract minimum by value but return its label
			// -----------------------------------------------------
			else if (cmd.startsWith("extract-min-key2")) {
				String temp;
				try {
					var min = dualList.extractMinKey2();
					temp = String.format("Assertions.assertEquals(\"%s\", Assertions.assertDoesNotThrow(dl::extractMinKey2));\n", min);
				} catch (EmptyListException e) {
					temp = "Assertions.assertThrows(EmptyListException.class, dl::extractMinKey2);\n";
				}
				output = temp;
			}
			// -----------------------------------------------------
			// SIZE
			// -----------------------------------------------------
			else if (cmd.startsWith("size")) {
				output = String.format("Assertions.assertEquals(%d, dl.size());\n", dualList.size());
			}
			// -----------------------------------------------------
			// Unrecognized command
			// -----------------------------------------------------
			else {
				output = "";
				if (cmd.isBlank())
					System.err.println("Error: Blank command line (Ignored)");
				else
					System.err.println("Error: Invalid command - \"" + cmd + "\" (Ignored)");
			}
			return output; // return summary output
		}
	}

}
