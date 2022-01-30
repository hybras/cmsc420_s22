package cmsc420_s22_test;

// YOU SHOULD NOT MODIFY THIS FILE

import cmsc420_s22.DualList;

import java.util.Scanner;
import java.util.ArrayList;

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
		dualList = new DualList<String, Integer>(); // initialize
	}

	/**
	 * Process a single command and return the string output. Each command begins
	 * with a command followed by a list of arguments. The arguments are separated
	 * by colons (":").
	 * 
	 * @param inputLine The input line with the command and parameters.
	 * @return A string summary of the command's execution/result.
	 */
	public String processCommand(String inputLine) throws Exception {
		Scanner line = new Scanner(inputLine);
		line.useDelimiter(":"); // use ":" to separate arguments
		String output = new String(); // for storing summary output
		String cmd = (line.hasNext() ? line.next() : ""); // next command
		try {
			// -----------------------------------------------------
			// INSERT key1 key2
			// - add a pair to the dual list
			// -----------------------------------------------------
			if (cmd.compareTo("insert") == 0) {
				String key1 = line.next(); // read key1
				int key2 = line.nextInt(); // read key2
				output += "insert(" + key1 + ", " + key2 + "): ";
				dualList.insert(key1, key2); // add to heap
				output += "successful" + System.lineSeparator();
			}
			// -----------------------------------------------------
			// LIST-BY-KEY-1
			// - list in order of key1
			// -----------------------------------------------------
			else if (cmd.compareTo("list-by-key1") == 0) {
				ArrayList<String> list = dualList.listByKey1();
				if (list == null) throw new Exception("Error - getPreorderList returned a null result");
				output += "list-by-key1: " + System.lineSeparator();
				for (String s: list) { // output all strings in the list
					output += "  " + s + System.lineSeparator();
				}
			}
			// -----------------------------------------------------
			// LIST-BY-KEY-2
			// - list in order of key2
			// -----------------------------------------------------
			else if (cmd.compareTo("list-by-key2") == 0) {
				ArrayList<String> list = dualList.listByKey2();
				if (list == null) throw new Exception("Error - getPreorderList returned a null result");
				output += "list-by-key2: " + System.lineSeparator();
				for (String s: list) { // output all strings in the list
					output += "  " + s + System.lineSeparator();
				}
			}
			// -----------------------------------------------------
			// EXTRACT-MIN-KEY1
			// -  extract minimum by label but return its value
			// -----------------------------------------------------
			else if (cmd.compareTo("extract-min-key1") == 0) {
				output += "extract-min-key1: ";
				Integer value = dualList.extractMinKey1(); // get the minimum key1
				output += value + System.lineSeparator();
			}
			// -----------------------------------------------------
			// EXTRACT-MIN-VALUE
			// -  extract minimum by value but return its label
			// -----------------------------------------------------
			else if (cmd.compareTo("extract-min-key2") == 0) {
				output += "extract-min-key2: ";
				String label = dualList.extractMinKey2(); // get the minimum key2
				output += label + System.lineSeparator();
			}
			// -----------------------------------------------------
			// SIZE
			// -----------------------------------------------------
			else if (cmd.compareTo("size") == 0) {
				int size = dualList.size(); // get the current size
				output += "size: " + size + System.lineSeparator();
			}
			// -----------------------------------------------------
			// Unrecognized command
			// -----------------------------------------------------
			else {
				if (cmd.compareTo("") == 0)
					System.err.println("Error: Empty command line (Ignored)");
				else
					System.err.println("Error: Invalid command - \"" + cmd + "\" (Ignored)");
			}
			line.close();
		} catch (Exception e) { // exception thrown?
			output += "Failure due to exception: \"" + e.getMessage() + "\"" + System.lineSeparator();
		} catch (Error e) { // error occurred?
			System.err.print("Operation failed due to error: " + e.getMessage());
			e.printStackTrace(System.err);
		} finally { // always executed
			line.close(); // close the input scanner
		}
		return output; // return summary output
	}

}
