package chapter7.concurrency.creatingthread.waitingforresult;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = null;

        try {
            service = Executors.newSingleThreadExecutor();

            // unlike run() of Runnable
            // call() method of Callable has return type and can throw checked exception
            Future<Integer> result = service.submit(() -> 30 + 11);
            System.out.println(result.get()); // throws ExecutionException, InterruptedException
        } finally {
            if (service != null)
                service.shutdown();
        }
    }
}
