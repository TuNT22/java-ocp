package chapter8.io.introducestream.streamnomenclature;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MarkingTheStream {
    public static void main(String[] args) throws IOException {
        InputStream is = new ByteArrayInputStream("ABCD".getBytes(StandardCharsets.UTF_8));
        System.out.print ((char)is.read());
        if(is.markSupported()) {
            is.mark(100); // when you read more than 100 bytes, the mark position becomes invalid
            System.out.print((char)is.read());
            System.out.print((char)is.read());
            is.reset();
        }
        System.out.print((char)is.read());
        System.out.print((char)is.read());
        System.out.print((char)is.read());
    }
}
