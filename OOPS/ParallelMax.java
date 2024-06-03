// Find the maximum number in a list of numbers using parallel threads

package OOPS;

import java.util.ArrayList;
import java.util.List;

class MaxThread extends Thread {
    private List<Integer> numbers;
    private int startIndex;
    private int endIndex;
    private int max;

    public MaxThread(List<Integer> numbers, int startIndex, int endIndex) {
        this.numbers = numbers;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.max = Integer.MIN_VALUE;
    }

    public int getMax() {
        return max;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }
    }
}

public class ParallelMax {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        // Populate the list with 50 numbers
        for (int i = 1; i <= 50; i++) {
            numbers.add(i);
        }

        // Create three threads to find the maximum number in different segments
        MaxThread thread1 = new MaxThread(numbers, 0, 10);
        MaxThread thread2 = new MaxThread(numbers, 10, 20);
        MaxThread thread3 = new MaxThread(numbers, 20, 30);
        MaxThread thread4 = new MaxThread(numbers, 30, 40);
        MaxThread thread5 = new MaxThread(numbers, 40, 50);

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            // Wait for all threads to complete using join
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the maximum values from each thread
        int finalMax = Math.max(thread1.getMax(), 
                        Math.max(thread2.getMax(), 
                        Math.max(thread3.getMax(), 
                        Math.max(thread4.getMax(), thread5.getMax()))));

        // Display the results
        System.out.println("Maximum number in the list: " + finalMax);
    }
}