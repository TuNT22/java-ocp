package chapter7.concurrency.parallelstream;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.DoubleStream;

public class ReduceDemo {
    public static void main(String[] args) {
        System.out.println(Arrays.asList("w","o","l","f")
                .parallelStream()
                .reduce("",String::concat));
    }
}
