package chapter7.concurrency.parallelstream;

import java.util.Arrays;

public class ProcessingTask {
    private static void forEachOnParallel() {
        // output will vary, it could be 4 6 5 1 3 2
        Arrays.asList(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .forEach(s -> System.out.print(s + " "));

        System.out.println();

        // forEachOrdered()
        // forces a parallel stream to process the results in order
        // at the cost of performance
        Arrays.asList(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .forEachOrdered(s -> System.out.print(s + " "));
    }

    public static void main(String[] args) {
        forEachOnParallel();
    }
}
