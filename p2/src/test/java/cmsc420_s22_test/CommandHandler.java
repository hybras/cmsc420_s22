package cmsc420_s22_test;

// YOU SHOULD NOT MODIFY THIS FILE

import cmsc420_s22.Airport;
import cmsc420_s22.HBkdTree;
import cmsc420_s22.Point2D;
import cmsc420_s22.Rectangle2D;

import java.util.*;

/**
 * Command handler. This inputs a single command line, processes the command (by
 * invoking the appropriate method(s) on the HBkdTree)) and returns the result
 * as a string.
 */

public class CommandHandler {

	private boolean initialized; // have we initialized the structure yet?
	private int maxHeightDifference; // max allowed height difference
	private HBkdTree<Airport> hbkdTree; // the HB kd-tree
	private final HashMap<String, Airport> airports; // airport codes seen so far

	/**
	 * Initialize command handler
	 */
	public CommandHandler() {
		maxHeightDifference = Integer.MAX_VALUE;
		airports = new HashMap<>();
		hbkdTree = null;
	}

	/**
	 * Process a single command and return the string output. Each line begins with
	 * a command (e.g., find, insert, delete) followed by a list of arguments. The
	 * arguments are separated by colons (":"). For example, the command to delete
	 * the LAX airport is "delete:LAX".
	 *
	 * The preorder command gets a listing of the airports in preorder. It prints
	 * this list and also generates a nicely indented (inorder) presentation of the
	 * tree's contents.
	 * 
	 * @param inputLine The input line with the command and parameters.
	 * @return A short summary of the command's execution/result.
	 */

