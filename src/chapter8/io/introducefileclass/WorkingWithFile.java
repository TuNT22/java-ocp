package chapter8.io.introducefileclass;

import java.io.File;

public class WorkingWithFile {
    /**
     * method demonstrating some common methods of File class
     * @param filePath
     */
    private static void workWithFile(String filePath) {
        File file = new File(filePath);
        System.out.println("File Exists: " + file.exists());
        if (file.exists()) {
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Is Directory: " + file.isDirectory());
            System.out.println("Parent Path: " + file.getParent());
            if (file.isFile()) {
                System.out.println("File size: " + file.length());
                System.out.println("File LastModified: " + file.lastModified());
            } else {
                for (File subfile : file.listFiles()) {
                    System.out.println("\t"+ subfile.getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        // demo with file
        workWithFile("destination");

        System.out.println("=====================");

        // demo with directory
        workWithFile(".idea");
    }
}
