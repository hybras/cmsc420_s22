package cmsc420_s22_test;

import cmsc420_s22.QuakeHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

public class TestQuakeHeap4 {

    @Test
    void test04() {
        // This tests the Part-B function decrease-key
        var heap = new QuakeHeap<Integer, String>(6);
        var locators = new HashMap<String, QuakeHeap<Integer, String>.Locator>();
        locators.put("BWI", heap.insert(88, "BWI"));
        locators.put("LAX", heap.insert(42, "LAX"));
        locators.put("IAD", heap.insert(26, "IAD"));
        locators.put("DCA", heap.insert(67, "DCA"));
        locators.put("JFK", heap.insert(94, "JFK"));
        locators.put("ATL", heap.insert(48, "ATL"));
        locators.put("SFO", heap.insert(19, "SFO"));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 7}","[19 SFO]","[26 IAD]","[42 LAX]","[48 ATL]","[67 DCA]","[88 BWI]","[94 JFK]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("BWI"), 20));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 7}","[19 SFO]","[20 BWI]","[26 IAD]","[42 LAX]","[48 ATL]","[67 DCA]","[94 JFK]"), heap.listHeap());
        Assertions.assertEquals(19, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 7}","[94 JFK]","{lev: 1 nodeCt: 3}","(48)","[48 ATL]","[67 DCA]","{lev: 2 nodeCt: 1}","(19)","(19)","[19 SFO]","[20 BWI]","(26)","[26 IAD]","[42 LAX]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("IAD"), 26));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 7}","[94 JFK]","{lev: 1 nodeCt: 3}","(26)","[26 IAD]","[42 LAX]","(48)","[48 ATL]","[67 DCA]","{lev: 2 nodeCt: 1}","(19)","(19)","[19 SFO]","[20 BWI]","[null]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("ATL"), 30));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 7}","[94 JFK]","{lev: 1 nodeCt: 3}","(26)","[26 IAD]","[42 LAX]","(30)","[30 ATL]","[67 DCA]","{lev: 2 nodeCt: 1}","(19)","(19)","[19 SFO]","[20 BWI]","[null]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("ATL"), 10));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 7}","[94 JFK]","{lev: 1 nodeCt: 3}","(10)","[10 ATL]","[67 DCA]","(26)","[26 IAD]","[42 LAX]","{lev: 2 nodeCt: 1}","(19)","(19)","[19 SFO]","[20 BWI]","[null]"), heap.listHeap());
        Assertions.assertEquals(10, Assertions.assertDoesNotThrow(heap::getMinKey));
        heap.clear();
        locators.clear();
        // The following creates a tree with 16 entries and decreases them all by 100
        locators.put("DCA", heap.insert(167, "DCA"));
        locators.put("IAD", heap.insert(126, "IAD"));
        locators.put("ATL", heap.insert(148, "ATL"));
        locators.put("SFO", heap.insert(119, "SFO"));
        locators.put("BWI", heap.insert(188, "BWI"));
        locators.put("JFK", heap.insert(194, "JFK"));
        locators.put("LAX", heap.insert(142, "LAX"));
        locators.put("ORD", heap.insert(173, "ORD"));
        locators.put("DFW", heap.insert(155, "DFW"));
        locators.put("SEA", heap.insert(113, "SEA"));
        locators.put("MIA", heap.insert(122, "MIA"));
        locators.put("CDG", heap.insert(127, "CDG"));
        locators.put("HKG", heap.insert(162, "HKG"));
        locators.put("LHR", heap.insert(146, "LHR"));
        locators.put("NRT", heap.insert(199, "NRT"));
        locators.put("PEK", heap.insert(164, "PEK"));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","[113 SEA]","[119 SFO]","[122 MIA]","[126 IAD]","[127 CDG]","[142 LAX]","[146 LHR]","[148 ATL]","[155 DFW]","[162 HKG]","[164 PEK]","[167 DCA]","[173 ORD]","[188 BWI]","[194 JFK]","[199 NRT]"), heap.listHeap());
        Assertions.assertEquals(113, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","{lev: 1 nodeCt: 8}","{lev: 2 nodeCt: 4}","{lev: 3 nodeCt: 2}","{lev: 4 nodeCt: 1}","(113)","(113)","(113)","(113)","[113 SEA]","[119 SFO]","(122)","[122 MIA]","[126 IAD]","(127)","(127)","[127 CDG]","[142 LAX]","(146)","[146 LHR]","[148 ATL]","(155)","(155)","(155)","[155 DFW]","[162 HKG]","(164)","[164 PEK]","[167 DCA]","(173)","(173)","[173 ORD]","[188 BWI]","(194)","[194 JFK]","[199 NRT]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SEA"), 13));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","{lev: 1 nodeCt: 8}","{lev: 2 nodeCt: 4}","{lev: 3 nodeCt: 2}","{lev: 4 nodeCt: 1}","(13)","(13)","(13)","(13)","[13 SEA]","[119 SFO]","(122)","[122 MIA]","[126 IAD]","(127)","(127)","[127 CDG]","[142 LAX]","(146)","[146 LHR]","[148 ATL]","(155)","(155)","(155)","[155 DFW]","[162 HKG]","(164)","[164 PEK]","[167 DCA]","(173)","(173)","[173 ORD]","[188 BWI]","(194)","[194 JFK]","[199 NRT]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("DFW"), 55));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","{lev: 1 nodeCt: 8}","{lev: 2 nodeCt: 4}","{lev: 3 nodeCt: 2}","(55)","(55)","(55)","[55 DFW]","[162 HKG]","(164)","[164 PEK]","[167 DCA]","(173)","(173)","[173 ORD]","[188 BWI]","(194)","[194 JFK]","[199 NRT]","{lev: 4 nodeCt: 1}","(13)","(13)","(13)","(13)","[13 SEA]","[119 SFO]","(122)","[122 MIA]","[126 IAD]","(127)","(127)","[127 CDG]","[142 LAX]","(146)","[146 LHR]","[148 ATL]","[null]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("CDG"), 27));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","{lev: 1 nodeCt: 8}","{lev: 2 nodeCt: 4}","(27)","(27)","[27 CDG]","[142 LAX]","(146)","[146 LHR]","[148 ATL]","{lev: 3 nodeCt: 2}","(55)","(55)","(55)","[55 DFW]","[162 HKG]","(164)","[164 PEK]","[167 DCA]","(173)","(173)","[173 ORD]","[188 BWI]","(194)","[194 JFK]","[199 NRT]","{lev: 4 nodeCt: 1}","(13)","(13)","(13)","(13)","[13 SEA]","[119 SFO]","(122)","[122 MIA]","[126 IAD]","[null]","[null]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("MIA"), 22));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","{lev: 1 nodeCt: 8}","(22)","[22 MIA]","[126 IAD]","{lev: 2 nodeCt: 4}","(27)","(27)","[27 CDG]","[142 LAX]","(146)","[146 LHR]","[148 ATL]","{lev: 3 nodeCt: 2}","(55)","(55)","(55)","[55 DFW]","[162 HKG]","(164)","[164 PEK]","[167 DCA]","(173)","(173)","[173 ORD]","[188 BWI]","(194)","[194 JFK]","[199 NRT]","{lev: 4 nodeCt: 1}","(13)","(13)","(13)","(13)","[13 SEA]","[119 SFO]","[null]","[null]","[null]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SFO"), 19));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","[19 SFO]","{lev: 1 nodeCt: 8}","(22)","[22 MIA]","[126 IAD]","{lev: 2 nodeCt: 4}","(27)","(27)","[27 CDG]","[142 LAX]","(146)","[146 LHR]","[148 ATL]","{lev: 3 nodeCt: 2}","(55)","(55)","(55)","[55 DFW]","[162 HKG]","(164)","[164 PEK]","[167 DCA]","(173)","(173)","[173 ORD]","[188 BWI]","(194)","[194 JFK]","[199 NRT]","{lev: 4 nodeCt: 1}","(13)","(13)","(13)","(13)","[13 SEA]","[null]","[null]","[null]","[null]"), heap.listHeap());
        // The following applies get-max-level from a degenerate tree
        Assertions.assertEquals(4, heap.getMaxLevel(locators.get("SEA")));
        // The minimum key comes from a completely degenerate tree
        Assertions.assertEquals(13, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","[19 SFO]","{lev: 1 nodeCt: 8}","(22)","[22 MIA]","[126 IAD]","{lev: 2 nodeCt: 4}","(27)","(27)","[27 CDG]","[142 LAX]","(146)","[146 LHR]","[148 ATL]","{lev: 3 nodeCt: 2}","(55)","(55)","(55)","[55 DFW]","[162 HKG]","(164)","[164 PEK]","[167 DCA]","(173)","(173)","[173 ORD]","[188 BWI]","(194)","[194 JFK]","[199 NRT]","{lev: 4 nodeCt: 1}","(13)","(13)","(13)","(13)","[13 SEA]","[null]","[null]","[null]","[null]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("DCA"), 67));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","[19 SFO]","[67 DCA]","{lev: 1 nodeCt: 8}","(22)","[22 MIA]","[126 IAD]","{lev: 2 nodeCt: 4}","(27)","(27)","[27 CDG]","[142 LAX]","(146)","[146 LHR]","[148 ATL]","{lev: 3 nodeCt: 2}","(55)","(55)","(55)","[55 DFW]","[162 HKG]","(164)","[164 PEK]","[null]","(173)","(173)","[173 ORD]","[188 BWI]","(194)","[194 JFK]","[199 NRT]","{lev: 4 nodeCt: 1}","(13)","(13)","(13)","(13)","[13 SEA]","[null]","[null]","[null]","[null]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("IAD"), 26));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","[19 SFO]","[26 IAD]","[67 DCA]","{lev: 1 nodeCt: 8}","(22)","[22 MIA]","[null]","{lev: 2 nodeCt: 4}","(27)","(27)","[27 CDG]","[142 LAX]","(146)","[146 LHR]","[148 ATL]","{lev: 3 nodeCt: 2}","(55)","(55)","(55)","[55 DFW]","[162 HKG]","(164)","[164 PEK]","[null]","(173)","(173)","[173 ORD]","[188 BWI]","(194)","[194 JFK]","[199 NRT]","{lev: 4 nodeCt: 1}","(13)","(13)","(13)","(13)","[13 SEA]","[null]","[null]","[null]","[null]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("ATL"), 48));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","[19 SFO]","[26 IAD]","[48 ATL]","[67 DCA]","{lev: 1 nodeCt: 8}","(22)","[22 MIA]","[null]","{lev: 2 nodeCt: 4}","(27)","(27)","[27 CDG]","[142 LAX]","(146)","[146 LHR]","[null]","{lev: 3 nodeCt: 2}","(55)","(55)","(55)","[55 DFW]","[162 HKG]","(164)","[164 PEK]","[null]","(173)","(173)","[173 ORD]","[188 BWI]","(194)","[194 JFK]","[199 NRT]","{lev: 4 nodeCt: 1}","(13)","(13)","(13)","(13)","[13 SEA]","[null]","[null]","[null]","[null]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("BWI"), 88));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","[19 SFO]","[26 IAD]","[48 ATL]","[67 DCA]","[88 BWI]","{lev: 1 nodeCt: 8}","(22)","[22 MIA]","[null]","{lev: 2 nodeCt: 4}","(27)","(27)","[27 CDG]","[142 LAX]","(146)","[146 LHR]","[null]","{lev: 3 nodeCt: 2}","(55)","(55)","(55)","[55 DFW]","[162 HKG]","(164)","[164 PEK]","[null]","(173)","(173)","[173 ORD]","[null]","(194)","[194 JFK]","[199 NRT]","{lev: 4 nodeCt: 1}","(13)","(13)","(13)","(13)","[13 SEA]","[null]","[null]","[null]","[null]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("JFK"), 94));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","[19 SFO]","[26 IAD]","[48 ATL]","[67 DCA]","[88 BWI]","{lev: 1 nodeCt: 8}","(22)","[22 MIA]","[null]","(94)","[94 JFK]","[199 NRT]","{lev: 2 nodeCt: 4}","(27)","(27)","[27 CDG]","[142 LAX]","(146)","[146 LHR]","[null]","{lev: 3 nodeCt: 2}","(55)","(55)","(55)","[55 DFW]","[162 HKG]","(164)","[164 PEK]","[null]","(173)","(173)","[173 ORD]","[null]","[null]","{lev: 4 nodeCt: 1}","(13)","(13)","(13)","(13)","[13 SEA]","[null]","[null]","[null]","[null]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("LAX"), 42));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","[19 SFO]","[26 IAD]","[42 LAX]","[48 ATL]","[67 DCA]","[88 BWI]","{lev: 1 nodeCt: 8}","(22)","[22 MIA]","[null]","(94)","[94 JFK]","[199 NRT]","{lev: 2 nodeCt: 4}","(27)","(27)","[27 CDG]","[null]","(146)","[146 LHR]","[null]","{lev: 3 nodeCt: 2}","(55)","(55)","(55)","[55 DFW]","[162 HKG]","(164)","[164 PEK]","[null]","(173)","(173)","[173 ORD]","[null]","[null]","{lev: 4 nodeCt: 1}","(13)","(13)","(13)","(13)","[13 SEA]","[null]","[null]","[null]","[null]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("ORD"), 73));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","[19 SFO]","[26 IAD]","[42 LAX]","[48 ATL]","[67 DCA]","[88 BWI]","{lev: 1 nodeCt: 8}","(22)","[22 MIA]","[null]","(94)","[94 JFK]","[199 NRT]","{lev: 2 nodeCt: 4}","(27)","(27)","[27 CDG]","[null]","(146)","[146 LHR]","[null]","(73)","(73)","[73 ORD]","[null]","[null]","{lev: 3 nodeCt: 2}","(55)","(55)","(55)","[55 DFW]","[162 HKG]","(164)","[164 PEK]","[null]","[null]","{lev: 4 nodeCt: 1}","(13)","(13)","(13)","(13)","[13 SEA]","[null]","[null]","[null]","[null]"), heap.listHeap());
        Assertions.assertEquals(13, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","{lev: 1 nodeCt: 11}","(94)","[94 JFK]","[199 NRT]","{lev: 2 nodeCt: 6}","{lev: 3 nodeCt: 4}","(55)","(55)","(55)","[55 DFW]","[162 HKG]","(164)","[164 PEK]","[null]","[null]","{lev: 4 nodeCt: 2}","{lev: 5 nodeCt: 1}","(13)","(13)","(13)","(13)","(13)","[13 SEA]","[null]","[null]","[null]","[null]","(19)","(19)","(19)","(19)","[19 SFO]","[26 IAD]","(22)","[22 MIA]","[null]","(27)","(27)","[27 CDG]","[null]","(146)","[146 LHR]","[null]","(42)","(42)","(42)","[42 LAX]","[48 ATL]","(67)","[67 DCA]","[88 BWI]","(73)","(73)","[73 ORD]","[null]","[null]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("HKG"), 62));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","[62 HKG]","{lev: 1 nodeCt: 11}","(94)","[94 JFK]","[199 NRT]","{lev: 2 nodeCt: 6}","{lev: 3 nodeCt: 4}","(55)","(55)","(55)","[55 DFW]","[null]","(164)","[164 PEK]","[null]","[null]","{lev: 4 nodeCt: 2}","{lev: 5 nodeCt: 1}","(13)","(13)","(13)","(13)","(13)","[13 SEA]","[null]","[null]","[null]","[null]","(19)","(19)","(19)","(19)","[19 SFO]","[26 IAD]","(22)","[22 MIA]","[null]","(27)","(27)","[27 CDG]","[null]","(146)","[146 LHR]","[null]","(42)","(42)","(42)","[42 LAX]","[48 ATL]","(67)","[67 DCA]","[88 BWI]","(73)","(73)","[73 ORD]","[null]","[null]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("LHR"), 46));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","[62 HKG]","{lev: 1 nodeCt: 11}","(46)","[46 LHR]","[null]","(94)","[94 JFK]","[199 NRT]","{lev: 2 nodeCt: 6}","{lev: 3 nodeCt: 4}","(55)","(55)","(55)","[55 DFW]","[null]","(164)","[164 PEK]","[null]","[null]","{lev: 4 nodeCt: 2}","{lev: 5 nodeCt: 1}","(13)","(13)","(13)","(13)","(13)","[13 SEA]","[null]","[null]","[null]","[null]","(19)","(19)","(19)","(19)","[19 SFO]","[26 IAD]","(22)","[22 MIA]","[null]","(27)","(27)","[27 CDG]","[null]","[null]","(42)","(42)","(42)","[42 LAX]","[48 ATL]","(67)","[67 DCA]","[88 BWI]","(73)","(73)","[73 ORD]","[null]","[null]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("NRT"), 99));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","[62 HKG]","[99 NRT]","{lev: 1 nodeCt: 11}","(46)","[46 LHR]","[null]","(94)","[94 JFK]","[null]","{lev: 2 nodeCt: 6}","{lev: 3 nodeCt: 4}","(55)","(55)","(55)","[55 DFW]","[null]","(164)","[164 PEK]","[null]","[null]","{lev: 4 nodeCt: 2}","{lev: 5 nodeCt: 1}","(13)","(13)","(13)","(13)","(13)","[13 SEA]","[null]","[null]","[null]","[null]","(19)","(19)","(19)","(19)","[19 SFO]","[26 IAD]","(22)","[22 MIA]","[null]","(27)","(27)","[27 CDG]","[null]","[null]","(42)","(42)","(42)","[42 LAX]","[48 ATL]","(67)","[67 DCA]","[88 BWI]","(73)","(73)","[73 ORD]","[null]","[null]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("PEK"), 64));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","[62 HKG]","[99 NRT]","{lev: 1 nodeCt: 11}","(46)","[46 LHR]","[null]","(64)","[64 PEK]","[null]","(94)","[94 JFK]","[null]","{lev: 2 nodeCt: 6}","{lev: 3 nodeCt: 4}","(55)","(55)","(55)","[55 DFW]","[null]","[null]","[null]","{lev: 4 nodeCt: 2}","{lev: 5 nodeCt: 1}","(13)","(13)","(13)","(13)","(13)","[13 SEA]","[null]","[null]","[null]","[null]","(19)","(19)","(19)","(19)","[19 SFO]","[26 IAD]","(22)","[22 MIA]","[null]","(27)","(27)","[27 CDG]","[null]","[null]","(42)","(42)","(42)","[42 LAX]","[48 ATL]","(67)","[67 DCA]","[88 BWI]","(73)","(73)","[73 ORD]","[null]","[null]"), heap.listHeap());
        Assertions.assertEquals(13, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","{lev: 1 nodeCt: 12}","{lev: 2 nodeCt: 8}","{lev: 3 nodeCt: 5}","{lev: 4 nodeCt: 3}","(46)","(46)","(46)","(46)","[46 LHR]","[null]","(62)","[62 HKG]","[99 NRT]","(64)","(64)","[64 PEK]","[null]","(94)","[94 JFK]","[null]","(55)","(55)","(55)","[55 DFW]","[null]","[null]","[null]","{lev: 5 nodeCt: 1}","(13)","(13)","(13)","(13)","(13)","[13 SEA]","[null]","[null]","[null]","[null]","(19)","(19)","(19)","(19)","[19 SFO]","[26 IAD]","(22)","[22 MIA]","[null]","(27)","(27)","[27 CDG]","[null]","[null]","(42)","(42)","(42)","[42 LAX]","[48 ATL]","(67)","[67 DCA]","[88 BWI]","(73)","(73)","[73 ORD]","[null]","[null]"), heap.listHeap());
        locators.put("ICN", heap.insert(1, "ICN"));
        Assertions.assertEquals(1, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 17}","[1 ICN]","{lev: 1 nodeCt: 12}","{lev: 2 nodeCt: 8}","{lev: 3 nodeCt: 5}","{lev: 4 nodeCt: 3}","(46)","(46)","(46)","(46)","[46 LHR]","[null]","(62)","[62 HKG]","[99 NRT]","(64)","(64)","[64 PEK]","[null]","(94)","[94 JFK]","[null]","(55)","(55)","(55)","[55 DFW]","[null]","[null]","[null]","{lev: 5 nodeCt: 1}","(13)","(13)","(13)","(13)","(13)","[13 SEA]","[null]","[null]","[null]","[null]","(19)","(19)","(19)","(19)","[19 SFO]","[26 IAD]","(22)","[22 MIA]","[null]","(27)","(27)","[27 CDG]","[null]","[null]","(42)","(42)","(42)","[42 LAX]","[48 ATL]","(67)","[67 DCA]","[88 BWI]","(73)","(73)","[73 ORD]","[null]","[null]"), heap.listHeap());
    }

}
