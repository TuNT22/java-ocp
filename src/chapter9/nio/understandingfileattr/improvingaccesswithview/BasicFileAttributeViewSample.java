package chapter9.nio.understandingfileattr.improvingaccesswithview;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class BasicFileAttributeViewSample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("data/source.txt");
        BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes attr = view.readAttributes(); // you can extract a BasicFileAttributes object

        System.out.println("Last modified: " + attr.lastModifiedTime().toMillis());

        FileTime lastModifiedTime = FileTime.fromMillis(attr.lastModifiedTime().toMillis() + 10_000);
        view.setTimes(lastModifiedTime,null,null);

        BasicFileAttributes updatedAttr = view.readAttributes(); // get updated BasicFileAttributes
        System.out.println("Last modified: " + updatedAttr.lastModifiedTime().toMillis());
    }
}
