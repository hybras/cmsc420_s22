package cmsc420_s22_test;

// YOU SHOULD NOT MODIFY THIS FILE, EXCEPT TO ALTER THE INPUT/OUTPUT SOURCES

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Testing program for Part 0. By default, this reads from tests/test01-input.txt and
 * writes the output to tests/test01-output.txt. Change inputFileName and outputFileName
 * below to change this behavior.
 */

public class TestConverter {

    @Test
    public void converter() {
        final var inputFileName = "test01-input.txt";

        try {
            Scanner scanner = new Scanner(new FileInputStream(String.valueOf(Path.of(System.getProperty("user.dir"), "src", "test", "resources", inputFileName)))); // input scanner
            CommandHandler commandHandler = new CommandHandler(); // initialize command handler
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); // input next line
                String output = commandHandler.processCommand(line); // process this command
                System.out.print(output); // output summary
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}
