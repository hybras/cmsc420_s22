package cmsc420_s22_test;

// list-heap regex
// rg "^  (\{lev: \d+ nodeCt: \d+\}|\[\d+ .+\]|\(\d+\)|\[null\])$" test01-expected.txt --context 1 --replace="\"\$1\","

// YOU SHOULD NOT MODIFY THIS FILE, EXCEPT TO ALTER THE INPUT/OUTPUT SOURCES

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Testing program for Part 0. By default, this reads from tests/test01-input.txt and
 * writes the output to tests/test01-output.txt. Change inputFileName and outputFileName
 * below to change this behavior.
 */

public class ConvertTest {

    final static Pattern init_pat = Pattern.compile("set-n-levels\\((\\d+)\\): ");
    final static Pattern levels_pat = Pattern.compile("set-n-levels\\((\\d+)\\): (successful|Failure)");
    final static Pattern insert_pat = Pattern.compile("insert\\((\\d+), (\\w+)\\): successful");
    final static Pattern minKey_pat = Pattern.compile("get-min-key: (\\d+)");
    final static String minKeyFail_pat = "get-min-key: Failure due to exception: \"Empty heap\"";
    final static Pattern maxLev_pat = Pattern.compile("get-max-level\\((\\w+)\\): (\\d+)");
    final static String clear_pat = "clear: successful";
    final static Pattern size_regex = Pattern.compile("size: (\\d+)");
    final static Pattern extractMin_pat = Pattern.compile("extract-min: (\\w+)");
    final static String extractMinFail_pat = "extract-min: Failure due to exception: \"Empty heap\"";
    final static Pattern decKey_pat = Pattern.compile("decrease-key\\((\\w+), (\\d+)\\): (successful|Failure)");
    final static Pattern rat_pat = Pattern.compile("set-quake-ratio\\((0\\.\\d*|1\\.0)\\): (successful|Failure)");
    final static Pattern comment_pat = Pattern.compile("\\[(.+)]");

