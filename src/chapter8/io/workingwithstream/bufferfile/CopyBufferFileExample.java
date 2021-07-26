package chapter8.io.workingwithstream.bufferfile;

import java.io.*;

public class CopyBufferFileExample {
    public static void copy(File source, File destination) throws IOException {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(destination))) {
            byte[] bytes = new byte[1024];
            int lengthRead;
            while ((lengthRead = inputStream.read(bytes)) > 0) {
                outputStream.write(bytes, 0, lengthRead);
                outputStream.flush();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File source = new File("source");
        File destination = new File("destination");
        copy(source, destination);
    }
}
