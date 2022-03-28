package cmsc420_s22_test;

import cmsc420_s22.QuakeHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

public class TestQuakeHeap9 {
    @Test
    void test09() {
        // This test involves 64 entries and lots of extract-mins
        var heap = new QuakeHeap<Integer, String>(8);
        var locators = new HashMap<String, QuakeHeap<Integer, String>.Locator>();
        heap.setQuakeRatio(0.650000);
        locators.put("PNS", heap.insert(426127, "PNS"));
        locators.put("POB", heap.insert(508233, "POB"));
        locators.put("POE", heap.insert(369149, "POE"));
        locators.put("PQI", heap.insert(617448, "PQI"));
        locators.put("PRC", heap.insert(180208, "PRC"));
        locators.put("PSP", heap.insert(135192, "PSP"));
        locators.put("PSX", heap.insert(336837, "PSX"));
        locators.put("PUB", heap.insert(262291, "PUB"));
        locators.put("PVD", heap.insert(588344, "PVD"));
        locators.put("PWM", heap.insert(599395, "PWM"));
        locators.put("RAL", heap.insert(124191, "RAL"));
        locators.put("RBM", heap.insert(374217, "RBM"));
        locators.put("RCA", heap.insert(267402, "RCA"));
        locators.put("RDR", heap.insert(332476, "RDR"));
        locators.put("RDU", heap.insert(521231, "RDU"));
        locators.put("RIC", heap.insert(527278, "RIC"));
        locators.put("RIU", heap.insert(86282, "RIU"));
        locators.put("RIV", heap.insert(123188, "RIV"));
        locators.put("RME", heap.insert(548383, "RME"));
        locators.put("RND", heap.insert(315112, "RND"));
        locators.put("RNO", heap.insert(108317, "RNO"));
        locators.put("ROC", heap.insert(527398, "ROC"));
        locators.put("ROW", heap.insert(256182, "ROW"));
        locators.put("RSW", heap.insert(486417, "RSW"));
        locators.put("SAC", heap.insert(85285, "SAC"));
        locators.put("SAF", heap.insert(235221, "SAF"));
        locators.put("SAN", heap.insert(132172, "SAN"));
        locators.put("SAT", heap.insert(313116, "SAT"));
        locators.put("SAV", heap.insert(487162, "SAV"));
        locators.put("SBO", heap.insert(477172, "SBO"));
        locators.put("SBY", heap.insert(547282, "SBY"));
        locators.put("SCK", heap.insert(88269, "SCK"));
        locators.put("SEA", heap.insert(76471, "SEA"));
        locators.put("SEM", heap.insert(438169, "SEM"));
        locators.put("SFF", heap.insert(125467, "SFF"));
        locators.put("SFO", heap.insert(77276, "SFO"));
        locators.put("SFZ", heap.insert(592339, "SFZ"));
        locators.put("SHV", heap.insert(371162, "SHV"));
        locators.put("SJC", heap.insert(85262, "SJC"));
        locators.put("SJT", heap.insert(302140, "SJT"));
        locators.put("SKA", heap.insert(125466, "SKA"));
        locators.put("SKF", heap.insert(316103, "SKF"));
        locators.put("SKY", heap.insert(477346, "SKY"));
        locators.put("SLC", heap.insert(186333, "SLC"));
        locators.put("SMF", heap.insert(90280, "SMF"));
        locators.put("SNA", heap.insert(132196, "SNA"));
        locators.put("SPB", heap.insert(73429, "SPB"));
        locators.put("SPG", heap.insert(479677, "SPG"));
        locators.put("SPS", heap.insert(320191, "SPS"));
        locators.put("SSC", heap.insert(500195, "SSC"));
        locators.put("STL", heap.insert(398297, "STL"));
        locators.put("SUU", heap.insert(89286, "SUU"));
        locators.put("SUX", heap.insert(337370, "SUX"));
        locators.put("SVN", heap.insert(485178, "SVN"));
        locators.put("SWF", heap.insert(553353, "SWF"));
        locators.put("SYR", heap.insert(533387, "SYR"));
        locators.put("SZL", heap.insert(370283, "SZL"));
        locators.put("TBN", heap.insert(378264, "TBN"));
        locators.put("TCC", heap.insert(271220, "TCC"));
        locators.put("TCM", heap.insert(75459, "TCM"));
        locators.put("TCS", heap.insert(223183, "TCS"));
        locators.put("TEB", heap.insert(553333, "TEB"));
        locators.put("TIK", heap.insert(331235, "TIK"));
        locators.put("TLH", heap.insert(458126, "TLH"));
        Assertions.assertEquals(73429, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("TCM"), 0));
        Assertions.assertEquals("TCM", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SFO"), 0));
        Assertions.assertEquals("SFO", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SAC"), 0));
        Assertions.assertEquals("SAC", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SCK"), 0));
        Assertions.assertEquals("SCK", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SMF"), 0));
        Assertions.assertEquals("SMF", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("RIV"), 0));
        Assertions.assertEquals("RIV", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SKA"), 0));
        Assertions.assertEquals("SKA", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SAN"), 0));
        Assertions.assertEquals("SAN", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SPB"), 0));
        Assertions.assertEquals("SPB", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("PSP"), 0));
        Assertions.assertEquals("PSP", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SLC"), 0));
        Assertions.assertEquals("SLC", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SAF"), 0));
        Assertions.assertEquals("SAF", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("PUB"), 0));
        Assertions.assertEquals("PUB", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("TCC"), 0));
        Assertions.assertEquals("TCC", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SAT"), 0));
        Assertions.assertEquals("SAT", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SKF"), 0));
        Assertions.assertEquals("SKF", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("TIK"), 0));
        // The following extract-min generates a quake to level 0
        Assertions.assertEquals("TIK", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 47}","[76471 SEA]","[85262 SJC]","[86282 RIU]","[89286 SUU]","[108317 RNO]","[124191 RAL]","[125467 SFF]","[132196 SNA]","[180208 PRC]","[223183 TCS]","[256182 ROW]","[267402 RCA]","[302140 SJT]","[315112 RND]","[320191 SPS]","[332476 RDR]","[336837 PSX]","[337370 SUX]","[369149 POE]","[370283 SZL]","[371162 SHV]","[374217 RBM]","[378264 TBN]","[398297 STL]","[426127 PNS]","[438169 SEM]","[458126 TLH]","[477172 SBO]","[477346 SKY]","[479677 SPG]","[485178 SVN]","[486417 RSW]","[487162 SAV]","[500195 SSC]","[508233 POB]","[521231 RDU]","[527278 RIC]","[527398 ROC]","[533387 SYR]","[547282 SBY]","[548383 RME]","[553333 TEB]","[553353 SWF]","[588344 PVD]","[592339 SFZ]","[599395 PWM]","[617448 PQI]"), heap.listHeap());
        Assertions.assertEquals(76471, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("PWM"), 0));
        Assertions.assertEquals("PWM", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("TEB"), 0));
        Assertions.assertEquals("TEB", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("PVD"), 0));
        Assertions.assertEquals("PVD", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SSC"), 0));
        Assertions.assertEquals("SSC", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("RDU"), 0));
        Assertions.assertEquals("RDU", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("ROC"), 0));
        Assertions.assertEquals("ROC", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SBY"), 0));
        Assertions.assertEquals("SBY", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SJC"), 0));
        Assertions.assertEquals("SJC", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SUU"), 0));
        Assertions.assertEquals("SUU", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("RAL"), 0));
        Assertions.assertEquals("RAL", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SNA"), 0));
        Assertions.assertEquals("SNA", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("TCS"), 0));
        // The following extract-min generates a quake to level 0
        Assertions.assertEquals("TCS", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("RCA"), 0));
        Assertions.assertEquals("RCA", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("RND"), 0));
        Assertions.assertEquals("RND", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("RDR"), 0));
        Assertions.assertEquals("RDR", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SUX"), 0));
        Assertions.assertEquals("SUX", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SZL"), 0));
        Assertions.assertEquals("SZL", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("RBM"), 0));
        Assertions.assertEquals("RBM", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("STL"), 0));
        Assertions.assertEquals("STL", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SEM"), 0));
        Assertions.assertEquals("SEM", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SBO"), 0));
        // The following extract-min generates a quake to level 0
        Assertions.assertEquals("SBO", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 26}","[76471 SEA]","[86282 RIU]","[108317 RNO]","[125467 SFF]","[180208 PRC]","[256182 ROW]","[302140 SJT]","[320191 SPS]","[336837 PSX]","[369149 POE]","[371162 SHV]","[378264 TBN]","[426127 PNS]","[458126 TLH]","[477346 SKY]","[479677 SPG]","[485178 SVN]","[486417 RSW]","[487162 SAV]","[508233 POB]","[527278 RIC]","[533387 SYR]","[548383 RME]","[553353 SWF]","[592339 SFZ]","[617448 PQI]"), heap.listHeap());
        Assertions.assertEquals(76471, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("RSW"), 0));
        Assertions.assertEquals("RSW", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("POB"), 0));
        Assertions.assertEquals("POB", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SYR"), 0));
        Assertions.assertEquals("SYR", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SWF"), 0));
        Assertions.assertEquals("SWF", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("RIU"), 0));
        Assertions.assertEquals("RIU", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SFF"), 0));
        Assertions.assertEquals("SFF", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("ROW"), 0));
        // The following extract-min generates a quake to level 0
        Assertions.assertEquals("ROW", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertEquals(76471, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 19}","[617448 PQI]","{lev: 1 nodeCt: 9}","(548383)","[548383 RME]","[592339 SFZ]","{lev: 2 nodeCt: 4}","{lev: 3 nodeCt: 2}","{lev: 4 nodeCt: 1}","(76471)","(76471)","(76471)","(76471)","[76471 SEA]","[108317 RNO]","(180208)","[180208 PRC]","[302140 SJT]","(320191)","(320191)","[320191 SPS]","[336837 PSX]","(369149)","[369149 POE]","[371162 SHV]","(378264)","(378264)","(378264)","[378264 TBN]","[426127 PNS]","(458126)","[458126 TLH]","[477346 SKY]","(479677)","(479677)","[479677 SPG]","[485178 SVN]","(487162)","[487162 SAV]","[527278 RIC]"), heap.listHeap());
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SEA"), 76470));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("RNO"), 108316));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("PRC"), 180207));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SJT"), 302139));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SPS"), 320190));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("PSX"), 336836));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("POE"), 369148));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SHV"), 371161));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("TBN"), 378263));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("PNS"), 426126));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("TLH"), 458125));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SKY"), 477345));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SPG"), 479676));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SVN"), 485177));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SAV"), 487161));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("RIC"), 527277));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 19}","[108316 RNO]","[302139 SJT]","[336836 PSX]","[371161 SHV]","[426126 PNS]","[477345 SKY]","[485177 SVN]","[527277 RIC]","[617448 PQI]","{lev: 1 nodeCt: 9}","(180207)","[180207 PRC]","[null]","(369148)","[369148 POE]","[null]","(458125)","[458125 TLH]","[null]","(487161)","[487161 SAV]","[null]","(548383)","[548383 RME]","[592339 SFZ]","{lev: 2 nodeCt: 4}","(320190)","(320190)","[320190 SPS]","[null]","[null]","(479676)","(479676)","[479676 SPG]","[null]","[null]","{lev: 3 nodeCt: 2}","(378263)","(378263)","(378263)","[378263 TBN]","[null]","[null]","[null]","{lev: 4 nodeCt: 1}","(76470)","(76470)","(76470)","(76470)","[76470 SEA]","[null]","[null]","[null]","[null]"), heap.listHeap());
        // The following extract-min generates a quake to level 0
        Assertions.assertEquals("SEA", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 18}","[108316 RNO]","[180207 PRC]","[302139 SJT]","[320190 SPS]","[336836 PSX]","[369148 POE]","[371161 SHV]","[378263 TBN]","[426126 PNS]","[458125 TLH]","[477345 SKY]","[479676 SPG]","[485177 SVN]","[487161 SAV]","[527277 RIC]","[548383 RME]","[592339 SFZ]","[617448 PQI]"), heap.listHeap());
        Assertions.assertEquals(108316, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("PRC"), 0));
        Assertions.assertEquals("PRC", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("SPS"), 0));
        Assertions.assertEquals("SPS", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("POE"), 0));
        Assertions.assertEquals("POE", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("TBN"), 0));
        Assertions.assertEquals("TBN", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get("TLH"), 0));
        Assertions.assertEquals("TLH", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertEquals(108316, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 13}","[617448 PQI]","{lev: 1 nodeCt: 6}","{lev: 2 nodeCt: 3}","(487161)","(487161)","[487161 SAV]","[527277 RIC]","(548383)","[548383 RME]","[592339 SFZ]","{lev: 3 nodeCt: 1}","(108316)","(108316)","(108316)","[108316 RNO]","[302139 SJT]","(336836)","[336836 PSX]","[371161 SHV]","(426126)","(426126)","[426126 PNS]","[477345 SKY]","(479676)","[479676 SPG]","[485177 SVN]"), heap.listHeap());
        locators.put("PNX", heap.insert(6127, "PNX"));
        locators.put("POY", heap.insert(8233, "POY"));
        locators.put("POZ", heap.insert(9149, "POZ"));
        Assertions.assertEquals(6127, Assertions.assertDoesNotThrow(heap::getMinKey));
        Assertions.assertIterableEquals(List.of("{lev: 0 nodeCt: 16}","{lev: 1 nodeCt: 8}","{lev: 2 nodeCt: 4}","{lev: 3 nodeCt: 2}","{lev: 4 nodeCt: 1}","(6127)","(6127)","(6127)","(6127)","[6127 PNX]","[8233 POY]","(9149)","[9149 POZ]","[617448 PQI]","(487161)","(487161)","[487161 SAV]","[527277 RIC]","(548383)","[548383 RME]","[592339 SFZ]","(108316)","(108316)","(108316)","[108316 RNO]","[302139 SJT]","(336836)","[336836 PSX]","[371161 SHV]","(426126)","(426126)","[426126 PNS]","[477345 SKY]","(479676)","[479676 SPG]","[485177 SVN]"), heap.listHeap());
        Assertions.assertEquals("PNX", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertEquals("POY", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertEquals("POZ", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertEquals("RNO", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertEquals("SJT", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertEquals("PSX", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertEquals("SHV", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertEquals("PNS", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertEquals("SKY", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertEquals("SPG", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertEquals("SVN", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertEquals("SAV", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertEquals("RIC", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertEquals("RME", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertEquals("SFZ", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertEquals("PQI", Assertions.assertDoesNotThrow(heap::extractMin));
        Assertions.assertIterableEquals(List.of(), heap.listHeap());
    }

}