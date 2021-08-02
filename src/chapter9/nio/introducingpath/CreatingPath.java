package chapter9.nio.introducingpath;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Cách để tạo Path instance
 */
public class CreatingPath {
    /**
     * Sử dụng Paths factory class
     */
    private static void usePathsClass() throws URISyntaxException {
        // Paths.get() có 3 overloaded version

        // 1. Paths.get(String)
        Path path1 = Paths.get("panda/cuddly.png"); // relative file
        Path path2 = Paths.get("c:\\zooinfo\\November\\employees.txt"); // absolute file in Windows
        Path path3 = Paths.get("/home/zoodirector"); // absolute directory in Linux or Mac

        // 2. Paths.get(String, String...)
        path1 = Paths.get("pandas","cuddly.png");
        path2 = Paths.get("c:","zooinfo","November","employees.txt");
        path3 = Paths.get("/","home","zoodirector");

        // 3. Paths.get(URI)
        // new URI(String) constructor throws checked URISyntaxException
        path1 = Paths.get(new URI("file://pandas/cuddly.png")); // throws Runtime exception  as URIs must reference absolute paths at runtime
        path2 = Paths.get(new URI("file:///c:/zoo-info/November/employees.txt"));
        path3 =  Paths.get(new URI("file:///home/zoodirectory"));

        // URI with non-local file system schemas (http://, ftp://)
        Path path4 = Paths.get(new URI("http://www.wiley.com"));
        Path path5 = Paths.get(
                new URI("ftp://username:password@ftp.the-ftp-server.com"));

        // convert a Path instance back to a URI instance
        URI uri4 = path4.toUri();
    }

    /**
     * Sử dụng FileSystem Object
     */
    private static void useFileSystemClass() throws URISyntaxException {
        // FileSystem có protected constructor => sử dụng FileSystems factory class để tạo obj
        // FileSystems.getDefault() => connect to local file system
        Path path1 = FileSystems.getDefault().getPath("pandas/cuddly.png");
        Path path2 = FileSystems.getDefault().getPath("c:","zooinfo","November",
                "employees.txt");
        Path path3 = FileSystems.getDefault().getPath("/home/zoodirector");

        // connect to a remote file system
        FileSystem fileSystem = FileSystems.getFileSystem(
                new URI("http://www.selikoff.net"));
        Path path = fileSystem.getPath("duck.txt");
    }

    /**
     * Convert giữa Path và legacy File object
     */
    private static void workWithLegacyFile() {
        File file = new File("pandas/cuddly.png");

        // File to Path
        Path path = file.toPath();

        // Path to File
        file = path.toFile();
    }

    public static void main(String[] args) {

    }
}
