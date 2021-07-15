package chapter7.concurrency.creatingthread.schedulingtask;

import java.util.concurrent.*;

public class ScheduledExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService service = null;
        try {
            service = Executors.newSingleThreadScheduledExecutor();

            Runnable task1 = () -> System.out.println("Hello Zoo");
            Callable<String> task2 = () -> {
                System.out.println("Chicken");
                return "Chicken";
            };

            Future<?> result1 = service.schedule(task1, 4, TimeUnit.SECONDS);
            Future<String> result = service.schedule(task2, 2, TimeUnit.SECONDS);
        } finally {
            if (service != null)
                service.shutdown();
        }
    }
}
