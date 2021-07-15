package chapter7.concurrency.parallelstream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectDemo {
    public static void main(String[] args) {
        Stream<String> animalStream =
                Arrays.asList("cat", "dog", "tiger", "horse", "bear")
                .parallelStream();

        // using toConcurrentMap()
        ConcurrentMap<Integer, String> map = animalStream.collect(
                Collectors.toConcurrentMap(
                        String::length, // key mapper
                        v -> v, // value mapper
                        (a, b) -> a + ", " + b // merge function
                )
        );

        System.out.println(map);
        System.out.println(map.getClass());
        System.out.println();

        // using groupingByConcurrent()
        Stream<String> fruitStream =
                Arrays.asList("apple", "kiwi", "pineapple", "orange", "mango")
                        .parallelStream();
        ConcurrentMap<Integer, List<String>> fruitMap = fruitStream
                .collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(fruitMap);
    }
}
