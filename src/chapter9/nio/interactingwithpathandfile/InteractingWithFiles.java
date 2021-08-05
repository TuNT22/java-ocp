package chapter9.nio.interactingwithpathandfile;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class InteractingWithFiles {
    /**
     * Testing a Path with exists()
     * exists() does not throw an exception if the file does not exist
     */
    private static void existsDemo() {
        System.out.println(Files.exists(Paths.get("src")));
        System.out.println(Files.exists(Paths.get("/ostrich/feathers.png")));
    }

    /**
     * Making Directories with createDirectory() and createDirectories()
     * @throws IOException
     */
    private static void createDirectoryDemo() throws IOException {

        // Nếu thư mục cha bison tồn tại, tạo thư mục con field
        // Nếu thư mục cha không tồn tại, throws Exception
        Files.createDirectory(Paths.get("D:\\An\\bison\\field"));

        // Tạo thư mục green và cả các thư mục cha nếu chúng chưa tồn tại
        Files.createDirectories(Paths.get("D:\\An\\bison\\pasture\\green"));
    }

    /**
     * Copy directory
     * @throws IOException
     */
    private static void copyDirectoryDemo() throws IOException {
        // copy thư mục panda thành panda-copy
        // chỉ copy "nông" (shallow)
        // nghĩa là không thực hiện copy nội dung bên trong thư mục ban đầu
        Files.copy(Paths.get("data\\panda"), Paths.get("data\\panda-copy"));

        // muốn copy nội dung thư mục, phải thực hiện duyệt thư mục
        // và copy từng item
        Files.copy(Paths.get("data\\panda\\bamboo.txt"), Paths.get("data\\panda-copy\\bamboo-copy.txt"));
    }

    /**
     * Copying Files with java.io and NIO.2
     * @throws IOException
     */
    private static void copyFileDemo() throws IOException {
        try (InputStream is = new FileInputStream("data\\source.txt");
             OutputStream os = new FileOutputStream("data\\output.txt")) {
            // copy(InputStream, Path)
            // support vararg options
            Files.copy(is, Paths.get("data\\copy\\source-copy.txt"));

            // copy(Path, OutputStream)
            // does not support vararg options
            Files.copy(Paths.get("data\\panda\\bamboo.txt"), os);
        }
    }

    /**
     * Writing File Data with newBufferedWriter()
     * @throws IOException
     */
    private static void newBufferedWriterDemo() throws IOException {
        Path path = Paths.get("data\\source.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.defaultCharset())) {
            writer.write("Line 1");
            writer.newLine();
            writer.write("Line 2");
        }
    }

    /**
     * Reading File Data with newBufferedReader()
     * @throws IOException
     */
    private static void newBufferedReaderDemo() throws IOException {
        Path path = Paths.get("data\\source.txt");
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String currentLine = null;
            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
            }
        }
    }

    /**
     * Reading Files with readAllLines()
     */
    private static void readAllLinesDemo() throws IOException {
        Path path = Paths.get("data\\source.txt");
        List<String> lines = Files.readAllLines(path);

        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) throws IOException {
        readAllLinesDemo();
    }
}