	public String processCommand(String inputLine) throws Exception {
		StringBuilder output = new StringBuilder(); // for storing summary output
		try (Scanner line = new Scanner(inputLine)) {
			line.useDelimiter(":"); // use ":" to separate arguments
			String cmd = (line.hasNext() ? line.next() : ""); // next command
			// -----------------------------------------------------
			// INITIALIZE
			// - this command must come first in the input
			// - sets the max height difference and bounding box
			// -----------------------------------------------------
			if (cmd.compareTo("initialize") == 0) {
				maxHeightDifference = line.nextInt(); // read the difference
				if (maxHeightDifference <= 0) {
					throw new Exception("Error - max-height-difference must be at least 1");
				}
				double xMin = line.nextDouble(); // bounding box
				double xMax = line.nextDouble();
				double yMin = line.nextDouble();
				double yMax = line.nextDouble();
				if (xMin > xMax || yMin > yMax) {
					throw new Exception("Error - invalid bounding box dimensions");
				}
				if (initialized) {
					throw new Exception("Error - Second attempt to initialize");
				} else {
					Rectangle2D bbox = new Rectangle2D(new Point2D(xMin, yMin), new Point2D(xMax, yMax));
					hbkdTree = new HBkdTree<>(maxHeightDifference, bbox); // create a new tree
					output.append("initialize: height-difference = ").append(maxHeightDifference).append(", bounding-box = ").append(bbox).append(System.lineSeparator());
					initialized = true;
				}
			}
			// -----------------------------------------------------
			// COMMENT string
			// - comment line for the output
			// -----------------------------------------------------
			else if (cmd.compareTo("comment") == 0) {
				String comment = line.next(); // read the comment
				output.append("[").append(comment).append("]").append(System.lineSeparator());
			}
			// -----------------------------------------------------
			// MAX-HEIGHT-DIFFERENCE
			// - updates the max height difference
			// -----------------------------------------------------
			else if (cmd.compareTo("max-height-difference") == 0) {
				confirmInitialized(); // confirm that we are initialized
				int newHeightDifference = line.nextInt(); // read the difference
				if (newHeightDifference <= 0) {
					throw new Exception("Error - max-height-difference must be at least 1");
				}
				output.append("max-height-difference(").append(newHeightDifference).append("): ");
				hbkdTree.setHeightDifference(newHeightDifference);
				output.append("successful").append(System.lineSeparator());
			}

			// -----------------------------------------------------
			// INSERT code city x y
			// -----------------------------------------------------
			else if (cmd.compareTo("insert") == 0) {
				confirmInitialized(); // confirm that we are initialized
				String code = line.next(); // get parameters
				String city = line.next();
				double x = line.nextDouble();
				double y = line.nextDouble();
				Airport ap = new Airport(code, city, x, y); // create airport object
				output.append("insert(").append(code).append("): ");
				Airport ap2 = airports.get(code);
				if (ap2 != null) { // code already exists?
					throw new Exception("Insertion of duplicate airport code");
				}
				hbkdTree.insert(ap); // insert into kd-tree
				airports.put(code, ap); // insert into dictionary
				output.append("successful {").append(ap.getString("attributes")).append("}").append(System.lineSeparator());
			}
			// -----------------------------------------------------
			// DELETE code
			// -----------------------------------------------------
			else if (cmd.compareTo("delete") == 0) {
				confirmInitialized(); // confirm that we are initialized
				String code = line.next(); // get parameters
				output.append("delete(").append(code).append("): ");
				Airport ap = airports.get(code); // look up the airport
				if (ap == null) { // no such airport?
					throw new Exception("Deletion of nonexistent airport code");
				}
				hbkdTree.delete(ap.getPoint2D()); // delete from kd-tree
				airports.remove(code); // delete from dictionary
				output.append("successful").append(System.lineSeparator());
			}
			// -----------------------------------------------------
			// CLEAR
			// -----------------------------------------------------
			else if (cmd.compareTo("clear") == 0) {
				confirmInitialized(); // confirm that we are initialized
				hbkdTree.clear(); // clear the kd-tree
				airports.clear(); // clear the airports map
				output.append("clear: successful").append(System.lineSeparator());
			}
			// -----------------------------------------------------
			// SIZE
			// -----------------------------------------------------
			else if (cmd.compareTo("size") == 0) {
				confirmInitialized(); // confirm that we are initialized
				int size = hbkdTree.size(); // get the tree's current size
				output.append("size: ").append(size).append(System.lineSeparator());
			}
			// -----------------------------------------------------
			// FIND code
			// -----------------------------------------------------
			else if (cmd.compareTo("find") == 0) {
				confirmInitialized(); // confirm that we are initialized
				double x = line.nextDouble();
				double y = line.nextDouble();
				Point2D pt = new Point2D(x, y);
				Airport result = hbkdTree.find(pt); // find in tree
				output.append(summarizeFind(cmd, pt, result)); // summarize result
			}
			// -----------------------------------------------------
			// RECTANGULAR-RANGE - return the points that lie within
			// a rectangle given by its x and y intervals.
			// -----------------------------------------------------
			else if (cmd.compareTo("orthog-range-report") == 0) {
				confirmInitialized(); // confirm that we are initialized
				double xMin = line.nextDouble();
				double xMax = line.nextDouble();
				double yMin = line.nextDouble();
				double yMax = line.nextDouble();
				if (xMax < xMin || yMax < yMin) {
					throw new Exception("Error - Invalid rectangular-range bounds");
				}
				Rectangle2D query = new Rectangle2D(new Point2D(xMin, yMin), new Point2D(xMax, yMax));
				ArrayList<Airport> list = hbkdTree.orthogRangeReport(query);
				if (list == null) {
					throw new Exception("Error - rectangularRange returned a null result");
				}
				Collections.sort(list); // sort by code
				Iterator<Airport> iter = list.iterator(); // iterator for the list
				output.append("orthog-range-report x=[").append(xMin).append("..").append(xMax).append("] y=[").append(yMin).append(",").append(yMax).append("] :").append(System.lineSeparator());
				while (iter.hasNext()) { // output the list (flat)
					output.append("  ").append(iter.next()).append(System.lineSeparator());
				}
			}
			// -----------------------------------------------------
			// PREORDER - get a preorder list of entries and print
			// the tree with indentation
			// -----------------------------------------------------
			else if (cmd.compareTo("preorder") == 0) {
				confirmInitialized(); // confirm that we are initialized
				ArrayList<String> list = hbkdTree.getPreorderList();
				if (list == null)
					throw new Exception("Error - getPreorderList returned a null result");
				Iterator<String> iter = list.iterator(); // iterator for the list
				output.append("Preorder list:").append(System.lineSeparator());
				while (iter.hasNext()) { // output the preorder list (flat)
					output.append("  ").append(iter.next()).append(System.lineSeparator());
				}
				output.append(treeStructure(list)); // summarize tree contents (indented)
			}
			//
			// -----------------------------------------------------
			// Invalid command or empty
			// -----------------------------------------------------
			else {
				if (cmd.compareTo("") == 0)
					System.err.println("Error: Empty command line (Ignored)");
				else
					System.err.println("Error: Invalid command - \"" + cmd + "\" (Ignored)");
			}
		} catch (Exception e) { // exception thrown?
			output.append("failure due to exception: \"").append(e.getMessage()).append("\"").append(System.lineSeparator());
		} catch (Error e) { // error occurred?
			System.err.print("Operation failed due to error: " + e.getMessage());
			e.printStackTrace(System.err);
		} // always executed
		// close the input scanner
		return output.toString(); // return summary output
	}

