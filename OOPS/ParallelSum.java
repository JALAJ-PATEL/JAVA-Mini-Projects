/* 
Do sum in parallel. One thread adds only even numbers from the list, 
while the 2nd thread does the sum of odd numbers. Main combined sum.
*/
package OOPS;

import java.util.ArrayList;
import java.util.List;

class EvenSumThread extends Thread {
    private List<Integer> numbers;
    private int evenSum;

    public EvenSumThread(List<Integer> numbers) {
        this.numbers = numbers;
        this.evenSum = 0;
    }

    public int getEvenSum() {
        return evenSum;
    }

    @Override
    public void run() {
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenSum += number;
            }
        }
    }
}

class OddSumThread extends Thread {
    private List<Integer> numbers;
    private int oddSum;

    public OddSumThread(List<Integer> numbers) {
        this.numbers = numbers;
        this.oddSum = 0;
    }

    public int getOddSum() {
        return oddSum;
    }

    @Override
    public void run() {
        for (int number : numbers) {
            if (number % 2 != 0) {
                oddSum += number;
            }
        }
    }
}

public class ParallelSum {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        // Populate the list with 50 numbers
        for (int i = 1; i <= 50; i++) {
            numbers.add(i);
        }

        // Create threads to sum even and odd numbers
        EvenSumThread evenThread = new EvenSumThread(numbers);
        OddSumThread oddThread = new OddSumThread(numbers);

        // Start the threads
        evenThread.start();
        oddThread.start();

        try {
            // Wait for both threads to complete using join
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the sums from the threads
        int evenSum = evenThread.getEvenSum();
        int oddSum = oddThread.getOddSum();

        // Calculate the final sum
        int finalSum = evenSum + oddSum;

        // Display the results
        System.out.println("Sum of 50 numbers: " + finalSum);
    }
}