    @Test
    public void convertTest() {
        final var test = 7;
        final var inputFileName = String.format("test%02d-expected.txt", test);
        final var inputFilePath = String.valueOf(Path.of(System.getProperty("user.dir"), "src", "test", "resources", inputFileName));
        System.out.printf("@Test\nvoid test%02d() {\n", test);
        try (var scanner = new Scanner(new FileInputStream(inputFilePath))) {
            initialize(scanner);
            while (scanner.hasNextLine()) {
                var line = scanner.nextLine(); // input next line
                processLine(scanner, line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Could not find" + inputFileName);
        }
        System.out.println("}");
    }

    private static void processLine(Scanner scanner, String line) {
        if (line.startsWith("set-n-levels")) {
            setNLevels(line);
        } else if (line.startsWith("insert")) {
            insert(line);
        } else if (line.startsWith("list-heap")) {
            var next = listHeap(scanner);
            if (scanner.hasNextLine()) {
                processLine(scanner, next);
            }
        } else if (line.startsWith("get-min-key")) {
            getMinKey(line);
        } else if (line.startsWith("get-max-level")) {
            getMaxLevel(line);
        } else if (line.startsWith("clear")) {
            clear(line);
        } else if (line.startsWith("size")) {
            size(line);
        } else if (line.startsWith("decrease-key")) {
            decreaseKey(line);
        } else if (line.startsWith("set-quake-ratio")) {
            setQuakeRatio(line);
        } else if (line.startsWith("extract-min")) {
            extractMin(line);
        } else if (line.startsWith("[")) {
            comment(line);
        } else {
            throw new IllegalArgumentException("bad line: " + line);
        }
    }

    static void initialize(Scanner stdin) {
        // this method should only be called once, so its ok we're compiling a single use pattern
        var line = "";
        while (stdin.hasNextLine() && (line = stdin.nextLine()).startsWith("[")) {
            comment(line);
        }

        var matcher = init_pat.matcher(line);
        if (matcher.matches()) {
            var levels = Integer.parseInt(matcher.group(1));
            System.out.printf("var heap = new QuakeHeap<Integer, String>(%d);\nvar locators = new HashMap<String, QuakeHeap<Integer, String>.Locator>();\n", levels);
        } else {
            throw new IllegalArgumentException("Doesnt match: " + line);
        }
    }

    static void setNLevels(String line) {
        var matcher = levels_pat.matcher(line);
        if (matcher.matches()) {
            var levels = Integer.parseInt(matcher.group(1));
            var status = "successful".equals(matcher.group(2));
            if (status) {
                System.out.printf("heap.setNLevels(%d);\n", levels);
            } else {
                System.out.printf("Assertions.assertThrows(IllegalArgumentException.class, () -> heap.setNLevels(%d));\n", levels);
            }

        } else {
            throw new IllegalArgumentException("Doesnt match: " + line);
        }
    }

    static String listHeap(Scanner stdin) {
        System.out.print("Assertions.assertIterableEquals(List.of(");
        var line = "yeet";
        while (stdin.hasNextLine() && !(line = stdin.nextLine()).equals("Structured list:")) {
            System.out.printf("\"%s\",", line.trim());
        }
        while (stdin.hasNextLine() && (line = stdin.nextLine()).startsWith("  ")) {

        }
        System.out.println("), heap.listHeap());");
        return line;
    }

    static void comment(String line) {
        var matcher = comment_pat.matcher(line);
        if (matcher.matches()) {
            var comment = matcher.group(1);
            System.out.printf("// %s\n", comment);
        } else {
            throw new IllegalArgumentException("Doesnt match: " + line);
        }

    }

    static void insert(String line) {
        var matcher = insert_pat.matcher(line);
        if (matcher.matches()) {
            var key = Integer.parseInt(matcher.group(1));
            var val = matcher.group(2);
            System.out.printf("locators.put(\"%s\", heap.insert(%d, \"%s\"));\n", val, key, val);
        } else {
            throw new IllegalArgumentException("Doesnt match: " + line);
        }


    }

    static void getMinKey(String line) {
        var matcher = minKey_pat.matcher(line);
        if (matcher.matches()) {
            var key = Integer.parseInt(matcher.group(1));
            System.out.printf("Assertions.assertEquals(%d, Assertions.assertDoesNotThrow(heap::getMinKey));\n", key);
        } else if (minKeyFail_pat.equals(line)) {
            System.out.println("Assertions.assertThrows(EmptyHeapException.class, heap::getMinKey);");
        } else {
            throw new IllegalArgumentException("Doesnt match: " + line);
        }
    }

    static void getMaxLevel(String line) {
        var matcher = maxLev_pat.matcher(line);
        if (matcher.matches()) {
            var val = matcher.group(1);
            var lev = Integer.parseInt(matcher.group(2));
            System.out.printf("Assertions.assertEquals(%d, heap.getMaxLevel(locators.get(\"%s\")));\n", lev, val);
        } else {
            throw new IllegalArgumentException("Doesnt match: " + line);
        }
    }

    static void clear(String line) {
        if (clear_pat.equals(line)) {
            System.out.println("heap.clear();\nlocators.clear();");
        } else {
            throw new IllegalArgumentException("Doesnt match: " + line);
        }
    }

    static void size(String line) {
        var matcher = size_regex.matcher(line);
        if (matcher.matches()) {
            var size = Integer.parseInt(matcher.group(1));
            System.out.printf("Assertions.assertEquals(%d, heap.size());\n", size);
        } else {
            throw new IllegalArgumentException("Doesnt match: " + line);
        }

    }

    static void extractMin(String line) {
        var matcher = extractMin_pat.matcher(line);
        if (matcher.matches()) {
            var min = matcher.group(1);
            System.out.printf("Assertions.assertEquals(\"%s\", Assertions.assertDoesNotThrow(heap::extractMin));\n", min);
        } else if (extractMinFail_pat.equals(line)) {
            System.out.println("Assertions.assertThrows(EmptyHeapException.class, heap::extractMin);");
        } else {
            throw new IllegalArgumentException(line);
        }
    }

    static void decreaseKey(String line) {
        var matcher = decKey_pat.matcher(line);
        if (matcher.matches()) {
            var label = matcher.group(1);
            var newKey = Integer.parseInt(matcher.group(2));
            var status = "successful".equals(matcher.group(3));
            if (status) {
                System.out.printf("Assertions.assertDoesNotThrow(() -> heap.decreaseKey(locators.get(\"%s\"), %d));\n", label, newKey);
            } else {
                System.out.printf("Assertions.assertThrows(IllegalArgumentException.class, () -> heap.decreaseKey(locators.get(\"%s\"), %d));\n", label, newKey);
            }
        } else {
            throw new IllegalArgumentException("Doesnt match: " + line);
        }
    }

    static void setQuakeRatio(String line) {
        var matcher = rat_pat.matcher(line);
        if (matcher.matches()) {
            var ratio = Double.parseDouble(matcher.group(1));
            var status = "successful".equals(matcher.group(2));
            if (status) {
                System.out.printf("heap.setQuakeRatio(%f);\n", ratio);
            } else {
                System.out.printf("Assertions.assertThrows(IllegalArgumentException.class, () -> heap.setQuakeRatio(%f));\n", ratio);
            }

        } else {
            throw new IllegalArgumentException("Doesnt match: " + line);
        }
    }

}
