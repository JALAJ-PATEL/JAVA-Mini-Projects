// Find the minimum and maximum numbers in a list of numbers using parallel threads in Java

package OOPS;

import java.util.ArrayList;
import java.util.List;

class MinFinderThread extends Thread {
    private List<Integer> numbers;
    private int min;

    public MinFinderThread(List<Integer> numbers) {
        this.numbers = numbers;
        this.min = Integer.MAX_VALUE;
    }

    public int getMin() {
        return min;
    }

    @Override
    public void run() {
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
    }
}

class MaxFinderThread extends Thread {
    private List<Integer> numbers;
    private int max;

    public MaxFinderThread(List<Integer> numbers) {
        this.numbers = numbers;
        this.max = Integer.MIN_VALUE;
    }

    public int getMax() {
        return max;
    }

    @Override
    public void run() {
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
    }
}

public class ParallelMinMax {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        // Populate the list with 50 numbers
        for (int i = 1; i <= 50; i++) {
            numbers.add(i);
        }

        // Create threads to find minimum and maximum numbers
        MinFinderThread minThread = new MinFinderThread(numbers);
        MaxFinderThread maxThread = new MaxFinderThread(numbers);

        // Start the threads
        minThread.start();
        maxThread.start();

        try {
            // Wait for both threads to complete using join
            minThread.join();
            maxThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the results from the threads
        int min = minThread.getMin();
        int max = maxThread.getMax();

        // Display the results
        System.out.println("Minimum number in the list: " + min);
        System.out.println("Maximum number in the list: " + max);
    }
}