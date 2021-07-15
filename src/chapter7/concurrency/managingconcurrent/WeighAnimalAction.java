package chapter7.concurrency.managingconcurrent;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class WeighAnimalAction extends RecursiveAction { // RecursiveAction and RecursiveTask implement ForkJoinTask
    private int start;
    private int end;
    private Double[] weights;

    public WeighAnimalAction(Double[] weights, int start, int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    @Override
    protected void compute() {
        if(end-start <= 3) {
            for(int i = start; i < end; i++) {
                weights[i] = (double)new Random().nextInt(100);
                System.out.println("Animal Weighed: " + i);
            }
        } else {
            int middle = start+((end-start)/2);
            System.out.println("[start=" + start + ",middle=" + middle + ",end=" + end + "]");
            invokeAll(new WeighAnimalAction(weights,start,middle),
                    new WeighAnimalAction(weights,middle,end));
        }
    }

    public static void main(String[] args) {
        Double[] weights = new Double[10];

        // Applying the fork/join framework requires us to perform three steps:
        // Step 1: Create a ForkJoinTask
        ForkJoinTask<?> task = new WeighAnimalAction(weights, 0, weights.length);

        // Step 2: Create the ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Step 3: Start the ForkJoinTask
        pool.invoke(task);

        // Print results
        System.out.println();
        System.out.print("Weights: ");
        Arrays.asList(weights).stream().forEach(
                d -> System.out.print(d.intValue()+" "));
    }
}
