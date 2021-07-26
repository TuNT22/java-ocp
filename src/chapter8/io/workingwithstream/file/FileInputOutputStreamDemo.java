package chapter8.io.workingwithstream.file;

import java.io.*;

public class FileInputOutputStreamDemo {
    public static void copy(File source, File destination) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(source); // throw a FileNotFoundException if the file is not found
             FileOutputStream outputStream = new FileOutputStream(destination)) {
            int b;
            while ((b = inputStream.read()) != -1) {
                outputStream.write(b); // throw IOException
            }
        }
    }
    public static void main(String[] args) throws IOException {
        File source = new File("source");
        File destination = new File("destination");
        copy(source, destination);
    }
}
