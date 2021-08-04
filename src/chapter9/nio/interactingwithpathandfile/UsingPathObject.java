package chapter9.nio.interactingwithpathandfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingPathObject {
    /**
     * Viewing the Path with toString(), getNameCount(), and getName()
     */
    private static void viewPath() {
        // Path path = Paths.get("/land/hippo/harry.happy");
        Path path = Paths.get(" land/hippo/harry.happy");

        // toString() return String object
        System.out.println("The Path Name is: " + path);

        // int getNameCount() return the number of elements in the path
        for (int i = 0; i < path.getNameCount(); i++) {

            // Path getName(int index) returns the component of the Path at specified index
            // zero-indexed, with the file system root excluded from the path components
            System.out.println(" Element " + i + " is: " + path.getName(i));
        }
    }

    static class PathFilePathTest {
        /**
         * Accessing Path Components with getFileName(), getParent(),
         * and getRoot()
         * @param path
         */
        public static void printPathInformation(Path path) {
            System.out.println("Filename is: " + path.getFileName());
            System.out.println("Root is: " + path.getRoot());

            Path currentParent = path;
            while((currentParent = currentParent.getParent()) != null) {
                System.out.println(" Current parent is: " + currentParent);
            }
        }

        public static void main(String[] args) {
            printPathInformation(Paths.get("/zoo/armadillo/shells.txt"));
            System.out.println();
            printPathInformation(Paths.get("armadillo/shells.txt"));
        }
    }

    /**
     * Checking Path Type with isAbsolute() and toAbsolutePath()
     */
    private static void checkPathType() {
        Path path1 = Paths.get("D:\\An\\Java Cert\\java-ocp\\destination");
        System.out.println("Path1 is Absolute? " + path1.isAbsolute());
        System.out.println("Absolute Path1: " + path1.toAbsolutePath());

        Path path2 = Paths.get("destination");
        System.out.println("Path2 is Absolute? " + path2.isAbsolute());
        System.out.println("Absolute Path2 " + path2.toAbsolutePath());
    }

    /**
     * Creating a New Path with subpath()
     */
    private static void subPathDemo() {
        Path path = Paths.get("/mammal/carnivore/raccoon.image");
        System.out.println("Path is " + path);
        System.out.println("Subpath from 0 to 3 is: "+path.subpath(0,3)); // mammal/carnivore/raccoon.image
        System.out.println("Subpath from 1 to 3 is: "+path.subpath(1,3)); // carnivore/raccoon.image
        System.out.println("Subpath from 1 to 2 is: "+path.subpath(1,2)); // carnivore

        // System.out.println("Subpath from 0 to 4 is: "+path.subpath(0,4)); // throws java.lang.IllegalArgumentException
        // System.out.println("Subpath from 1 to 1 is: "+path.subpath(1,1)); // throws java.lang.IllegalArgumentException
    }

    /**
     * Deriving a Path with relativize()
     */
    private static void relativizeDemo() {
        Path path1 = Paths.get("fish.txt");
        Path path2 = Paths.get("birds.txt");

        System.out.println(path1.relativize(path2)); // ..\birds.txt
        System.out.println(path2.relativize(path1)); // ..\fish.txt
        // Nếu 2 paths đều relative, relativize() xem như chúng nằm trong cùng 1 thư mục
        // Vì path1, path2 đều trỏ đến file, ta cần phải move ra thư mục cha chứa file (sử dụng ..\)

        Path path3 = Paths.get("E:\\habitat");
        Path path4 = Paths.get("E:\\sanctuary\\raven");
        System.out.println(path3.relativize(path4)); // ..\sanctuary\raven
        System.out.println(path4.relativize(path3)); // ..\..\habitat

//        Path path5 = Paths.get("/primate/chimpanzee");
//        Path path6 = Paths.get("bananas.txt");
//        // cả 2 path đều phải cùng là absolute hoặc relative
//        path5.relativize(path6); // THROWS java.lang.IllegalArgumentException

//        Path path7 = Paths.get("c:\\primate\\chimpanzee");
//        Path path8 = Paths.get("d:\\storage\\bananas.txt");
//        // với hệ điều hành Windows, nếu là absolute path thì phải cùng ổ đĩa (cùng root)
//        path7.relativize(path8); // THROWS java.lang.IllegalArgumentException
    }

    /**
     * Joining Path Objects with resolve()
     */
    private static void resolveDemo() {
        final Path path1 = Paths.get("/cats/../panther");
        final Path path2 = Paths.get("food");
        // input path2 là relative path => join 2 paths với nhau
        System.out.println(path1.resolve(path2)); // \cats\..\panther\food

        final Path path3 = Paths.get("/turkey/food");
        final Path path4 = Paths.get("/tiger/cage");
        // input path4 là absolute path => ignore path3 và trả về copy của path4
        System.out.println(path3.resolve(path4)); // \tiger\cage
    }

    /**
     * Cleaning Up a Path with normalize()
     */
    private static void normalizeDemo() {
        Path path3 = Paths.get("E:\\data");
        Path path4 = Paths.get("E:\\user\\home");

        Path relativePath = path3.relativize(path4); // ..\ user\home
        System.out.println(path3.resolve(relativePath)); // E:\data\..\ user\home => redundancy
        System.out.println(path3.resolve(relativePath).normalize()); // E:\ user\home
    }

    /**
     * Checking for File Existence with toRealPath()
     */
    private static void toRealPathDemo() throws IOException {
        // Files.createSymbolicLink(Paths.get("chapter9.link"), Paths.get("src\\chapter9"));
        try {
            System.out.println(Paths.get("src\\chapter9").toRealPath());
            System.out.println(Paths.get("chapter9.link").toRealPath());

            //  gain access to the current working directory
            System.out.println(Paths.get(".").toRealPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        toRealPathDemo();
    }
}


