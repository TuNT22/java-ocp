package chapter7.concurrency.introducingthread;

// 2 cách định nghĩa task
// sử dụng Runnable object / lambda expression trong Thread constructor
class PrintData implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Printing " + i);
        }
    }

    public static void main(String[] args) {
        (new Thread(new PrintData())).start();
    }

}

// extend class thread và override run method
class ReadInventoryThread extends Thread {
    @Override
    public void run() {
        System.out.println("Printing inventory");
    }

    public static void main(String[] args) {
        (new ReadInventoryThread()).start();
    }
}

// trong hầu hết trường hợp, ta sử dụng cách 1

