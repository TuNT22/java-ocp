package chapter7.concurrency.introducingthread;

// Using a while() loop to check for data without some kind of delay
// => a very bad coding practice
public class PollingWithSleep {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 500; i++)
                PollingWithSleep.counter++;
        }).start();

        while (PollingWithSleep.counter < 500) {
            System.out.println("Not reach yet");

            // Thread.sleep() throws the checked InterruptedException
            Thread.sleep(0); // delay
        }
        System.out.println("Reach");
    }
}
