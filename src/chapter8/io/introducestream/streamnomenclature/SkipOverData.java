package chapter8.io.introducestream.streamnomenclature;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class SkipOverData {
    public static void main(String[] args) throws IOException {
        InputStream is = new ByteArrayInputStream("TIGERS".getBytes(StandardCharsets.UTF_8));

        System.out.print ((char)is.read());
        is.skip(2);
        is.read();
        System.out.print((char)is.read());
        System.out.print((char)is.read());
    }
}
