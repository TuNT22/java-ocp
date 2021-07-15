package chapter7.concurrency.parallelstream;

import java.util.Arrays;

public class ReduceDemo {
    public static void main(String[] args) {
        System.out.println(Arrays.asList("w","o","l","f")
                .parallelStream()
                .reduce("",String::concat));
    }
}
