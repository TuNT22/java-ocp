package chapter7.concurrency.managingconcurrent;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class WeighAnimalTask extends RecursiveTask<Double> {
    private int start;
    private int end;
    private Double[] weights;

    public WeighAnimalTask(Double[] weights, int start, int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    @Override
    protected Double compute() {
        if(end-start <= 3) {
            double sum = 0;
            for(int i = start; i < end; i++) {
                weights[i] = (double)new Random().nextInt(100);
                System.out.println("Animal Weighed: " + i);
                sum += weights[i];
            }
            return sum;
        }

        int middle = start + ((end-start)/2);
        System.out.println("[start=" + start + ",middle=" + middle + ",end=" + end + "]");

        RecursiveTask<Double> otherTask = new WeighAnimalTask(weights,start,middle);
        otherTask.fork(); // fork() instructs the fork/join framework to complete the task in a separate thread

        return new WeighAnimalTask(weights,middle,end).compute() + otherTask.join(); // join() causes the current thread to wait for the results
    }

    public static void main(String[] args) {
        Double[] weights = new Double[10];

        // Applying the fork/join framework requires us to perform three steps:
        // Step 1: Create a ForkJoinTask
        ForkJoinTask<Double> task = new WeighAnimalTask(weights, 0, weights.length);

        // Step 2: Create the ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Step 3: Start the ForkJoinTask
        Double sum = pool.invoke(task);
        System.out.println("Sum = " + sum);
    }
}
