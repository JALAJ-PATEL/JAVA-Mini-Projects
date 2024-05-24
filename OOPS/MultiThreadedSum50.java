/*
 Write a program to execute sum of 50 numbers using multi-threading program. Follow below instructions. 

- Create a single list containing 50 numbers. 

- Create at-least 2 sub-threads to execute sum of 15-15numbers. While main also summing up 20 numbers. 

- Use join in main to wait for sub-threads to complete execution and provide final sum of 50 numbers from main. 

 */

package OOPS;

import java.util.ArrayList;
import java.util.List;

class SumThread extends Thread {
    private List<Integer> numbers;
    private int startIndex;
    private int endIndex;
    private int partialSum;

    public SumThread(List<Integer> numbers, int startIndex, int endIndex) {
        this.numbers = numbers;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.partialSum = 0;
    }

    public int getPartialSum() {
        return partialSum;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            partialSum += numbers.get(i);
        }
    }
}

public class MultiThreadedSum50 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        // Populate the list with 50 numbers
        for (int i = 1; i <= 50; i++) {
            numbers.add(i);
            System.out.println(numbers.get(i-1));
        }

        // Create two threads to sum 15 numbers each
        SumThread thread1 = new SumThread(numbers, 0, 15);
        SumThread thread2 = new SumThread(numbers, 15, 30);

        // Start the threads
        thread1.start();
        thread2.start();
        
        // Main thread sums the remaining 20 numbers
        int mainThreadSum = 0;
        for (int i = 30; i < 50; i++) {
            mainThreadSum += numbers.get(i);
        }
        
        try {
            // Wait for both threads to complete using join
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the partial sums from the threads
        int thread1Sum = thread1.getPartialSum();
        int thread2Sum = thread2.getPartialSum();

        // Calculate the final sum
        int finalSum = mainThreadSum + thread1Sum + thread2Sum;

        // Display the results
        System.out.println("Sum of 50 numbers: " + finalSum);
    }
}