package chapter7.concurrency;

// Using a while() loop to check for data without some kind of delay
// => a very bad coding practice
public class PollingWithSleep {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 500; i++)
                PollingWithSleep.counter++;
        }).start();

        while (PollingWithSleep.counter < 100) {
            System.out.println("Not reach yet");

            // Thread.sleep() throws the checked InterruptedException
            Thread.sleep(100); // delay
        }
        System.out.println("Reach");
    }
}
