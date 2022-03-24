package cmsc420_s22_test;

import cmsc420_s22.QuakeHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

public class TestQuakeHeap2 {

    // Same as 1a test 4
    @Test
    void test2() {
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

}