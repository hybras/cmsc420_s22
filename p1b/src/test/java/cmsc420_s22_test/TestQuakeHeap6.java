package cmsc420_s22_test;

import cmsc420_s22.QuakeHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

public class TestQuakeHeap6 {

    @Test
    void test06() {
        // This tests the Part-B functions decrease-key and extract-min
        var heap = new QuakeHeap<Integer, String>(6);
        var locators = new HashMap<String, QuakeHeap<Integer, String>.Locator>();
        // We set the quake ratio super high, so no quakes can occur
        heap.setQuakeRatio(1.000000);
        locators.put("X04", heap.insert(4, "X04"));
        locators.put("X09", heap.insert(9, "X09"));
        locators.put("X20", heap.insert(20, "X20"));
        locators.put("X21", heap.insert(21, "X21"));
        Assertions.assertEquals(4, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 4}","{lev: 1 nodeCt: 2}","{lev: 2 nodeCt: 1}","(4)","(4)","[4 X04]","[9 X09]","(20)","[20 X20]","[21 X21]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X21"), 0));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 4}","[0 X21]","{lev: 1 nodeCt: 2}","{lev: 2 nodeCt: 1}","(4)","(4)","[4 X04]","[9 X09]","(20)","[20 X20]","[null]"), heap.listHeap());
        Assertions.assertEquals("X21", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 3}","{lev: 1 nodeCt: 2}","{lev: 2 nodeCt: 1}","(4)","(4)","[4 X04]","[9 X09]","(20)","[20 X20]","[null]"), heap.listHeap());
        locators.put("X05", heap.insert(5, "X05"));
        locators.put("X06", heap.insert(6, "X06"));
        locators.put("X30", heap.insert(30, "X30"));
        locators.put("X31", heap.insert(31, "X31"));
        Assertions.assertEquals(4, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 7}","{lev: 1 nodeCt: 4}","{lev: 2 nodeCt: 2}","{lev: 3 nodeCt: 1}","(4)","(4)","(4)","[4 X04]","[9 X09]","(20)","[20 X20]","[null]","(5)","(5)","[5 X05]","[6 X06]","(30)","[30 X30]","[31 X31]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X30"), 0));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 7}","{lev: 1 nodeCt: 4}","(0)","[0 X30]","[31 X31]","{lev: 2 nodeCt: 2}","{lev: 3 nodeCt: 1}","(4)","(4)","(4)","[4 X04]","[9 X09]","(20)","[20 X20]","[null]","(5)","(5)","[5 X05]","[6 X06]","[null]"), heap.listHeap());
        Assertions.assertEquals("X30", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 6}","[31 X31]","{lev: 1 nodeCt: 3}","{lev: 2 nodeCt: 2}","{lev: 3 nodeCt: 1}","(4)","(4)","(4)","[4 X04]","[9 X09]","(20)","[20 X20]","[null]","(5)","(5)","[5 X05]","[6 X06]","[null]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X31"), 0));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 6}","[0 X31]","{lev: 1 nodeCt: 3}","{lev: 2 nodeCt: 2}","{lev: 3 nodeCt: 1}","(4)","(4)","(4)","[4 X04]","[9 X09]","(20)","[20 X20]","[null]","(5)","(5)","[5 X05]","[6 X06]","[null]"), heap.listHeap());
        Assertions.assertEquals("X31", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 5}","{lev: 1 nodeCt: 3}","{lev: 2 nodeCt: 2}","{lev: 3 nodeCt: 1}","(4)","(4)","(4)","[4 X04]","[9 X09]","(20)","[20 X20]","[null]","(5)","(5)","[5 X05]","[6 X06]","[null]"), heap.listHeap());
        locators.put("X40", heap.insert(40, "X40"));
        locators.put("X41", heap.insert(41, "X41"));
        locators.put("X42", heap.insert(42, "X42"));
        locators.put("X43", heap.insert(43, "X43"));
        locators.put("X44", heap.insert(44, "X44"));
        locators.put("X45", heap.insert(45, "X45"));
        locators.put("X46", heap.insert(46, "X46"));
        locators.put("X47", heap.insert(47, "X47"));
        Assertions.assertEquals(4, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X40"), 0));
        Assertions.assertEquals("X40", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X41"), 0));
        Assertions.assertEquals("X41", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X42"), 0));
        Assertions.assertEquals("X42", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X43"), 0));
        Assertions.assertEquals("X43", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X44"), 0));
        Assertions.assertEquals("X44", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X45"), 0));
        Assertions.assertEquals("X45", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X46"), 0));
        Assertions.assertEquals("X46", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X47"), 0));
        Assertions.assertEquals("X47", Assertions.assertDoesNotThrow(heap::extractMin));
        locators.put("X07", heap.insert(7, "X07"));
        locators.put("X16", heap.insert(16, "X16"));
        locators.put("X50", heap.insert(50, "X50"));
        locators.put("X51", heap.insert(51, "X51"));
        Assertions.assertEquals(4, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X50"), 0));
        Assertions.assertEquals("X50", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X51"), 0));
        Assertions.assertEquals("X51", Assertions.assertDoesNotThrow(heap::extractMin));
        locators.put("X14", heap.insert(14, "X14"));
        locators.put("X60", heap.insert(60, "X60"));
        locators.put("X61", heap.insert(61, "X61"));
        locators.put("X62", heap.insert(62, "X62"));
        Assertions.assertEquals(4, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X60"), 0));
        Assertions.assertEquals("X60", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X61"), 0));
        Assertions.assertEquals("X61", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X62"), 0));
        Assertions.assertEquals("X62", Assertions.assertDoesNotThrow(heap::extractMin));
        locators.put("X70", heap.insert(70, "X70"));
        locators.put("X71", heap.insert(71, "X71"));
        locators.put("X72", heap.insert(72, "X72"));
        locators.put("X73", heap.insert(73, "X73"));
        locators.put("X74", heap.insert(74, "X74"));
        locators.put("X75", heap.insert(75, "X75"));
        locators.put("X76", heap.insert(76, "X76"));
        locators.put("X77", heap.insert(77, "X77"));
        Assertions.assertEquals(4, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X70"), 0));
        Assertions.assertEquals("X70", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X71"), 0));
        Assertions.assertEquals("X71", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X72"), 0));
        Assertions.assertEquals("X72", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X73"), 0));
        Assertions.assertEquals("X73", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X74"), 0));
        Assertions.assertEquals("X74", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X75"), 0));
        Assertions.assertEquals("X75", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X76"), 0));
        Assertions.assertEquals("X76", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("X77"), 0));
        Assertions.assertEquals("X77", Assertions.assertDoesNotThrow(heap::extractMin));
        locators.put("X08", heap.insert(8, "X08"));
        locators.put("X11", heap.insert(11, "X11"));
        Assertions.assertEquals(4, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 10}","{lev: 1 nodeCt: 6}","(8)","[8 X08]","[11 X11]","{lev: 2 nodeCt: 4}","{lev: 3 nodeCt: 2}","{lev: 4 nodeCt: 2}","{lev: 5 nodeCt: 1}","(4)","(4)","(4)","(4)","(4)","[4 X04]","[9 X09]","(20)","[20 X20]","[null]","(5)","(5)","[5 X05]","[6 X06]","[null]","[null]","(7)","(7)","(7)","(7)","[7 X07]","[16 X16]","[null]","(14)","(14)","[14 X14]","[null]","[null]","[null]"), heap.listHeap());
        // We reset the quake ratio to 0.75, so quakes can occur now
        heap.setQuakeRatio(0.750000);
        // The following extract-min will trigger a quake down to level 1
        Assertions.assertEquals("X04", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 9}","[9 X09]","{lev: 1 nodeCt: 5}","(5)","[5 X05]","[6 X06]","(7)","[7 X07]","[16 X16]","(8)","[8 X08]","[11 X11]","(14)","[14 X14]","[null]","(20)","[20 X20]","[null]"), heap.listHeap());
    }

}
