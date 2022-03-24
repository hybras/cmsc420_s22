package cmsc420_s22_test;

import cmsc420_s22.EmptyHeapException;
import cmsc420_s22.QuakeHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

public class TestQuakeHeap1 {

    @Test
    void test01() {
        // This is the same as test03 from Part-A
        var heap = new QuakeHeap<Integer, String>(5);
        var locators = new HashMap<String, QuakeHeap<Integer, String>.Locator>();
        // The next command should generate an empty-heap exception
        Assertions.assertThrows(EmptyHeapException.class, heap::getMinKey);
        locators.put("BWI", heap.insert(88, "BWI"));
        locators.put("LAX", heap.insert(42, "LAX"));
        locators.put("IAD", heap.insert(26, "IAD"));
        locators.put("DCA", heap.insert(67, "DCA"));
        locators.put("JFK", heap.insert(94, "JFK"));
        locators.put("ATL", heap.insert(48, "ATL"));
        locators.put("SFO", heap.insert(19, "SFO"));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 7}","[19 SFO]","[26 IAD]","[42 LAX]","[48 ATL]","[67 DCA]","[88 BWI]","[94 JFK]"), heap.listHeap());
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("BWI")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("LAX")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("IAD")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("DCA")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("JFK")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("ATL")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("SFO")));
        Assertions.assertEquals(19, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 7}","[94 JFK]","{lev: 1 nodeCt: 3}","(67)","[67 DCA]","[88 BWI]","{lev: 2 nodeCt: 1}","(19)","(19)","[19 SFO]","[26 IAD]","(42)","[42 LAX]","[48 ATL]"), heap.listHeap());
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("BWI")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("LAX")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("IAD")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("DCA")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("JFK")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("ATL")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("SFO")));
        heap.clear();
        locators.clear();
        // The next command should generate an empty-heap exception
        Assertions.assertThrows(EmptyHeapException.class, heap::getMinKey);
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
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 11}","[13 SEA]","[19 SFO]","[22 MIA]","[26 IAD]","[42 LAX]","[48 ATL]","[55 DFW]","[67 DCA]","[73 ORD]","[88 BWI]","[94 JFK]"), heap.listHeap());
        Assertions.assertEquals(13, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 11}","[94 JFK]","{lev: 1 nodeCt: 5}","(73)","[73 ORD]","[88 BWI]","{lev: 2 nodeCt: 2}","{lev: 3 nodeCt: 1}","(13)","(13)","(13)","[13 SEA]","[19 SFO]","(22)","[22 MIA]","[26 IAD]","(42)","(42)","[42 LAX]","[48 ATL]","(55)","[55 DFW]","[67 DCA]"), heap.listHeap());
        Assertions.assertEquals(3, heap.getMaxLevel(locators.get("SEA")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("BWI")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("JFK")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("LAX")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("DFW")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("ORD")));
    }

}
