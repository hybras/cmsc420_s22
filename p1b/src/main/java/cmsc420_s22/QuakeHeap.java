package cmsc420_s22;

import java.util.ArrayList;

public class QuakeHeap<Key extends Comparable<Key>, Value> {

	class Node { /* a node in your tree */ }
	public class Locator { /* locates a node */ }

	// Old functions

	public QuakeHeap(int nLevels) { /* ... */ }
	public void clear() { /* ... */ }
	public Locator insert(Key x, Value v) { /* ... */ return null; }
	public Key getMinKey() throws Exception { /* ... */ return null; }
	public int getMaxLevel(Locator r) { /* ... */ return 0; }
	public ArrayList<String> listHeap() { /* ... */ return new ArrayList<String>(); }

	// New functions

	public void decreaseKey(Locator r, Key newKey) throws Exception { /* ... */ }
	public Value extractMin() throws Exception { /* ... */ return null; }
	public int size() { /* ... */ return 0; }
	public void setQuakeRatio(double newRatio) { /* ... */ }
	public void setNLevels(int nl) throws Exception { /* ... */ }
}
