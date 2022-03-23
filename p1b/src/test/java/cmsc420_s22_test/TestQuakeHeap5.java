package cmsc420_s22_test;

import cmsc420_s22.EmptyHeapException;
import cmsc420_s22.QuakeHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

public class TestQuakeHeap5 {
    @Test
    void test05() {
// This tests the Part-B functions extract-min and size
        var heap = new QuakeHeap<Integer, String>(5);
        var locators = new HashMap<String, QuakeHeap<Integer, String>.Locator>();
// We set the quake ratio to 1, so no quakes should occur
        heap.setQuakeRatio(1.000000);
        locators.put("BWI", heap.insert(88, "BWI"));
        locators.put("LAX", heap.insert(42, "LAX"));
        locators.put("IAD", heap.insert(26, "IAD"));
        locators.put("DCA", heap.insert(67, "DCA"));
        locators.put("JFK", heap.insert(94, "JFK"));
        locators.put("ATL", heap.insert(48, "ATL"));
        locators.put("SFO", heap.insert(19, "SFO"));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 7}",
                "[19 SFO]",
                "[26 IAD]",
                "[42 LAX]",
                "[48 ATL]",
                "[67 DCA]",
                "[88 BWI]",
                "[94 JFK]"), heap.listHeap());
        Assertions.assertEquals(7, heap.size());
        Assertions.assertEquals(19, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 7}",
                "[94 JFK]",
                "{lev: 1 nodeCt: 3}",
                "(67)",
                "[67 DCA]",
                "[88 BWI]",
                "{lev: 2 nodeCt: 1}",
                "(19)",
                "(19)",
                "[19 SFO]",
                "[26 IAD]",
                "(42)",
                "[42 LAX]",
                "[48 ATL]"), heap.listHeap());
        Assertions.assertEquals(7, heap.size());
// The following is the first extract-min
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 6}",
                "{lev: 1 nodeCt: 3}",
                "(67)",
                "[67 DCA]",
                "[88 BWI]",
                "{lev: 2 nodeCt: 1}",
                "(26)",
                "(26)",
                "[26 IAD]",
                "[94 JFK]",
                "(42)",
                "[42 LAX]",
                "[48 ATL]"), heap.listHeap());
        Assertions.assertEquals(6, heap.size());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 5}",
                "[94 JFK]",
                "{lev: 1 nodeCt: 2}",
                "{lev: 2 nodeCt: 1}",
                "(42)",
                "(42)",
                "[42 LAX]",
                "[48 ATL]",
                "(67)",
                "[67 DCA]",
                "[88 BWI]"), heap.listHeap());
        Assertions.assertEquals(5, heap.size());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 4}",
                "{lev: 1 nodeCt: 2}",
                "{lev: 2 nodeCt: 1}",
                "(48)",
                "(48)",
                "[48 ATL]",
                "[94 JFK]",
                "(67)",
                "[67 DCA]",
                "[88 BWI]"), heap.listHeap());
        Assertions.assertEquals(4, heap.size());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 4}",
                "{lev: 1 nodeCt: 2}",
                "{lev: 2 nodeCt: 1}",
                "(48)",
                "(48)",
                "[48 ATL]",
                "[94 JFK]",
                "(67)",
                "[67 DCA]",
                "[88 BWI]"), heap.listHeap());
        Assertions.assertEquals(3, heap.size());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 3}",
                "[94 JFK]",
                "{lev: 1 nodeCt: 1}",
                "(67)",
                "[67 DCA]",
                "[88 BWI]"), heap.listHeap());
        Assertions.assertEquals(2, heap.size());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 2}",
                "{lev: 1 nodeCt: 1}",
                "(88)",
                "[88 BWI]",
                "[94 JFK]"), heap.listHeap());
        Assertions.assertEquals(1, heap.size());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 1}",
                "[94 JFK]"), heap.listHeap());
        Assertions.assertEquals(0, heap.size());
