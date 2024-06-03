// This program demonstrates how to find the minimum number in a list of numbers using parallel processing.

package OOPS;

import java.util.ArrayList;
import java.util.List;

class MinThread extends Thread {
    private List<Integer> numbers;
    private int startIndex;
    private int endIndex;
    private int min;

    public MinThread(List<Integer> numbers, int startIndex, int endIndex) {
        this.numbers = numbers;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.min = Integer.MAX_VALUE;
    }

    public int getMin() {
        return min;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            if (numbers.get(i) < min) {
                min = numbers.get(i);
            }
        }
    }
}

public class ParallelMin {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        // Populate the list with 50 numbers
        for (int i = 1; i <= 50; i++) {
            numbers.add(i);
        }

        // Create three threads to find the minimum number in different segments
        MinThread thread1 = new MinThread(numbers, 0, 10);
        MinThread thread2 = new MinThread(numbers, 10, 20);
        MinThread thread3 = new MinThread(numbers, 20, 30);
        MinThread thread4 = new MinThread(numbers, 30, 40);
        MinThread thread5 = new MinThread(numbers, 40, 50);

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

        // Get the minimum values from each thread
        int finalMin = Math.min(thread1.getMin(), 
                        Math.min(thread2.getMin(), 
                        Math.min(thread3.getMin(), 
                        Math.min(thread4.getMin(), thread5.getMin()))));

        // Display the results
        System.out.println("Minimum number in the list: " + finalMin);
    }
}