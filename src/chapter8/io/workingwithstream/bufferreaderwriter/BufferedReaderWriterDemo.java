package chapter8.io.workingwithstream.bufferreaderwriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BufferedReaderWriterDemo {
    public static List<String> readFile(File source) throws IOException {
        List<String> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String s;
            while ((s = reader.readLine()) != null) {
                // with BufferedReader, we stop reading the file when readLine() returns null
                data.add(s);
            }
        }

        return data;
    }

    public static void writeFile(List<String> input, File destination) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for (String line : input) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File source = new File("source");
        File destination = new File("destination");
        List<String> data = readFile(source);
        for (String line: data) {
            System.out.println(line);
        }
        writeFile(data, destination);
    }
}
