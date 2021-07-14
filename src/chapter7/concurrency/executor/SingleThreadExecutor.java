package chapter7.concurrency.executor;

import java.util.concurrent.*;

public class SingleThreadExecutor {
    public static void main(String[] args) {
        // ExecutorService: tạo và quản lý thread
        ExecutorService service = null;
        try {
            // Có thể lấy instance của ExecutorService interface sử dụng Executors factory class
            service = Executors.newSingleThreadExecutor(); // service sẽ chỉ tạo 1 thread

            System.out.println("begin");
            service.execute(() -> System.out.println("Printing zoo inventory")); // 1
            service.execute(() -> {for(int i=0; i<3; i++)
                System.out.println("Printing record: "+i);}
            ); // 2
            service.execute(() -> System.out.println("Printing zoo inventory")); // 3
            System.out.println("end");

            // Vì các task ở 1, 2, 3 dc thực hiện bởi 1 thread => thực hiện theo trình tự
        } finally {
            if (service != null)
                service.shutdown(); // cần shutdown sau khi sử dụng xong service
        }
    }
}
