package chapter7.concurrency.synchronizingdataaccess;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
//    private int sheepCount = 0;
    private AtomicInteger sheepCount = new AtomicInteger(0);
    private void incrementAndReport() {
//        System.out.print((++sheepCount)+" ");
        System.out.print(sheepCount.incrementAndGet()+" ");
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);

            AtomicDemo sheepManager = new AtomicDemo();
            for(int i=0; i<10; i++)
                service.submit(() -> sheepManager.incrementAndReport());
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
