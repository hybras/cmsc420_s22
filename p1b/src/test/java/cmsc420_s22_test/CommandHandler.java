package cmsc420_s22_test;

// YOU SHOULD NOT MODIFY THIS FILE

import java.util.Scanner;

/**
 * Command handler. This reads a single command line, processes the command (by
 * invoking the appropriate method(s) on the data structure), and returns the
 * result as a string.
 */

public class CommandHandler {

	private boolean initialized; // have we initialized the structure yet?

	/**
	 * Default constructor.
	 */
	public CommandHandler() {
		initialized = false;
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
		try (var line = new Scanner(inputLine)) {
			line.useDelimiter(":"); // use ":" to separate arguments
			var cmd = (line.hasNext() ? line.next() : ""); // next command

			return switch (cmd) {
				// -----------------------------------------------------
				// SET-N-LEVELS
				// - sets the number of levels in the heap
				// - this must be the first command
				// -----------------------------------------------------
				case "set-n-levels" -> {
					var nLevels = line.nextInt(); // read the number of levels
					if (!initialized) {
						initialized = true;
						// initialize with this many levels
						yield String.format("var heap = new QuakeHeap<Integer, String>(%d);\nvar locators = new HashMap<String, QuakeHeap<Integer, String>.Locator>();\n", nLevels);
					} else {
						yield String.format("heap.setNLevels(%d);", nLevels);
					}

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
					var label = line.next(); // read the label
					yield String.format("Assertions.assertEquals(%%d, heap.getMaxLevel(locators.get(\"%s\")));\n", label);
				}
				// -----------------------------------------------------
				// CLEAR
				// -----------------------------------------------------
				case "clear" -> "heap.clear();\nlocators.clear();\n";
				// -----------------------------------------------------
				// SIZE
				// -----------------------------------------------------
				case "size" -> "Assertions.assertEquals(%d, heap.size());\n";
				// -----------------------------------------------------
				// EXTRACT-MIN
				// - extract the minimum element from the heap
				// -----------------------------------------------------
				case "extract-min" -> "Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));\n";
				// -----------------------------------------------------
				// DECREASE-KEY
				// - decrease the key value of some entry
				// -----------------------------------------------------
				case "decrease-key" -> {
					var label = line.next(); // read the label
					var newKey = line.nextInt(); // read the new key value
					yield String.format("Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get(\"%s\"), %d));\n", label, newKey);
				}
				// -----------------------------------------------------
				// SET-QUAKE-RATIO
				// - set the quake ratio
				// -----------------------------------------------------
				case "set-quake-ratio" -> {
					double newRatio = line.nextDouble(); // read the new ratio
					yield String.format("heap.setQuakeRatio(%f);\n", newRatio);
				}
				case "comment" -> {
					var comment = line.next(); // read the comment
					yield String.format("// %s\n", comment);
				}
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
