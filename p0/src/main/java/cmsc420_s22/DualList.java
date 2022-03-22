package cmsc420_s22; // Don't delete this line or your file won't pass the autograder

import java.util.ArrayList;

/**
 * DualList (skeleton)
 *
 * MODIFY THE FOLLOWING CLASS.
 *
 * You are free to make whatever changes you like or to create additional
 * classes and files.
 */

public class DualList<Key1 extends Comparable<Key1>, Key2 extends Comparable<Key2>> {

	// -----------------------------------------------------------------
	// Public members - You should not modify the function signatures
	// -----------------------------------------------------------------

	public DualList() { /* ... */ } // constructor
	public void insert(Key1 x1, Key2 x2) { /* ... */ } // insert a new pair
	public int size() { /* ... */ return 0; } // return the number of pairs
	public Key2 extractMinKey1() throws EmptyListException { /* ... */ return null; } // remove smallest by Key1 and return its Key2 value
	public Key1 extractMinKey2() throws EmptyListException { /* ... */ return null; } // remove smallest by Key2 and return its Key1 value
	public ArrayList<String> listByKey1() { /* ... */ return null; } // return a list sorted by Key1
	public ArrayList<String> listByKey2() { /* ... */ return null; } // return a list sorted by Key2
}
