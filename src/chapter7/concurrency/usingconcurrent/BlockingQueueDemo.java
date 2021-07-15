package chapter7.concurrency.usingconcurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

// BlockingQueue includes methods that will wait a specific amount of time to complete an operation
public class BlockingQueueDemo {
    public static void main(String[] args) {
        try {
            BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
            blockingQueue.offer(39);
            blockingQueue.offer(3, 4, TimeUnit.SECONDS); // throw a checked InterruptedException

            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            // Handle interruption
        }
    }
}
