package cmsc420_s22_test;

// YOU SHOULD NOT MODIFY THIS FILE

import cmsc420_s22.QuakeHeap;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Command handler. This reads a single command line, processes the command (by
 * invoking the appropriate method(s) on the data structure), and returns the
 * result as a string.
 */

public class CommandHandler {

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
				// SET-N-LEVELS
				// - sets the number of levels in the heap
				// - this must be the first command
				// -----------------------------------------------------
				case "set-n-levels" -> {
					int nLevels = line.nextInt(); // read the number of levels
					yield String.format("var heap = new QuakeHeap<Integer, String>(%d);\nvar locators = new HashMap<String, QuakeHeap<Integer, String>.Locator>();\n", nLevels);
				}
				// -----------------------------------------------------
				// INSERT label key
				// - add item with given label and key and save its location
				// -----------------------------------------------------
				case "insert" -> {
					var label = line.next(); // read the label
					var key = line.nextInt(); // read the key
					yield String.format("locators.put(\"%s\", heap.insert(%d, \"%s\"));\n", label, key, label);

				}
				// -----------------------------------------------------
				// LIST-HEAP
				// - list the heap contents, with each tree in preorder
				// -----------------------------------------------------
				case "list-heap" -> "Assertions.assertIterableEquals(List.of(%s), heap.listHeap());\n";
				// -----------------------------------------------------
				// GET-MIN-KEY
				// - get the minimum element from the heap
				// -----------------------------------------------------
				case "get-min-key" -> "Assertions.assertEquals(%d, Assertions.assertDoesNotThrow(heap::getMinKey));\n";
				// -----------------------------------------------------
				// GET-MAX-LEVEL
				// - get the maximum level at which key with label occurs
				// -----------------------------------------------------
				case "get-max-level" -> {
					String label = line.next(); // read the label
					yield String.format("Assertions.assertEquals(%%d, heap.getMaxLevel(locators.get(\"%s\")));\n", label);
				}
				// -----------------------------------------------------
				// CLEAR
				// -----------------------------------------------------
				case "clear" -> "heap.clear();\nlocators.clear();\n";
				// -----------------------------------------------------
				// Unrecognized command
				// -----------------------------------------------------
				default -> {
					System.err.println("Error: Invalid command - \"" + cmd + "\" (Ignored)");
					yield "";
				}
			};
		}
    }

}
