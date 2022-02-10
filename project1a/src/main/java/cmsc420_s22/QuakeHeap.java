package cmsc420_s22;

import java.util.ArrayList;

public class QuakeHeap<Key extends Comparable<Key>, Value> {

	class Node { /* a node in your tree */ }
	public class Locator { /* locates a node */ }

	public QuakeHeap(int nLevels) { /* ... */ }
	public void clear() { /* ... */ }
	public Locator insert(Key x, Value v) { /* ... */ return null; }
	public Key getMinKey() throws Exception { /* ... */ return null; }
	public int getMaxLevel(Locator r) { /* ... */ return 0; }
	public ArrayList<String> listHeap() { /* ... */ return new ArrayList<String>(); }

}