	/**
	 * Confirm that the data structure has been initialized, or throw an exception.
	 */
	void confirmInitialized() throws Exception {
		if (!initialized) {
			throw new Exception("Error: First command must be 'initialize'.");
		}
	}

	/**
	 * Summarize the results of the find commands.
	 * 
	 * @param cmd    The command (find)
	 * @param result The find result (null, if not found)
	 * @return String encoding the results
	 */
	static String summarizeFind(String cmd, Point2D pt, Airport result) {
		String output = cmd + "(" + pt + "): ";
		if (result != null) {
			output += "found [" + result + "]" + System.lineSeparator();
		} else {
			output += "not found" + System.lineSeparator();
		}
		return output;
	}

	/**
	 * Summarize the results of the find commands.
	 * 
	 * @param cmd    The command (find-smaller, find-larger)
	 * @param result The find result (null, if not found)
	 * @return String encoding the results
	 */
	static String summarizeFindSL(String cmd, double x, Airport result) {
		String output = cmd + "(" + x + "): ";
		if (result != null) {
			output += "found [" + result + "]" + System.lineSeparator();
		} else {
			output += "not found" + System.lineSeparator();
		}
		return output;
	}

	/**
	 * Summarize the results of the get command.
	 * 
	 * @param cmd    The command (get-min or get-max)
	 * @param result The find result (null, if not found)
	 * @return String encoding the results
	 */
	static String summarizeGet(String cmd, Airport result) {
		String output = cmd + ": ";
		if (result != null) {
			output += "found [" + result + "]" + System.lineSeparator();
		} else {
			output += "no entries" + System.lineSeparator();
		}
		return output;
	}

	/**
	 * Summarize the results of the get command.
	 * 
	 * @param cmd    The command (remove-min or remove-max)
	 * @param result The find result (null, if not found)
	 * @return String encoding the results
	 */
	static String summarizeRemove(String cmd, Airport result) {
		String output = cmd + ": ";
		if (result != null) {
			output += "removed [" + result + "]" + System.lineSeparator();
		} else {
			output += "no entries" + System.lineSeparator();
		}
		return output;
	}

	/**
	 * Print the tree contents with indentation.
	 * 
	 * @param entries List of entries in preorder
	 * @return String encoding the tree structure
	 */
	static String treeStructure(ArrayList<String> entries) {
		String output = "Tree structure:" + System.lineSeparator();
		Iterator<String> iter = entries.iterator(); // iterator for the list
		if (iter.hasNext()) { // tree is nonempty
			output += treeStructureHelper(iter, "  "); // print everything
		}
		return output;
	}

	/**
	 * Recursive helper for treeStructure. The argument iterator specifies the next
	 * node from the preorder list to be printed, and the argument indent indicates
	 * the indentation to be performed (of the form "| | | ...").
	 * 
	 * @param iter   Iterator for the entries in the list
	 * @param indent String indentation for the current line
	 */
	static String treeStructureHelper(Iterator<String> iter, String indent) {
		final String levelIndent = "| "; // the indentation for each level of the tree
		String output = "";
		if (iter.hasNext()) {
			String entry = iter.next(); // get the next entry
			boolean isExtern = (entry.length() > 0 && entry.charAt(0) == '['); // external?
			if (isExtern) { // print external node entry
				// output += indent + entry + System.lineSeparator();
			} else {
				output += treeStructureHelper(iter, indent + levelIndent); // print left subtree
				output += indent + entry + System.lineSeparator(); // print this node
				output += treeStructureHelper(iter, indent + levelIndent); // print right subtree
			}
		} else {
			System.err.println("Unexpected trailing elements in entries list"); // shouldn't get here!
		}
		return output;
	}
}
