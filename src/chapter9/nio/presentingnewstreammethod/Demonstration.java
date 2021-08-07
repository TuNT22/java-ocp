package chapter9.nio.presentingnewstreammethod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.*;
import java.util.stream.Stream;

public class Demonstration {
    /**
     * Files.walk(path)
     */
    private static void walkDirectory() {
        Path path = Paths.get("src");

        try {
            Files.walk(path)
                    .filter(p -> p.toString().endsWith(".java"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            // Handle file I/O exception...
        }
    }

    /**
     * Files.find(Path, int, BiPredicate)
     */
    private static void searchDirectory() {
        Path path = Paths.get("src");

        LocalDateTime dateTime = LocalDateTime.of(LocalDate.of(2021, 8, 2),
                LocalTime.of(10, 2));
        ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.systemDefault());
        long dateFilter = zonedDateTime.toInstant().toEpochMilli();

        try {
            Stream<Path> stream = Files.find(path, 10,
                    (p, attributes) -> p.toString().endsWith(".java")
                            && attributes.creationTime().toMillis() > dateFilter);
            stream.forEach(System.out::println);
        } catch (Exception e) {
            // Handle file I/O exception...
        }
    }

    /**
     * Files.list(path)
     */
    private static void listDirContent() {
        try {
            Path path = Paths.get(".");
            Files.list(path)
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toAbsolutePath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            // Handle file I/O exception...
        }
    }

    /**
     * Files.lines(path)
     */
    private static void printFileContents() {
        Path path = Paths.get(".gitignore");
        try {
            Files.lines(path)
                    .forEach(System.out::println);
        } catch (IOException e) {
            // Handle file I/O exception...
        }
    }
    public static void main(String[] args) {
        printFileContents();
    }
}
