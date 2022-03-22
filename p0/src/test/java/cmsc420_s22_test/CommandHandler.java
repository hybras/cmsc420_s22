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
			return switch (cmd) {

				// -----------------------------------------------------
				// INSERT key1 key2
				// - add a pair to the dual list
				// -----------------------------------------------------
				case "insert" -> {
					String key1 = line.next(); // read key1
					int key2 = line.nextInt(); // read key2
					dualList.insert(key1, key2);
					yield String.format("\ndl.insert(\"%s\", %d);\n", key1, key2);
				}
				// -----------------------------------------------------
				// LIST-BY-KEY-1
				// - list in order of key1
				// -----------------------------------------------------
				case "list-by-key1" -> {
					ArrayList<String> list = Objects.requireNonNull(dualList.listByKey1());
					yield "Assertions.assertIterableEquals(List.of(" +
							list.stream().map(it -> '"' + it + '"').collect(Collectors.joining(",")) +
							"), dl.listByKey1());\n";
				}
				// -----------------------------------------------------
				// LIST-BY-KEY-2
				// - list in order of key2
				// -----------------------------------------------------
				case "list-by-key2" -> {
					ArrayList<String> list = Objects.requireNonNull(dualList.listByKey2());
					yield "Assertions.assertIterableEquals(List.of(" +
							list.stream().map(it -> '"' + it + '"').collect(Collectors.joining(",")) +
							"), dl.listByKey2());\n";
				}
				// -----------------------------------------------------
				// EXTRACT-MIN-KEY1
				// -  extract minimum by label but return its value
				// -----------------------------------------------------
				case "extract-min-key1" -> {
					String temp;
					try {
						var min = dualList.extractMinKey1();
						temp = String.format("\nAssertions.assertEquals(%d, Assertions.assertDoesNotThrow(dl::extractMinKey1));\n", min);
					} catch (EmptyListException e) {
						temp = "\nAssertions.assertThrows(EmptyListException.class, dl::extractMinKey1);\n";
					}
					yield temp;
				}
				// -----------------------------------------------------
				// EXTRACT-MIN-VALUE
				// -  extract minimum by value but return its label
				// -----------------------------------------------------
				case "extract-min-key2" -> {
					String temp;
					try {
						var min = dualList.extractMinKey2();
						temp = String.format("\nAssertions.assertEquals(\"%s\", Assertions.assertDoesNotThrow(dl::extractMinKey2));\n", min);
					} catch (EmptyListException e) {
						temp = "\nAssertions.assertThrows(EmptyListException.class, dl::extractMinKey2);\n";
					}
					yield  temp;
				}
				// -----------------------------------------------------
				// SIZE
				// -----------------------------------------------------
				case "size" -> String.format("Assertions.assertEquals(%d, dl.size());\n", dualList.size());
				// -----------------------------------------------------
				// Unrecognized command
				// -----------------------------------------------------
				default -> {
					System.err.println("Error: Invalid command - \"" + cmd + "\" (Ignored)");
					yield "";
				}
			}; // return summary output
		}
	}

}
