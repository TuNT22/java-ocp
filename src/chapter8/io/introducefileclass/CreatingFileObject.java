package chapter8.io.introducefileclass;

import java.io.File;

public class CreatingFileObject {
    /**
     * Print separator character
     */
    private static void printSeparatorChar() {
        // use system property
        System.out.println(System.getProperty("file.separator"));

        // use static variable
        System.out.println(File.separator);
    }

    /**
     * create file using java.io.File
     */
    private static void createFile() {
        File dir = new File(".");
        File txt = new File(dir,"destination");
        File nonExisted = new File(dir,"no");
        System.out.println(dir.exists());
        System.out.println(txt.exists());
        System.out.println(nonExisted.exists());
    }

    public static void main(String[] args) {
        printSeparatorChar();
        createFile();
    }
}
