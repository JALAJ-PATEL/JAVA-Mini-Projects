// Write down basic block of code that handles an division by zero exception and shows a custom message in output: “Infinity”.

package OOPS;

public class DivisionByZeroHandling {
    public static void main(String[] args) {
        try {
            // Attempt to divide by zero
            int numerator = 10;
            int denominator = 0;
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Handle the division by zero exception
            System.out.println("Infinity");
        }
    }
}