// The following should throw an empty-heap exception
        Assertions.assertThrows(EmptyHeapException.class,heap::extractMin);
        Assertions.assertIterableEquals(List.of(), heap.listHeap());
        Assertions.assertEquals(0, heap.size());
        heap.clear();
        locators.clear();
        Assertions.assertEquals(0, heap.size());
        locators.put("DCA", heap.insert(67, "DCA"));
        locators.put("IAD", heap.insert(26, "IAD"));
        locators.put("ATL", heap.insert(48, "ATL"));
        locators.put("SFO", heap.insert(19, "SFO"));
        locators.put("BWI", heap.insert(88, "BWI"));
        locators.put("JFK", heap.insert(94, "JFK"));
        locators.put("LAX", heap.insert(42, "LAX"));
        locators.put("ORD", heap.insert(73, "ORD"));
        locators.put("DFW", heap.insert(55, "DFW"));
        locators.put("SEA", heap.insert(13, "SEA"));
        locators.put("MIA", heap.insert(22, "MIA"));
        locators.put("CDG", heap.insert(27, "CDG"));
        locators.put("HKG", heap.insert(62, "HKG"));
        locators.put("LHR", heap.insert(46, "LHR"));
        locators.put("NRT", heap.insert(99, "NRT"));
        locators.put("PEK", heap.insert(64, "PEK"));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}",
                "[13 SEA]",
                "[19 SFO]",
                "[22 MIA]",
                "[26 IAD]",
                "[27 CDG]",
                "[42 LAX]",
                "[46 LHR]",
                "[48 ATL]",
                "[55 DFW]",
                "[62 HKG]",
                "[64 PEK]",
                "[67 DCA]",
                "[73 ORD]",
                "[88 BWI]",
                "[94 JFK]",
                "[99 NRT]"), heap.listHeap());
        Assertions.assertEquals(16, heap.size());
        Assertions.assertEquals(13, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}",
                "{lev: 1 nodeCt: 8}",
                "{lev: 2 nodeCt: 4}",
                "{lev: 3 nodeCt: 2}",
                "{lev: 4 nodeCt: 1}",
                "(13)",
                "(13)",
                "(13)",
                "(13)",
                "[13 SEA]",
                "[19 SFO]",
                "(22)",
                "[22 MIA]",
                "[26 IAD]",
                "(27)",
                "(27)",
                "[27 CDG]",
                "[42 LAX]",
                "(46)",
                "[46 LHR]",
                "[48 ATL]",
                "(55)",
                "(55)",
                "(55)",
                "[55 DFW]",
                "[62 HKG]",
                "(64)",
                "[64 PEK]",
                "[67 DCA]",
                "(73)",
                "(73)",
                "[73 ORD]",
                "[88 BWI]",
                "(94)",
                "[94 JFK]",
                "[99 NRT]"), heap.listHeap());
        Assertions.assertEquals(16, heap.size());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 15}",
                "[19 SFO]",
                "{lev: 1 nodeCt: 7}",
                "(22)",
                "[22 MIA]",
                "[26 IAD]",
                "{lev: 2 nodeCt: 3}",
                "(27)",
                "(27)",
                "[27 CDG]",
                "[42 LAX]",
                "(46)",
                "[46 LHR]",
                "[48 ATL]",
                "{lev: 3 nodeCt: 1}",
                "(55)",
                "(55)",
                "(55)",
                "[55 DFW]",
                "[62 HKG]",
                "(64)",
                "[64 PEK]",
                "[67 DCA]",
                "(73)",
                "(73)",
                "[73 ORD]",
                "[88 BWI]",
                "(94)",
                "[94 JFK]",
                "[99 NRT]"), heap.listHeap());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 14}",
                "{lev: 1 nodeCt: 7}",
                "(22)",
                "[22 MIA]",
                "[26 IAD]",
                "{lev: 2 nodeCt: 3}",
                "(27)",
                "(27)",
                "[27 CDG]",
                "[42 LAX]",
                "(46)",
                "[46 LHR]",
                "[48 ATL]",
                "{lev: 3 nodeCt: 1}",
                "(55)",
                "(55)",
                "(55)",
                "[55 DFW]",
                "[62 HKG]",
                "(64)",
                "[64 PEK]",
                "[67 DCA]",
                "(73)",
                "(73)",
                "[73 ORD]",
                "[88 BWI]",
                "(94)",
                "[94 JFK]",
                "[99 NRT]"), heap.listHeap());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 13}",
                "[26 IAD]",
                "{lev: 1 nodeCt: 6}",
                "{lev: 2 nodeCt: 3}",
                "(27)",
                "(27)",
                "[27 CDG]",
                "[42 LAX]",
                "(46)",
                "[46 LHR]",
                "[48 ATL]",
                "{lev: 3 nodeCt: 1}",
                "(55)",
                "(55)",
                "(55)",
                "[55 DFW]",
                "[62 HKG]",
                "(64)",
                "[64 PEK]",
                "[67 DCA]",
                "(73)",
                "(73)",
                "[73 ORD]",
                "[88 BWI]",
                "(94)",
                "[94 JFK]",
                "[99 NRT]"), heap.listHeap());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 12}",
                "{lev: 1 nodeCt: 6}",
                "{lev: 2 nodeCt: 3}",
                "(27)",
                "(27)",
                "[27 CDG]",
                "[42 LAX]",
                "(46)",
                "[46 LHR]",
                "[48 ATL]",
                "{lev: 3 nodeCt: 1}",
                "(55)",
                "(55)",
                "(55)",
                "[55 DFW]",
                "[62 HKG]",
                "(64)",
                "[64 PEK]",
                "[67 DCA]",
                "(73)",
                "(73)",
                "[73 ORD]",
                "[88 BWI]",
                "(94)",
                "[94 JFK]",
                "[99 NRT]"), heap.listHeap());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 11}",
                "[42 LAX]",
                "{lev: 1 nodeCt: 5}",
                "(46)",
                "[46 LHR]",
                "[48 ATL]",
                "{lev: 2 nodeCt: 2}",
                "{lev: 3 nodeCt: 1}",
                "(55)",
                "(55)",
                "(55)",
                "[55 DFW]",
                "[62 HKG]",
                "(64)",
                "[64 PEK]",
                "[67 DCA]",
                "(73)",
                "(73)",
                "[73 ORD]",
                "[88 BWI]",
                "(94)",
                "[94 JFK]",
                "[99 NRT]"), heap.listHeap());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 10}",
                "{lev: 1 nodeCt: 5}",
                "(46)",
                "[46 LHR]",
                "[48 ATL]",
                "{lev: 2 nodeCt: 2}",
                "{lev: 3 nodeCt: 1}",
                "(55)",
                "(55)",
                "(55)",
                "[55 DFW]",
                "[62 HKG]",
                "(64)",
                "[64 PEK]",
                "[67 DCA]",
                "(73)",
                "(73)",
                "[73 ORD]",
                "[88 BWI]",
                "(94)",
                "[94 JFK]",
                "[99 NRT]"), heap.listHeap());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 9}",
                "[48 ATL]",
                "{lev: 1 nodeCt: 4}",
                "{lev: 2 nodeCt: 2}",
                "{lev: 3 nodeCt: 1}",
                "(55)",
                "(55)",
                "(55)",
                "[55 DFW]",
                "[62 HKG]",
                "(64)",
                "[64 PEK]",
                "[67 DCA]",
                "(73)",
                "(73)",
                "[73 ORD]",
                "[88 BWI]",
                "(94)",
                "[94 JFK]",
                "[99 NRT]"), heap.listHeap());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 8}",
                "{lev: 1 nodeCt: 4}",
                "{lev: 2 nodeCt: 2}",
                "{lev: 3 nodeCt: 1}",
                "(55)",
                "(55)",
                "(55)",
                "[55 DFW]",
                "[62 HKG]",
                "(64)",
                "[64 PEK]",
                "[67 DCA]",
                "(73)",
                "(73)",
                "[73 ORD]",
                "[88 BWI]",
                "(94)",
                "[94 JFK]",
                "[99 NRT]"), heap.listHeap());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 7}",
                "[62 HKG]",
                "{lev: 1 nodeCt: 3}",
                "(64)",
                "[64 PEK]",
                "[67 DCA]",
                "{lev: 2 nodeCt: 1}",
                "(73)",
                "(73)",
                "[73 ORD]",
                "[88 BWI]",
                "(94)",
                "[94 JFK]",
                "[99 NRT]"), heap.listHeap());
        Assertions.assertEquals(7, heap.size());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 6}",
                "{lev: 1 nodeCt: 3}",
                "(64)",
                "[64 PEK]",
                "[67 DCA]",
                "{lev: 2 nodeCt: 1}",
                "(73)",
                "(73)",
                "[73 ORD]",
                "[88 BWI]",
                "(94)",
                "[94 JFK]",
                "[99 NRT]"), heap.listHeap());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 5}",
                "[67 DCA]",
                "{lev: 1 nodeCt: 2}",
                "{lev: 2 nodeCt: 1}",
                "(73)",
                "(73)",
                "[73 ORD]",
                "[88 BWI]",
                "(94)",
                "[94 JFK]",
                "[99 NRT]"), heap.listHeap());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 4}",
                "{lev: 1 nodeCt: 2}",
                "{lev: 2 nodeCt: 1}",
                "(73)",
                "(73)",
                "[73 ORD]",
                "[88 BWI]",
                "(94)",
                "[94 JFK]",
                "[99 NRT]"), heap.listHeap());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 3}",
                "[88 BWI]",
                "{lev: 1 nodeCt: 1}",
                "(94)",
                "[94 JFK]",
                "[99 NRT]"), heap.listHeap());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 2}",
                "{lev: 1 nodeCt: 1}",
                "(94)",
                "[94 JFK]",
                "[99 NRT]"), heap.listHeap());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 1}",
                "[99 NRT]"), heap.listHeap());
        Assertions.assertNotNull(locators.remove(Assertions.assertDoesNotThrow(heap::extractMin)));
        Assertions.assertIterableEquals(List.of(), heap.listHeap());
        Assertions.assertEquals(0, heap.size());
// The following attempts to extract-min from an empty heap
        Assertions.assertThrows(EmptyHeapException.class, heap::extractMin);
        Assertions.assertIterableEquals(List.of(), heap.listHeap());
        Assertions.assertEquals(0, heap.size());
    }

}
