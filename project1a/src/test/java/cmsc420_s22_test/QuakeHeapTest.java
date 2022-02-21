package cmsc420_s22_test;

import cmsc420_s22.QuakeHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

// \"  (.+)\\n" \+

public class QuakeHeapTest {

    @Test
    void test01() {
        var qh = new QuakeHeap<Integer, String>(5);

        qh.insert(2, "X02");

        qh.insert(9, "X09");
        Assertions.assertEquals(2, Assertions.assertDoesNotThrow(qh::getMinKey));
        Assertions.assertIterableEquals(List.of(
                "{lev: 0 nodeCt: 2}",
                "{lev: 1 nodeCt: 1}",
                "(2)",
                "[2 X02]",
                "[9 X09]"
        ), qh.listHeap());

        qh.insert(5, "X05");

        qh.insert(3, "X03");

        qh.insert(7, "X07");
        Assertions.assertIterableEquals(List.of(
                "{lev: 0 nodeCt: 5}",
                "[3 X03]",
                "[5 X05]",
                "[7 X07]",
                "{lev: 1 nodeCt: 1}",
                "(2)",
                "[2 X02]",
                "[9 X09]"
        ), qh.listHeap());
        Assertions.assertEquals(Assertions.assertDoesNotThrow(qh::getMinKey), 2);
        Assertions.assertIterableEquals(List.of(
                "{lev: 0 nodeCt: 5}",
                "[7 X07]",
                "{lev: 1 nodeCt: 2}",
                "{lev: 2 nodeCt: 1}",
                "(2)",
                "(2)",
                "[2 X02]",
                "[9 X09]",
                "(3)",
                "[3 X03]",
                "[5 X05]"
        ), qh.listHeap());
    }

    @Test
    void test02() {
        var heap = new QuakeHeap<Integer, String>(5);
        var locators = new HashMap<String, QuakeHeap<Integer, String>.Locator>();
        locators.put("JFK", heap.insert(4, "JFK"));
        locators.put("ORD", heap.insert(9, "ORD"));
        locators.put("DFW", heap.insert(20, "DFW"));
        Assertions.assertEquals(4, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of(
                "{lev: 0 nodeCt: 3}",
                "[20 DFW]",
                "{lev: 1 nodeCt: 1}",
                "(4)",
                "[4 JFK]",
                "[9 ORD]"
        ), heap.listHeap());
        locators.put("DEL", heap.insert(5, "DEL"));
        locators.put("LAX", heap.insert(6, "LAX"));
        Assertions.assertEquals(4, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("JFK")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("ORD")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("DFW")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("DEL")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("LAX")));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 5}",
                "[20 DFW]",
                "{lev: 1 nodeCt: 2}",
                "{lev: 2 nodeCt: 1}",
                "(4)",
                "(4)",
                "[4 JFK]",
                "[9 ORD]",
                "(5)",
                "[5 DEL]",
                "[6 LAX]"), heap.listHeap());
        locators.put("CDG", heap.insert(7, "CDG"));
        locators.put("SFO", heap.insert(16, "SFO"));
        Assertions.assertEquals(4, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 7}",
                "[20 DFW]",
                "{lev: 1 nodeCt: 3}",
                "(7)",
                "[7 CDG]",
                "[16 SFO]",
                "{lev: 2 nodeCt: 1}",
                "(4)",
                "(4)",
                "[4 JFK]",
                "[9 ORD]",
                "(5)",
                "[5 DEL]",
                "[6 LAX]"), heap.listHeap());
        locators.put("ATL", heap.insert(14, "ATL"));
        Assertions.assertEquals(4, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 8}",
                "{lev: 1 nodeCt: 4}",
                "{lev: 2 nodeCt: 2}",
                "{lev: 3 nodeCt: 1}",
                "(4)",
                "(4)",
                "(4)",
                "[4 JFK]",
                "[9 ORD]",
                "(5)",
                "[5 DEL]",
                "[6 LAX]",
                "(7)",
                "(7)",
                "[7 CDG]",
                "[16 SFO]",
                "(14)",
                "[14 ATL]",
                "[20 DFW]"), heap.listHeap());
        locators.put("PEK", heap.insert(8, "PEK"));
        locators.put("BOS", heap.insert(11, "BOS"));
        Assertions.assertEquals(4, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 10}",
                "{lev: 1 nodeCt: 5}",
                "(8)",
                "[8 PEK]",
                "[11 BOS]",
                "{lev: 2 nodeCt: 2}",
                "{lev: 3 nodeCt: 1}",
                "(4)",
                "(4)",
                "(4)",
                "[4 JFK]",
                "[9 ORD]",
                "(5)",
                "[5 DEL]",
                "[6 LAX]",
                "(7)",
                "(7)",
                "[7 CDG]",
                "[16 SFO]",
                "(14)",
                "[14 ATL]",
                "[20 DFW]"), heap.listHeap());
    }

}


