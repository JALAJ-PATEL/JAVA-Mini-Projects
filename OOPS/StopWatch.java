/*
 Write a program that defines class named StopWatch. The class contains:
• Private data fields startTime and endTime with getter methods.
• no-arg constructor that initializes startTime with the current time.
• A method named start() that resets the startTime to the current time.
• A method named stop() that sets the endTime to the current time.
• A method named getElapsedTime() that returns the elapsed time for 
  the stopwatch in milliseconds.
• Declare object of StopWatch to demonstrate stop watch.
Hint: Use System.currentTimeMillis() to get current time in milliseconds.

 */

package OOPS;

public class StopWatch {
    // Private data fields
    private long startTime;
    private long endTime;

    // Getter methods
    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    // No-arg constructor that initializes startTime with the current time
    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    // Method to reset the startTime to the current time
    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    // Method to set the endTime to the current time
    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    // Method to get the elapsed time in milliseconds
    public long getElapsedTime() {
        return endTime - startTime;
    }

    // Main method to demonstrate the StopWatch
    public static void main(String[] args) {
        // Create a StopWatch object
        StopWatch stopwatch = new StopWatch();

        // Simulate some process by sleeping for 2 seconds
        try {
            Thread.sleep(2000); // Sleep for 2000 milliseconds (2 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop the stopwatch
        stopwatch.stop();

        // Display the elapsed time
        System.out.println("Elapsed time in milliseconds: " + stopwatch.getElapsedTime());
    }
}