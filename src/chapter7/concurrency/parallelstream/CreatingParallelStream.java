package chapter7.concurrency.parallelstream;

import java.util.Arrays;
import java.util.stream.Stream;

public class CreatingParallelStream {
    public static void main(String[] args) {
        // Two ways of creating a parallel stream

        // The first way is to create a parallel stream
        // from an existing stream
        // using parallel()
        Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6).stream();
        System.out.println("stream is parallel: " + stream.isParallel());

        Stream<Integer> parallelStream = stream.parallel();
        System.out.println("stream is parallel: " + stream.isParallel());
        System.out.println("parallelStream is parallel: " + parallelStream.isParallel());

        // The second way is from a Java collection class
        // parallelStream()
        Stream<Integer> parallelStream2 = Arrays.asList(1,2,3,4,5,6).parallelStream();
    }
}
