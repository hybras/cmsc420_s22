package cmsc420_s22_test;

import cmsc420_s22.QuakeHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

public class TestQuakeHeap7 {

    @Test
    void test07() {
        // This tests the Part-B functions decrease-key, extract-min, and set-n-levels
        var heap = new QuakeHeap<Integer, String>(5);
        var locators = new HashMap<String, QuakeHeap<Integer, String>.Locator>();
        heap.setQuakeRatio(1.000000);
        locators.put("X01", heap.insert(1, "X01"));
        locators.put("X06", heap.insert(6, "X06"));
        locators.put("X30", heap.insert(30, "X30"));
        locators.put("X31", heap.insert(31, "X31"));
        Assertions.assertEquals(1, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X30"), 0));
        Assertions.assertEquals("X30", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X31"), 0));
        Assertions.assertEquals("X31", Assertions.assertDoesNotThrow(heap::extractMin));
        locators.put("X04", heap.insert(4, "X04"));
        locators.put("X09", heap.insert(9, "X09"));
        locators.put("X20", heap.insert(20, "X20"));
        locators.put("X50", heap.insert(50, "X50"));
        Assertions.assertEquals(1, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X50"), 0));
        Assertions.assertEquals("X50", Assertions.assertDoesNotThrow(heap::extractMin));
        locators.put("X03", heap.insert(3, "X03"));
        locators.put("X16", heap.insert(16, "X16"));
        locators.put("X14", heap.insert(14, "X14"));
        locators.put("X60", heap.insert(60, "X60"));
        locators.put("X61", heap.insert(61, "X61"));
        locators.put("X62", heap.insert(62, "X62"));
        locators.put("X63", heap.insert(63, "X63"));
        locators.put("X64", heap.insert(64, "X64"));
        Assertions.assertEquals(1, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X60"), 0));
        Assertions.assertEquals("X60", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X61"), 0));
        Assertions.assertEquals("X61", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X62"), 0));
        Assertions.assertEquals("X62", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X63"), 0));
        Assertions.assertEquals("X63", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X64"), 0));
        Assertions.assertEquals("X64", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertEquals(1, Assertions.assertDoesNotThrow(heap::getMinKey));
        locators.put("X10", heap.insert(10, "X10"));
        locators.put("X11", heap.insert(11, "X11"));
        locators.put("X40", heap.insert(40, "X40"));
        locators.put("X41", heap.insert(41, "X41"));
        Assertions.assertEquals(1, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X40"), 0));
        Assertions.assertEquals("X40", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X41"), 0));
        Assertions.assertEquals("X41", Assertions.assertDoesNotThrow(heap::extractMin));
        locators.put("X05", heap.insert(5, "X05"));
        locators.put("X08", heap.insert(8, "X08"));
        Assertions.assertEquals(1, Assertions.assertDoesNotThrow(heap::getMinKey));
        locators.put("X21", heap.insert(21, "X21"));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 13}","[21 X21]","{lev: 1 nodeCt: 7}","(5)","[5 X05]","[8 X08]","{lev: 2 nodeCt: 4}","(10)","(10)","[10 X10]","[11 X11]","[null]","{lev: 3 nodeCt: 2}","{lev: 4 nodeCt: 1}","(1)","(1)","(1)","(1)","[1 X01]","[6 X06]","[null]","(4)","(4)","[4 X04]","[9 X09]","(20)","[20 X20]","[null]","(3)","(3)","(3)","[3 X03]","[14 X14]","(16)","[16 X16]","[null]","[null]"), heap.listHeap());
        // This is the first time we reduce the number of levels
        heap.setNLevels(3);
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 13}","[21 X21]","{lev: 1 nodeCt: 7}","(5)","[5 X05]","[8 X08]","{lev: 2 nodeCt: 4}","(1)","(1)","[1 X01]","[6 X06]","[null]","(3)","(3)","[3 X03]","[14 X14]","(16)","[16 X16]","[null]","(4)","(4)","[4 X04]","[9 X09]","(20)","[20 X20]","[null]","(10)","(10)","[10 X10]","[11 X11]","[null]"), heap.listHeap());
        Assertions.assertEquals(1, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 13}","[21 X21]","{lev: 1 nodeCt: 7}","(5)","[5 X05]","[8 X08]","{lev: 2 nodeCt: 4}","(1)","(1)","[1 X01]","[6 X06]","[null]","(3)","(3)","[3 X03]","[14 X14]","(16)","[16 X16]","[null]","(4)","(4)","[4 X04]","[9 X09]","(20)","[20 X20]","[null]","(10)","(10)","[10 X10]","[11 X11]","[null]"), heap.listHeap());
        heap.setNLevels(1);
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 13}","[1 X01]","[3 X03]","[4 X04]","[5 X05]","[6 X06]","[8 X08]","[9 X09]","[10 X10]","[11 X11]","[14 X14]","[16 X16]","[20 X20]","[21 X21]"), heap.listHeap());
        // The following command should generate an exception for invalid number of levels
        Assertions.assertThrows(IllegalArgumentException.class, () -> heap.setNLevels(0));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 13}","[1 X01]","[3 X03]","[4 X04]","[5 X05]","[6 X06]","[8 X08]","[9 X09]","[10 X10]","[11 X11]","[14 X14]","[16 X16]","[20 X20]","[21 X21]"), heap.listHeap());
    }

}
