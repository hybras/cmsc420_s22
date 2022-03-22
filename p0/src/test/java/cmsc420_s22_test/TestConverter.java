package cmsc420_s22_test;

// YOU SHOULD NOT MODIFY THIS FILE, EXCEPT TO ALTER THE INPUT/OUTPUT SOURCES

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;

/**
 * Testing program for Part 0. By default, this reads from tests/test01-input.txt and
 * writes to stdout a test method. Copy this to a test class. Change inputFileName
 * below to change this behavior.
 */

public class TestConverter {

    @Test
    public void converter() throws FileNotFoundException {

        final var inputFileName = "test01-input.txt";

        try(Scanner scanner = new Scanner(new FileInputStream(String.valueOf(Path.of(System.getProperty("user.dir"), "src", "test", "resources", inputFileName))))) {
            CommandHandler commandHandler = new CommandHandler(); // initialize command handler
            System.out.println("@Test\nvoid test() {");
            System.out.println("var dl = new DualList<String, Integer>();");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); // input next line
                String output = commandHandler.processCommand(line); // process this command
                System.out.print(output); // output summary
            }
            System.out.println("}");
        }
    }
}
