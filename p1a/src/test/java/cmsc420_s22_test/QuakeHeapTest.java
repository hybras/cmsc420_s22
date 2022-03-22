package cmsc420_s22_test;

import cmsc420_s22.EmptyHeapException;
import cmsc420_s22.QuakeHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

// \"  (.+)\\n" \+

// regex to convert list heap
// (\{lev: \d+ nodeCt: \d+\}|\[\d+ .+\]|\(\d+\))
// replace with: "$1",

// Command to convert get max level
// rg "get-max-level\((.+)\): (\d+)" --replace='Assertions.assertEquals($2, heap.getMaxLevel(locators.get("$1")));' test01-expected.txt --no-line-number | clip

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

    @Test
    void test03() {
        var heap = new QuakeHeap<Integer, String>(5);
        var locators = new HashMap<String, QuakeHeap<Integer, String>.Locator>();
        Assertions.assertThrows(EmptyHeapException.class, heap::getMinKey);
        locators.put("BWI", heap.insert(88, "BWI"));
        locators.put("LAX", heap.insert(42, "LAX"));
        locators.put("IAD", heap.insert(26, "IAD"));
        locators.put("DCA", heap.insert(67, "DCA"));
        locators.put("JFK", heap.insert(94, "JFK"));
        locators.put("ATL", heap.insert(48, "ATL"));
        locators.put("SFO", heap.insert(19, "SFO"));
        Assertions.assertIterableEquals(List.of(
                "{lev: 0 nodeCt: 7}",
                "[19 SFO]",
                "[26 IAD]",
                "[42 LAX]",
                "[48 ATL]",
                "[67 DCA]",
                "[88 BWI]",
                "[94 JFK]"), heap.listHeap());
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("BWI")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("LAX")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("IAD")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("DCA")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("JFK")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("ATL")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("SFO")));
        Assertions.assertEquals(19, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of(
                "{lev: 0 nodeCt: 7}",
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
                "[48 ATL]"
        ), heap.listHeap());
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("BWI")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("LAX")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("IAD")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("DCA")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("JFK")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("ATL")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("SFO")));
        heap.clear();
        locators.clear();
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
        Assertions.assertIterableEquals(List.of(
                "{lev: 0 nodeCt: 11}",
                "[13 SEA]",
                "[19 SFO]",
                "[22 MIA]",
                "[26 IAD]",
                "[42 LAX]",
                "[48 ATL]",
                "[55 DFW]",
                "[67 DCA]",
                "[73 ORD]",
                "[88 BWI]",
                "[94 JFK]"
        ), heap.listHeap());
        Assertions.assertEquals(13, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 11}",
                "[94 JFK]",
                "{lev: 1 nodeCt: 5}",
                "(73)",
                "[73 ORD]",
                "[88 BWI]",
                "{lev: 2 nodeCt: 2}",
                "{lev: 3 nodeCt: 1}",
                "(13)",
                "(13)",
                "(13)",
                "[13 SEA]",
                "[19 SFO]",
                "(22)",
                "[22 MIA]",
                "[26 IAD]",
                "(42)",
                "(42)",
                "[42 LAX]",
                "[48 ATL]",
                "(55)",
                "[55 DFW]",
                "[67 DCA]"
        ), heap.listHeap());
        Assertions.assertEquals(3, heap.getMaxLevel(locators.get("SEA")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("BWI")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("JFK")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("LAX")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("DFW")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("ORD")));
    }

    @Test
    void test04() {
        var heap = new QuakeHeap<Integer, String>(5);
        var locators = new HashMap<String, QuakeHeap<Integer, String>.Locator>();

        locators.put("TMX", heap.insert(290, "TMX"));
        locators.put("NRD", heap.insert(535, "NRD"));
        locators.put("GWT", heap.insert(548, "GWT"));
        locators.put("TLL", heap.insert(5924, "TLL"));
        locators.put("ENF", heap.insert(6823, "ENF"));
        locators.put("KEV", heap.insert(6124, "KEV"));
        locators.put("HEM", heap.insert(6025, "HEM"));
        locators.put("HEL", heap.insert(6024, "HEL"));
        locators.put("BSK", heap.insert(345, "BSK"));
        locators.put("ELG", heap.insert(302, "ELG"));
        locators.put("HTN", heap.insert(3779, "HTN"));
        locators.put("URC", heap.insert(4387, "URC"));
        locators.put("HRB", heap.insert(45126, "HRB"));
        locators.put("DLC", heap.insert(38121, "DLC"));
        locators.put("NYI", heap.insert(72, "NYI"));
        Assertions.assertEquals(72, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of(
                "{lev: 0 nodeCt: 15}",
                "[45126 HRB]",
                "{lev: 1 nodeCt: 7}",
                "(6823)",
                "[6823 ENF]",
                "[38121 DLC]",
                "{lev: 2 nodeCt: 3}",
                "(5924)",
                "(5924)",
                "[5924 TLL]",
                "[6024 HEL]",
                "(6025)",
                "[6025 HEM]",
                "[6124 KEV]",
                "{lev: 3 nodeCt: 1}",
                "(72)",
                "(72)",
                "(72)",
                "[72 NYI]",
                "[290 TMX]",
                "(302)",
                "[302 ELG]",
                "[345 BSK]",
                "(535)",
                "(535)",
                "[535 NRD]",
                "[548 GWT]",
                "(3779)",
                "[3779 HTN]",
                "[4387 URC]"), heap.listHeap());

        locators.put("TKD", heap.insert(41, "TKD"));
        locators.put("ABJ", heap.insert(53, "ABJ"));
        locators.put("BYK", heap.insert(74, "BYK"));
        locators.put("DJO", heap.insert(66, "DJO"));
        locators.put("HGO", heap.insert(95, "HGO"));
        locators.put("MJC", heap.insert(77, "MJC"));
        locators.put("JYV", heap.insert(6225, "JYV"));
        locators.put("KAU", heap.insert(6323, "KAU"));
        locators.put("KEM", heap.insert(6524, "KEM"));
        locators.put("KAJ", heap.insert(6427, "KAJ"));
        locators.put("LDY", heap.insert(557, "LDY"));
        locators.put("BHX", heap.insert(520, "BHX"));
        locators.put("CVT", heap.insert(521, "CVT"));
        locators.put("BNI", heap.insert(65, "BNI"));
        locators.put("CBQ", heap.insert(48, "CBQ"));
        Assertions.assertEquals(41, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of(
                "{lev: 0 nodeCt: 30}",
                "{lev: 1 nodeCt: 15}",
                "(6823)",
                "[6823 ENF]",
                "[38121 DLC]",
                "{lev: 2 nodeCt: 7}",
                "(6323)",
                "(6323)",
                "[6323 KAU]",
                "[6427 KAJ]",
                "(6524)",
                "[6524 KEM]",
                "[45126 HRB]",
                "{lev: 3 nodeCt: 3}",
                "(520)",
                "(520)",
                "(520)",
                "[520 BHX]",
                "[521 CVT]",
                "(557)",
                "[557 LDY]",
                "[6225 JYV]",
                "(5924)",
                "(5924)",
                "[5924 TLL]",
                "[6024 HEL]",
                "(6025)",
                "[6025 HEM]",
                "[6124 KEV]",
                "{lev: 4 nodeCt: 1}",
                "(41)",
                "(41)",
                "(41)",
                "(41)",
                "[41 TKD]",
                "[48 CBQ]",
                "(53)",
                "[53 ABJ]",
                "[65 BNI]",
                "(66)",
                "(66)",
                "[66 DJO]",
                "[74 BYK]",
                "(77)",
                "[77 MJC]",
                "[95 HGO]",
                "(72)",
                "(72)",
                "(72)",
                "[72 NYI]",
                "[290 TMX]",
                "(302)",
                "[302 ELG]",
                "[345 BSK]",
                "(535)",
                "(535)",
                "[535 NRD]",
                "[548 GWT]",
                "(3779)",
                "[3779 HTN]",
                "[4387 URC]"), heap.listHeap());

        locators.put("ENU", heap.insert(67, "ENU"));
        locators.put("QUS", heap.insert(126, "QUS"));
        locators.put("DJE", heap.insert(3310, "DJE"));
        locators.put("EBM", heap.insert(319, "EBM"));
        locators.put("SFA", heap.insert(3410, "SFA"));
        locators.put("TOE", heap.insert(338, "TOE"));
        locators.put("LRL", heap.insert(91, "LRL"));
        locators.put("LFW", heap.insert(61, "LFW"));
        locators.put("HHN", heap.insert(497, "HHN"));
        locators.put("MHG", heap.insert(498, "MHG"));
        locators.put("XFW", heap.insert(539, "XFW"));
        locators.put("KEL", heap.insert(5410, "KEL"));
        locators.put("LBC", heap.insert(5310, "LBC"));
        locators.put("EME", heap.insert(537, "EME"));
        locators.put("WVN", heap.insert(538, "WVN"));
        Assertions.assertEquals(41, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of(
                "{lev: 0 nodeCt: 45}",
                "[5410 KEL]",
                "{lev: 1 nodeCt: 22}",
                "{lev: 2 nodeCt: 11}",
                "(6323)",
                "(6323)",
                "[6323 KAU]",
                "[6427 KAJ]",
                "(6524)",
                "[6524 KEM]",
                "[45126 HRB]",
                "{lev: 3 nodeCt: 5}",
                "(537)",
                "(537)",
                "(537)",
                "[537 EME]",
                "[538 WVN]",
                "(539)",
                "[539 XFW]",
                "[3310 DJE]",
                "(3410)",
                "(3410)",
                "[3410 SFA]",
                "[5310 LBC]",
                "(6823)",
                "[6823 ENF]",
                "[38121 DLC]",
                "{lev: 4 nodeCt: 2}",
                "(41)",
                "(41)",
                "(41)",
                "(41)",
                "[41 TKD]",
                "[48 CBQ]",
                "(53)",
                "[53 ABJ]",
                "[65 BNI]",
                "(66)",
                "(66)",
                "[66 DJO]",
                "[74 BYK]",
                "(77)",
                "[77 MJC]",
                "[95 HGO]",
                "(72)",
                "(72)",
                "(72)",
                "[72 NYI]",
                "[290 TMX]",
                "(302)",
                "[302 ELG]",
                "[345 BSK]",
                "(535)",
                "(535)",
                "[535 NRD]",
                "[548 GWT]",
                "(3779)",
                "[3779 HTN]",
                "[4387 URC]",
                "(61)",
                "(61)",
                "(61)",
                "(61)",
                "[61 LFW]",
                "[67 ENU]",
                "(91)",
                "[91 LRL]",
                "[126 QUS]",
                "(319)",
                "(319)",
                "[319 EBM]",
                "[338 TOE]",
                "(497)",
                "[497 HHN]",
                "[498 MHG]",
                "(520)",
                "(520)",
                "(520)",
                "[520 BHX]",
                "[521 CVT]",
                "(557)",
                "[557 LDY]",
                "[6225 JYV]",
                "(5924)",
                "(5924)",
                "[5924 TLL]",
                "[6024 HEL]",
                "(6025)",
                "[6025 HEM]",
                "[6124 KEV]"), heap.listHeap());

        locators.put("BMK", heap.insert(536, "BMK"));
        locators.put("ENA", heap.insert(60151, "ENA"));
        locators.put("FAI", heap.insert(64146, "FAI"));
        locators.put("FBK", heap.insert(64147, "FBK"));
        locators.put("GAL", heap.insert(64156, "GAL"));
        locators.put("GKN", heap.insert(62145, "GKN"));
        locators.put("SGY", heap.insert(59135, "SGY"));
        locators.put("HOM", heap.insert(59151, "HOM"));
        locators.put("ILI", heap.insert(59154, "ILI"));
        locators.put("UTO", heap.insert(65153, "UTO"));
        locators.put("NGB", heap.insert(29121, "NGB"));
        locators.put("NKG", heap.insert(31118, "NKG"));
        locators.put("HFE", heap.insert(31117, "HFE"));
        locators.put("TAO", heap.insert(36120, "TAO"));
        locators.put("SHA", heap.insert(31121, "SHA"));
        locators.put("YNT", heap.insert(37121, "YNT"));
        locators.put("CKG", heap.insert(29106, "CKG"));
        Assertions.assertEquals(41, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of(
                "{lev: 0 nodeCt: 62}",
                "{lev: 1 nodeCt: 31}",
                "(64156)",
                "[64156 GAL]",
                "[65153 UTO]",
                "{lev: 2 nodeCt: 15}",
                "(60151)",
                "(60151)",
                "[60151 ENA]",
                "[62145 GKN]",
                "(64146)",
                "[64146 FAI]",
                "[64147 FBK]",
                "{lev: 3 nodeCt: 7}",
                "(31117)",
                "(31117)",
                "(31117)",
                "[31117 HFE]",
                "[31118 NKG]",
                "(31121)",
                "[31121 SHA]",
                "[36120 TAO]",
                "(37121)",
                "(37121)",
                "[37121 YNT]",
                "[59135 SGY]",
                "(59151)",
                "[59151 HOM]",
                "[59154 ILI]",
                "{lev: 4 nodeCt: 3}",
                "(41)",
                "(41)",
                "(41)",
                "(41)",
                "[41 TKD]",
                "[48 CBQ]",
                "(53)",
                "[53 ABJ]",
                "[65 BNI]",
                "(66)",
                "(66)",
                "[66 DJO]",
                "[74 BYK]",
                "(77)",
                "[77 MJC]",
                "[95 HGO]",
                "(72)",
                "(72)",
                "(72)",
                "[72 NYI]",
                "[290 TMX]",
                "(302)",
                "[302 ELG]",
                "[345 BSK]",
                "(535)",
                "(535)",
                "[535 NRD]",
                "[548 GWT]",
                "(3779)",
                "[3779 HTN]",
                "[4387 URC]",
                "(61)",
                "(61)",
                "(61)",
                "(61)",
                "[61 LFW]",
                "[67 ENU]",
                "(91)",
                "[91 LRL]",
                "[126 QUS]",
                "(319)",
                "(319)",
                "[319 EBM]",
                "[338 TOE]",
                "(497)",
                "[497 HHN]",
                "[498 MHG]",
                "(520)",
                "(520)",
                "(520)",
                "[520 BHX]",
                "[521 CVT]",
                "(557)",
                "[557 LDY]",
                "[6225 JYV]",
                "(5924)",
                "(5924)",
                "[5924 TLL]",
                "[6024 HEL]",
                "(6025)",
                "[6025 HEM]",
                "[6124 KEV]",
                "(536)",
                "(536)",
                "(536)",
                "(536)",
                "[536 BMK]",
                "[5410 KEL]",
                "(29106)",
                "[29106 CKG]",
                "[29121 NGB]",
                "(6323)",
                "(6323)",
                "[6323 KAU]",
                "[6427 KAJ]",
                "(6524)",
                "[6524 KEM]",
                "[45126 HRB]",
                "(537)",
                "(537)",
                "(537)",
                "[537 EME]",
                "[538 WVN]",
                "(539)",
                "[539 XFW]",
                "[3310 DJE]",
                "(3410)",
                "(3410)",
                "[3410 SFA]",
                "[5310 LBC]",
                "(6823)",
                "[6823 ENF]",
                "[38121 DLC]"), heap.listHeap());
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("TMX")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("NRD")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("GWT")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("TLL")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("ENF")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("KEV")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("HEM")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("HEL")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("BSK")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("ELG")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("HTN")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("URC")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("HRB")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("DLC")));
        Assertions.assertEquals(3, heap.getMaxLevel(locators.get("NYI")));
        Assertions.assertEquals(4, heap.getMaxLevel(locators.get("TKD")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("ABJ")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("BYK")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("DJO")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("HGO")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("MJC")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("JYV")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("KAU")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("KEM")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("KAJ")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("LDY")));
        Assertions.assertEquals(3, heap.getMaxLevel(locators.get("BHX")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("CVT")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("BNI")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("CBQ")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("ENU")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("QUS")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("DJE")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("EBM")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("SFA")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("TOE")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("LRL")));
        Assertions.assertEquals(4, heap.getMaxLevel(locators.get("LFW")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("HHN")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("MHG")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("XFW")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("KEL")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("LBC")));
        Assertions.assertEquals(3, heap.getMaxLevel(locators.get("EME")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("WVN")));
        Assertions.assertEquals(4, heap.getMaxLevel(locators.get("BMK")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("ENA")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("FAI")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("FBK")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("GAL")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("GKN")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("SGY")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("HOM")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("ILI")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("UTO")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("NGB")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("NKG")));
        Assertions.assertEquals(3, heap.getMaxLevel(locators.get("HFE")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("TAO")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("SHA")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("YNT")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("CKG")));

        Assertions.assertEquals(41, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of(
                "{lev: 0 nodeCt: 62}",
                "{lev: 1 nodeCt: 31}",
                "(64156)",
                "[64156 GAL]",
                "[65153 UTO]",
                "{lev: 2 nodeCt: 15}",
                "(60151)",
                "(60151)",
                "[60151 ENA]",
                "[62145 GKN]",
                "(64146)",
                "[64146 FAI]",
                "[64147 FBK]",
                "{lev: 3 nodeCt: 7}",
                "(31117)",
                "(31117)",
                "(31117)",
                "[31117 HFE]",
                "[31118 NKG]",
                "(31121)",
                "[31121 SHA]",
                "[36120 TAO]",
                "(37121)",
                "(37121)",
                "[37121 YNT]",
                "[59135 SGY]",
                "(59151)",
                "[59151 HOM]",
                "[59154 ILI]",
                "{lev: 4 nodeCt: 3}",
                "(41)",
                "(41)",
                "(41)",
                "(41)",
                "[41 TKD]",
                "[48 CBQ]",
                "(53)",
                "[53 ABJ]",
                "[65 BNI]",
                "(66)",
                "(66)",
                "[66 DJO]",
                "[74 BYK]",
                "(77)",
                "[77 MJC]",
                "[95 HGO]",
                "(72)",
                "(72)",
                "(72)",
                "[72 NYI]",
                "[290 TMX]",
                "(302)",
                "[302 ELG]",
                "[345 BSK]",
                "(535)",
                "(535)",
                "[535 NRD]",
                "[548 GWT]",
                "(3779)",
                "[3779 HTN]",
                "[4387 URC]",
                "(61)",
                "(61)",
                "(61)",
                "(61)",
                "[61 LFW]",
                "[67 ENU]",
                "(91)",
                "[91 LRL]",
                "[126 QUS]",
                "(319)",
                "(319)",
                "[319 EBM]",
                "[338 TOE]",
                "(497)",
                "[497 HHN]",
                "[498 MHG]",
                "(520)",
                "(520)",
                "(520)",
                "[520 BHX]",
                "[521 CVT]",
                "(557)",
                "[557 LDY]",
                "[6225 JYV]",
                "(5924)",
                "(5924)",
                "[5924 TLL]",
                "[6024 HEL]",
                "(6025)",
                "[6025 HEM]",
                "[6124 KEV]",
                "(536)",
                "(536)",
                "(536)",
                "(536)",
                "[536 BMK]",
                "[5410 KEL]",
                "(29106)",
                "[29106 CKG]",
                "[29121 NGB]",
                "(6323)",
                "(6323)",
                "[6323 KAU]",
                "[6427 KAJ]",
                "(6524)",
                "[6524 KEM]",
                "[45126 HRB]",
                "(537)",
                "(537)",
                "(537)",
                "[537 EME]",
                "[538 WVN]",
                "(539)",
                "[539 XFW]",
                "[3310 DJE]",
                "(3410)",
                "(3410)",
                "[3410 SFA]",
                "[5310 LBC]",
                "(6823)",
                "[6823 ENF]",
                "[38121 DLC]"), heap.listHeap());
    }

    @Test
    void test05() {
        var heap = new QuakeHeap<Integer, String>(8);
        var locators = new HashMap<String, QuakeHeap<Integer, String>.Locator>();
        locators.put("TMX", heap.insert(290, "TMX"));
        locators.put("NRD", heap.insert(535, "NRD"));
        locators.put("GWT", heap.insert(548, "GWT"));
        locators.put("TLL", heap.insert(5924, "TLL"));
        locators.put("ENF", heap.insert(6823, "ENF"));
        locators.put("KEV", heap.insert(6124, "KEV"));
        locators.put("HEM", heap.insert(6025, "HEM"));
        locators.put("HEL", heap.insert(6024, "HEL"));
        locators.put("BSK", heap.insert(345, "BSK"));
        locators.put("ELG", heap.insert(302, "ELG"));
        locators.put("HTN", heap.insert(3779, "HTN"));
        locators.put("URC", heap.insert(4387, "URC"));
        locators.put("HRB", heap.insert(45126, "HRB"));
        locators.put("DLC", heap.insert(38121, "DLC"));
        locators.put("NYI", heap.insert(72, "NYI"));
        Assertions.assertEquals(72, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of(
                "{lev: 0 nodeCt: 15}",
                "[45126 HRB]",
                "{lev: 1 nodeCt: 7}",
                "(6823)",
                "[6823 ENF]",
                "[38121 DLC]",
                "{lev: 2 nodeCt: 3}",
                "(5924)",
                "(5924)",
                "[5924 TLL]",
                "[6024 HEL]",
                "(6025)",
                "[6025 HEM]",
                "[6124 KEV]",
                "{lev: 3 nodeCt: 1}",
                "(72)",
                "(72)",
                "(72)",
                "[72 NYI]",
                "[290 TMX]",
                "(302)",
                "[302 ELG]",
                "[345 BSK]",
                "(535)",
                "(535)",
                "[535 NRD]",
                "[548 GWT]",
                "(3779)",
                "[3779 HTN]",
                "[4387 URC]"
        ), heap.listHeap());
        locators.put("TKD", heap.insert(41, "TKD"));
        locators.put("ABJ", heap.insert(53, "ABJ"));
        locators.put("BYK", heap.insert(74, "BYK"));
        locators.put("DJO", heap.insert(66, "DJO"));
        locators.put("HGO", heap.insert(95, "HGO"));
        locators.put("MJC", heap.insert(77, "MJC"));
        locators.put("JYV", heap.insert(6225, "JYV"));
        locators.put("KAU", heap.insert(6323, "KAU"));
        locators.put("KEM", heap.insert(6524, "KEM"));
        locators.put("KAJ", heap.insert(6427, "KAJ"));
        locators.put("LDY", heap.insert(557, "LDY"));
        locators.put("BHX", heap.insert(520, "BHX"));
        locators.put("CVT", heap.insert(521, "CVT"));
        locators.put("BNI", heap.insert(65, "BNI"));
        locators.put("CBQ", heap.insert(48, "CBQ"));
        Assertions.assertEquals(41, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 30}",
                "{lev: 1 nodeCt: 15}",
                "(6823)",
                "[6823 ENF]",
                "[38121 DLC]",
                "{lev: 2 nodeCt: 7}",
                "(6323)",
                "(6323)",
                "[6323 KAU]",
                "[6427 KAJ]",
                "(6524)",
                "[6524 KEM]",
                "[45126 HRB]",
                "{lev: 3 nodeCt: 3}",
                "(520)",
                "(520)",
                "(520)",
                "[520 BHX]",
                "[521 CVT]",
                "(557)",
                "[557 LDY]",
                "[6225 JYV]",
                "(5924)",
                "(5924)",
                "[5924 TLL]",
                "[6024 HEL]",
                "(6025)",
                "[6025 HEM]",
                "[6124 KEV]",
                "{lev: 4 nodeCt: 1}",
                "(41)",
                "(41)",
                "(41)",
                "(41)",
                "[41 TKD]",
                "[48 CBQ]",
                "(53)",
                "[53 ABJ]",
                "[65 BNI]",
                "(66)",
                "(66)",
                "[66 DJO]",
                "[74 BYK]",
                "(77)",
                "[77 MJC]",
                "[95 HGO]",
                "(72)",
                "(72)",
                "(72)",
                "[72 NYI]",
                "[290 TMX]",
                "(302)",
                "[302 ELG]",
                "[345 BSK]",
                "(535)",
                "(535)",
                "[535 NRD]",
                "[548 GWT]",
                "(3779)",
                "[3779 HTN]",
                "[4387 URC]"), heap.listHeap());
        locators.put("ENU", heap.insert(67, "ENU"));
        locators.put("QUS", heap.insert(126, "QUS"));
        locators.put("DJE", heap.insert(3310, "DJE"));
        locators.put("EBM", heap.insert(319, "EBM"));
        locators.put("SFA", heap.insert(3410, "SFA"));
        locators.put("TOE", heap.insert(338, "TOE"));
        locators.put("LRL", heap.insert(91, "LRL"));
        locators.put("LFW", heap.insert(61, "LFW"));
        locators.put("HHN", heap.insert(497, "HHN"));
        locators.put("MHG", heap.insert(498, "MHG"));
        locators.put("XFW", heap.insert(539, "XFW"));
        locators.put("KEL", heap.insert(5410, "KEL"));
        locators.put("LBC", heap.insert(5310, "LBC"));
        locators.put("EME", heap.insert(537, "EME"));
        locators.put("WVN", heap.insert(538, "WVN"));
        Assertions.assertEquals(41, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of(
                "{lev: 0 nodeCt: 45}",
                "[5410 KEL]",
                "{lev: 1 nodeCt: 22}",
                "{lev: 2 nodeCt: 11}",
                "(6323)",
                "(6323)",
                "[6323 KAU]",
                "[6427 KAJ]",
                "(6524)",
                "[6524 KEM]",
                "[45126 HRB]",
                "{lev: 3 nodeCt: 5}",
                "(537)",
                "(537)",
                "(537)",
                "[537 EME]",
                "[538 WVN]",
                "(539)",
                "[539 XFW]",
                "[3310 DJE]",
                "(3410)",
                "(3410)",
                "[3410 SFA]",
                "[5310 LBC]",
                "(6823)",
                "[6823 ENF]",
                "[38121 DLC]",
                "{lev: 4 nodeCt: 2}",
                "{lev: 5 nodeCt: 1}",
                "(41)",
                "(41)",
                "(41)",
                "(41)",
                "(41)",
                "[41 TKD]",
                "[48 CBQ]",
                "(53)",
                "[53 ABJ]",
                "[65 BNI]",
                "(66)",
                "(66)",
                "[66 DJO]",
                "[74 BYK]",
                "(77)",
                "[77 MJC]",
                "[95 HGO]",
                "(72)",
                "(72)",
                "(72)",
                "[72 NYI]",
                "[290 TMX]",
                "(302)",
                "[302 ELG]",
                "[345 BSK]",
                "(535)",
                "(535)",
                "[535 NRD]",
                "[548 GWT]",
                "(3779)",
                "[3779 HTN]",
                "[4387 URC]",
                "(61)",
                "(61)",
                "(61)",
                "(61)",
                "[61 LFW]",
                "[67 ENU]",
                "(91)",
                "[91 LRL]",
                "[126 QUS]",
                "(319)",
                "(319)",
                "[319 EBM]",
                "[338 TOE]",
                "(497)",
                "[497 HHN]",
                "[498 MHG]",
                "(520)",
                "(520)",
                "(520)",
                "[520 BHX]",
                "[521 CVT]",
                "(557)",
                "[557 LDY]",
                "[6225 JYV]",
                "(5924)",
                "(5924)",
                "[5924 TLL]",
                "[6024 HEL]",
                "(6025)",
                "[6025 HEM]",
                "[6124 KEV]"
        ), heap.listHeap());
        locators.put("BMK", heap.insert(536, "BMK"));
        locators.put("ENA", heap.insert(60151, "ENA"));
        locators.put("FAI", heap.insert(64146, "FAI"));
        locators.put("FBK", heap.insert(64147, "FBK"));
        locators.put("GAL", heap.insert(64156, "GAL"));
        locators.put("GKN", heap.insert(62145, "GKN"));
        locators.put("SGY", heap.insert(59135, "SGY"));
        locators.put("HOM", heap.insert(59151, "HOM"));
        locators.put("ILI", heap.insert(59154, "ILI"));
        locators.put("UTO", heap.insert(65153, "UTO"));
        locators.put("NGB", heap.insert(29121, "NGB"));
        locators.put("NKG", heap.insert(31118, "NKG"));
        locators.put("HFE", heap.insert(31117, "HFE"));
        locators.put("TAO", heap.insert(36120, "TAO"));
        locators.put("SHA", heap.insert(31121, "SHA"));
        locators.put("YNT", heap.insert(37121, "YNT"));
        locators.put("CKG", heap.insert(29106, "CKG"));
        locators.put("CTU", heap.insert(30103, "CTU"));
        locators.put("HME", heap.insert(316, "HME"));
        locators.put("INZ", heap.insert(272, "INZ"));
        locators.put("YEV", heap.insert(68133, "YEV"));
        locators.put("YFB", heap.insert(6368, "YFB"));
        locators.put("YFC", heap.insert(4566, "YFC"));
        locators.put("IVL", heap.insert(6827, "IVL"));
        locators.put("JOE", heap.insert(6229, "JOE"));
        locators.put("GKA", heap.insert(6145, "GKA"));
        locators.put("MAG", heap.insert(5145, "MAG"));
        locators.put("HGU", heap.insert(5144, "HGU"));
        locators.put("LAE", heap.insert(6146, "LAE"));
        locators.put("POM", heap.insert(9147, "POM"));
        locators.put("WWK", heap.insert(3143, "WWK"));
        locators.put("VEY", heap.insert(6320, "VEY"));
        locators.put("YAM", heap.insert(4684, "YAM"));
        locators.put("YAV", heap.insert(5097, "YAV"));
        locators.put("YAW", heap.insert(4462, "YAW"));
        locators.put("YAY", heap.insert(5156, "YAY"));
        locators.put("YAZ", heap.insert(49125, "YAZ"));
        locators.put("YBB", heap.insert(6889, "YBB"));
        locators.put("YDQ", heap.insert(55120, "YDQ"));
        locators.put("GHA", heap.insert(322, "GHA"));
        locators.put("PKO", heap.insert(92, "PKO"));
        locators.put("OUA", heap.insert(121, "OUA"));
        locators.put("BOY", heap.insert(114, "BOY"));
        locators.put("ACC", heap.insert(50, "ACC"));
        Assertions.assertEquals(41, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of(
                "{lev: 0 nodeCt: 89}",
                "[68133 YEV]",
                "{lev: 1 nodeCt: 44}",
                "{lev: 2 nodeCt: 22}",
                "{lev: 3 nodeCt: 11}",
                "(59151)",
                "(59151)",
                "(59151)",
                "[59151 HOM]",
                "[59154 ILI]",
                "(60151)",
                "[60151 ENA]",
                "[62145 GKN]",
                "(64146)",
                "(64146)",
                "[64146 FAI]",
                "[64147 FBK]",
                "(64156)",
                "[64156 GAL]",
                "[65153 UTO]",
                "{lev: 4 nodeCt: 5}",
                "(6323)",
                "(6323)",
                "(6323)",
                "(6323)",
                "[6323 KAU]",
                "[6427 KAJ]",
                "(6524)",
                "[6524 KEM]",
                "[45126 HRB]",
                "(9147)",
                "(9147)",
                "[9147 POM]",
                "[29106 CKG]",
                "(29121)",
                "[29121 NGB]",
                "[30103 CTU]",
                "(31117)",
                "(31117)",
                "(31117)",
                "[31117 HFE]",
                "[31118 NKG]",
                "(31121)",
                "[31121 SHA]",
                "[36120 TAO]",
                "(37121)",
                "(37121)",
                "[37121 YNT]",
                "[49125 YAZ]",
                "(55120)",
                "[55120 YDQ]",
                "[59135 SGY]",
                "{lev: 5 nodeCt: 2}",
                "{lev: 6 nodeCt: 1}",
                "(41)",
                "(41)",
                "(41)",
                "(41)",
                "(41)",
                "(41)",
                "[41 TKD]",
                "[48 CBQ]",
                "(53)",
                "[53 ABJ]",
                "[65 BNI]",
                "(66)",
                "(66)",
                "[66 DJO]",
                "[74 BYK]",
                "(77)",
                "[77 MJC]",
                "[95 HGO]",
                "(72)",
                "(72)",
                "(72)",
                "[72 NYI]",
                "[290 TMX]",
                "(302)",
                "[302 ELG]",
                "[345 BSK]",
                "(535)",
                "(535)",
                "[535 NRD]",
                "[548 GWT]",
                "(3779)",
                "[3779 HTN]",
                "[4387 URC]",
                "(61)",
                "(61)",
                "(61)",
                "(61)",
                "[61 LFW]",
                "[67 ENU]",
                "(91)",
                "[91 LRL]",
                "[126 QUS]",
                "(319)",
                "(319)",
                "[319 EBM]",
                "[338 TOE]",
                "(497)",
                "[497 HHN]",
                "[498 MHG]",
                "(520)",
                "(520)",
                "(520)",
                "[520 BHX]",
                "[521 CVT]",
                "(557)",
                "[557 LDY]",
                "[6225 JYV]",
                "(5924)",
                "(5924)",
                "[5924 TLL]",
                "[6024 HEL]",
                "(6025)",
                "[6025 HEM]",
                "[6124 KEV]",
                "(50)",
                "(50)",
                "(50)",
                "(50)",
                "(50)",
                "[50 ACC]",
                "[92 PKO]",
                "(114)",
                "[114 BOY]",
                "[121 OUA]",
                "(272)",
                "(272)",
                "[272 INZ]",
                "[316 HME]",
                "(322)",
                "[322 GHA]",
                "[536 BMK]",
                "(537)",
                "(537)",
                "(537)",
                "[537 EME]",
                "[538 WVN]",
                "(539)",
                "[539 XFW]",
                "[3310 DJE]",
                "(3410)",
                "(3410)",
                "[3410 SFA]",
                "[5310 LBC]",
                "(6823)",
                "[6823 ENF]",
                "[38121 DLC]",
                "(3143)",
                "(3143)",
                "(3143)",
                "(3143)",
                "[3143 WWK]",
                "[4462 YAW]",
                "(4566)",
                "[4566 YFC]",
                "[4684 YAM]",
                "(5097)",
                "(5097)",
                "[5097 YAV]",
                "[5144 HGU]",
                "(5145)",
                "[5145 MAG]",
                "[5156 YAY]",
                "(5410)",
                "(5410)",
                "(5410)",
                "[5410 KEL]",
                "[6145 GKA]",
                "(6146)",
                "[6146 LAE]",
                "[6229 JOE]",
                "(6320)",
                "(6320)",
                "[6320 VEY]",
                "[6368 YFB]",
                "(6827)",
                "[6827 IVL]",
                "[6889 YBB]"
        ), heap.listHeap());
        locators.put("TML", heap.insert(90, "TML"));
        locators.put("GLO", heap.insert(512, "GLO"));
        locators.put("OGX", heap.insert(315, "OGX"));
        locators.put("IAM", heap.insert(289, "IAM"));
        locators.put("COO", heap.insert(62, "COO"));
        locators.put("TLM", heap.insert(354, "TLM"));
        locators.put("ORN", heap.insert(350, "ORN"));
        locators.put("MUW", heap.insert(352, "MUW"));
        locators.put("AZR", heap.insert(270, "AZR"));
        locators.put("TGR", heap.insert(336, "TGR"));
        locators.put("LOO", heap.insert(332, "LOO"));
        locators.put("XIC", heap.insert(27102, "XIC"));
        locators.put("KHG", heap.insert(3976, "KHG"));
        locators.put("QAS", heap.insert(361, "QAS"));
        locators.put("TAF", heap.insert(353, "TAF"));
        locators.put("YFO", heap.insert(54101, "YFO"));
        locators.put("YHM", heap.insert(4379, "YHM"));
        locators.put("YHU", heap.insert(4572, "YHU"));
        locators.put("YHY", heap.insert(60115, "YHY"));
        locators.put("YHZ", heap.insert(4463, "YHZ"));
        locators.put("YIB", heap.insert(4891, "YIB"));
        locators.put("YIO", heap.insert(7277, "YIO"));
        locators.put("YJN", heap.insert(4573, "YJN"));
        locators.put("YND", heap.insert(4574, "YND"));
        locators.put("YNM", heap.insert(4977, "YNM"));
        locators.put("YOC", heap.insert(67139, "YOC"));
        locators.put("YOD", heap.insert(54110, "YOD"));
        locators.put("YOJ", heap.insert(58117, "YOJ"));
        locators.put("YOW", heap.insert(4575, "YOW"));
        locators.put("YRM", heap.insert(52114, "YRM"));
        locators.put("YRT", heap.insert(6292, "YRT"));
        locators.put("YSB", heap.insert(4680, "YSB"));
        locators.put("YSC", heap.insert(4571, "YSC"));
        locators.put("YSJ", heap.insert(4565, "YSJ"));
        locators.put("YWA", heap.insert(4577, "YWA"));
        locators.put("YED", heap.insert(53112, "YED"));
        locators.put("YEG", heap.insert(53113, "YEG"));
        locators.put("YEK", heap.insert(6194, "YEK"));
        locators.put("YEN", heap.insert(49102, "YEN"));
        locators.put("YET", heap.insert(53116, "YET"));
        locators.put("YEU", heap.insert(7985, "YEU"));
        locators.put("YWG", heap.insert(4997, "YWG"));
        locators.put("YWK", heap.insert(5266, "YWK"));
        locators.put("YWL", heap.insert(52122, "YWL"));
        locators.put("YWY", heap.insert(63123, "YWY"));
        locators.put("YXC", heap.insert(49115, "YXC"));
        locators.put("YYU", heap.insert(4982, "YYU"));
        locators.put("SPY", heap.insert(46, "SPY"));
        locators.put("ASK", heap.insert(64, "ASK"));
        locators.put("ABV", heap.insert(97, "ABV"));
        locators.put("AKR", heap.insert(75, "AKR"));
        locators.put("YYW", heap.insert(5088, "YYW"));
        locators.put("YYY", heap.insert(4868, "YYY"));
        locators.put("YYZ", heap.insert(4378, "YYZ"));
        locators.put("YZD", heap.insert(4377, "YZD"));
        locators.put("CZL", heap.insert(366, "CZL"));
        locators.put("TEE", heap.insert(358, "TEE"));
        locators.put("HRM", heap.insert(323, "HRM"));
        locators.put("TID", heap.insert(355, "TID"));
        locators.put("TIN", heap.insert(27, "TIN"));
        locators.put("LXA", heap.insert(7, "LXA"));
        Assertions.assertEquals(7, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 150}",
                "{lev: 1 nodeCt: 75}",
                "(67139)",
                "[67139 YOC]",
                "[68133 YEV]",
                "{lev: 2 nodeCt: 37}",
                "(54110)",
                "(54110)",
                "[54110 YOD]",
                "[58117 YOJ]",
                "(60115)",
                "[60115 YHY]",
                "[63123 YWY]",
                "{lev: 3 nodeCt: 18}",
                "{lev: 4 nodeCt: 9}",
                "(49102)",
                "(49102)",
                "(49102)",
                "(49102)",
                "[49102 YEN]",
                "[49115 YXC]",
                "(52114)",
                "[52114 YRM]",
                "[52122 YWL]",
                "(53112)",
                "(53112)",
                "[53112 YED]",
                "[53113 YEG]",
                "(53116)",
                "[53116 YET]",
                "[54101 YFO]",
                "(59151)",
                "(59151)",
                "(59151)",
                "[59151 HOM]",
                "[59154 ILI]",
                "(60151)",
                "[60151 ENA]",
                "[62145 GKN]",
                "(64146)",
                "(64146)",
                "[64146 FAI]",
                "[64147 FBK]",
                "(64156)",
                "[64156 GAL]",
                "[65153 UTO]",
                "{lev: 5 nodeCt: 4}",
                "{lev: 6 nodeCt: 2}",
                "{lev: 7 nodeCt: 1}",
                "(7)",
                "(7)",
                "(7)",
                "(7)",
                "(7)",
                "(7)",
                "(7)",
                "[7 LXA]",
                "[27 TIN]",
                "(46)",
                "[46 SPY]",
                "[62 COO]",
                "(64)",
                "(64)",
                "[64 ASK]",
                "[75 AKR]",
                "(90)",
                "[90 TML]",
                "[97 ABV]",
                "(270)",
                "(270)",
                "(270)",
                "[270 AZR]",
                "[289 IAM]",
                "(315)",
                "[315 OGX]",
                "[323 HRM]",
                "(332)",
                "(332)",
                "[332 LOO]",
                "[336 TGR]",
                "(350)",
                "[350 ORN]",
                "[352 MUW]",
                "(353)",
                "(353)",
                "(353)",
                "(353)",
                "[353 TAF]",
                "[354 TLM]",
                "(355)",
                "[355 TID]",
                "[358 TEE]",
                "(361)",
                "(361)",
                "[361 QAS]",
                "[366 CZL]",
                "(512)",
                "[512 GLO]",
                "[3976 KHG]",
                "(4377)",
                "(4377)",
                "(4377)",
                "[4377 YZD]",
                "[4378 YYZ]",
                "(4379)",
                "[4379 YHM]",
                "[4463 YHZ]",
                "(4565)",
                "(4565)",
                "[4565 YSJ]",
                "[4571 YSC]",
                "(4572)",
                "[4572 YHU]",
                "[4573 YJN]",
                "(4574)",
                "(4574)",
                "(4574)",
                "(4574)",
                "(4574)",
                "[4574 YND]",
                "[4575 YOW]",
                "(4577)",
                "[4577 YWA]",
                "[4680 YSB]",
                "(4868)",
                "(4868)",
                "[4868 YYY]",
                "[4891 YIB]",
                "(4977)",
                "[4977 YNM]",
                "[4982 YYU]",
                "(4997)",
                "(4997)",
                "(4997)",
                "[4997 YWG]",
                "[5088 YYW]",
                "(5266)",
                "[5266 YWK]",
                "[6194 YEK]",
                "(6292)",
                "(6292)",
                "[6292 YRT]",
                "[7277 YIO]",
                "(7985)",
                "[7985 YEU]",
                "[27102 XIC]",
                "(6323)",
                "(6323)",
                "(6323)",
                "(6323)",
                "[6323 KAU]",
                "[6427 KAJ]",
                "(6524)",
                "[6524 KEM]",
                "[45126 HRB]",
                "(9147)",
                "(9147)",
                "[9147 POM]",
                "[29106 CKG]",
                "(29121)",
                "[29121 NGB]",
                "[30103 CTU]",
                "(31117)",
                "(31117)",
                "(31117)",
                "[31117 HFE]",
                "[31118 NKG]",
                "(31121)",
                "[31121 SHA]",
                "[36120 TAO]",
                "(37121)",
                "(37121)",
                "[37121 YNT]",
                "[49125 YAZ]",
                "(55120)",
                "[55120 YDQ]",
                "[59135 SGY]",
                "(41)",
                "(41)",
                "(41)",
                "(41)",
                "(41)",
                "(41)",
                "[41 TKD]",
                "[48 CBQ]",
                "(53)",
                "[53 ABJ]",
                "[65 BNI]",
                "(66)",
                "(66)",
                "[66 DJO]",
                "[74 BYK]",
                "(77)",
                "[77 MJC]",
                "[95 HGO]",
                "(72)",
                "(72)",
                "(72)",
                "[72 NYI]",
                "[290 TMX]",
                "(302)",
                "[302 ELG]",
                "[345 BSK]",
                "(535)",
                "(535)",
                "[535 NRD]",
                "[548 GWT]",
                "(3779)",
                "[3779 HTN]",
                "[4387 URC]",
                "(61)",
                "(61)",
                "(61)",
                "(61)",
                "[61 LFW]",
                "[67 ENU]",
                "(91)",
                "[91 LRL]",
                "[126 QUS]",
                "(319)",
                "(319)",
                "[319 EBM]",
                "[338 TOE]",
                "(497)",
                "[497 HHN]",
                "[498 MHG]",
                "(520)",
                "(520)",
                "(520)",
                "[520 BHX]",
                "[521 CVT]",
                "(557)",
                "[557 LDY]",
                "[6225 JYV]",
                "(5924)",
                "(5924)",
                "[5924 TLL]",
                "[6024 HEL]",
                "(6025)",
                "[6025 HEM]",
                "[6124 KEV]",
                "(50)",
                "(50)",
                "(50)",
                "(50)",
                "(50)",
                "[50 ACC]",
                "[92 PKO]",
                "(114)",
                "[114 BOY]",
                "[121 OUA]",
                "(272)",
                "(272)",
                "[272 INZ]",
                "[316 HME]",
                "(322)",
                "[322 GHA]",
                "[536 BMK]",
                "(537)",
                "(537)",
                "(537)",
                "[537 EME]",
                "[538 WVN]",
                "(539)",
                "[539 XFW]",
                "[3310 DJE]",
                "(3410)",
                "(3410)",
                "[3410 SFA]",
                "[5310 LBC]",
                "(6823)",
                "[6823 ENF]",
                "[38121 DLC]",
                "(3143)",
                "(3143)",
                "(3143)",
                "(3143)",
                "[3143 WWK]",
                "[4462 YAW]",
                "(4566)",
                "[4566 YFC]",
                "[4684 YAM]",
                "(5097)",
                "(5097)",
                "[5097 YAV]",
                "[5144 HGU]",
                "(5145)",
                "[5145 MAG]",
                "[5156 YAY]",
                "(5410)",
                "(5410)",
                "(5410)",
                "[5410 KEL]",
                "[6145 GKA]",
                "(6146)",
                "[6146 LAE]",
                "[6229 JOE]",
                "(6320)",
                "(6320)",
                "[6320 VEY]",
                "[6368 YFB]",
                "(6827)",
                "[6827 IVL]",
                "[6889 YBB]"
        ), heap.listHeap());
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("TMX")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("NRD")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("GWT")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("TLL")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("ENF")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("KEV")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("HEM")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("HEL")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("BSK")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("ELG")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("HTN")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("URC")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("HRB")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("DLC")));
        Assertions.assertEquals(3, heap.getMaxLevel(locators.get("NYI")));
        Assertions.assertEquals(6, heap.getMaxLevel(locators.get("TKD")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("ABJ")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("BYK")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("DJO")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("HGO")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("MJC")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("JYV")));
        Assertions.assertEquals(4, heap.getMaxLevel(locators.get("KAU")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("KEM")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("KAJ")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("LDY")));
        Assertions.assertEquals(3, heap.getMaxLevel(locators.get("BHX")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("CVT")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("BNI")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("CBQ")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("ENU")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("QUS")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("DJE")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("EBM")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("SFA")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("TOE")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("LRL")));
        Assertions.assertEquals(4, heap.getMaxLevel(locators.get("LFW")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("HHN")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("MHG")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("XFW")));
        Assertions.assertEquals(3, heap.getMaxLevel(locators.get("KEL")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("LBC")));
        Assertions.assertEquals(3, heap.getMaxLevel(locators.get("EME")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("WVN")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("BMK")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("ENA")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("FAI")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("FBK")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("GAL")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("GKN")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("SGY")));
        Assertions.assertEquals(3, heap.getMaxLevel(locators.get("HOM")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("ILI")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("UTO")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("NGB")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("NKG")));
        Assertions.assertEquals(3, heap.getMaxLevel(locators.get("HFE")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("TAO")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("SHA")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("YNT")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("CKG")));
        Assertions.assertEquals(7, heap.getMaxLevel(locators.get("LXA")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("CTU")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("HME")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("INZ")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YEV")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YFB")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("YFC")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("IVL")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("JOE")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("GKA")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("MAG")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("HGU")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("LAE")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("POM")));
        Assertions.assertEquals(4, heap.getMaxLevel(locators.get("WWK")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("VEY")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YAM")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("YAV")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YAW")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YAY")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YAZ")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YBB")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("YDQ")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("GHA")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("PKO")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("OUA")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("BOY")));
        Assertions.assertEquals(5, heap.getMaxLevel(locators.get("ACC")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("TML")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("GLO")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("OGX")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("IAM")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("COO")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("TLM")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("ORN")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("MUW")));
        Assertions.assertEquals(3, heap.getMaxLevel(locators.get("AZR")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("TGR")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("LOO")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("XIC")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("KHG")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("QAS")));
        Assertions.assertEquals(4, heap.getMaxLevel(locators.get("TAF")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YFO")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("YHM")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("YHU")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("YHY")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YHZ")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YIB")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YIO")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YJN")));
        Assertions.assertEquals(5, heap.getMaxLevel(locators.get("YND")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("YNM")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("YOC")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("YOD")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YOJ")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YOW")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("YRM")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("YRT")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YSB")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YSC")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("YSJ")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("YWA")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("YED")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YEG")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YEK")));
        Assertions.assertEquals(4, heap.getMaxLevel(locators.get("YEN")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("YET")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("YEU")));
        Assertions.assertEquals(3, heap.getMaxLevel(locators.get("YWG")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("YWK")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YWL")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YWY")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YXC")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YYU")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("SPY")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("ASK")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("ABV")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("AKR")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YYW")));
        Assertions.assertEquals(2, heap.getMaxLevel(locators.get("YYY")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("YYZ")));
        Assertions.assertEquals(3, heap.getMaxLevel(locators.get("YZD")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("CZL")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("TEE")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("HRM")));
        Assertions.assertEquals(1, heap.getMaxLevel(locators.get("TID")));
        Assertions.assertEquals(0, heap.getMaxLevel(locators.get("TIN")));
    }

}


