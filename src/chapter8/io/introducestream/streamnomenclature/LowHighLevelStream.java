package chapter8.io.introducestream.streamnomenclature;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LowHighLevelStream {
    public static void main(String[] args) throws IOException {
        // high-level stream is built on top of another stream using wrapping
        // wrapping: an instance is passed to the constructor of another class
        //  operations on the resulting instance are filtered and applied to the original instance
        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new FileReader("source"))) {
            System.out.println(bufferedReader.readLine());
        }
    }
}
