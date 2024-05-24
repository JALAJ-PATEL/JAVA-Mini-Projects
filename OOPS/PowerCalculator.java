/**
 * Write a method for computing x^y doing repetitive multiplication.
 * X and y are of type integer and are to be given as command line arguments.
 * Raise and handle exception(s) for invalid values of x and y.
 */

 package OOPS;

 public class PowerCalculator {

    // Method to compute x^y using repetitive multiplication
    public static int power(int x, int y) throws IllegalArgumentException {
        if (y < 0) {
            throw new IllegalArgumentException("Exponent (y) cannot be negative.");
        }

        int result = 1;
        for (int i = 0; i < y; i++) {
            result *= x;
        }
        return result;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide exactly two integer arguments: x and y.");
            return;
        }

        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);

            int result = power(x, y);
            System.out.println(x + "^" + y + " = " + result);

        } catch (NumberFormatException e) {
            System.out.println("Both x and y should be valid integers.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}