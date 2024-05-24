package OOPS;

import java.io.IOException;

// Custom Exception class that extends Exception (a Throwable subclass)
class CustomException extends Exception {
    // Constructor to set the error message
    public CustomException(String message) {
        super(message);
    }
}

// Class with methods using throw, throws, and catching Throwable
public class ExceptionHandlingExample {
    // Method using throw to manually throw an exception
    public static void throwError() throws CustomException {
        throw new CustomException("This is a custom exception thrown using throw keyword.");
    }

    // Method using throws to declare that it may throw an IOException
    public static void throwIOException() throws IOException {
        throw new IOException("This is an IOException thrown using throws keyword.");
    }

    // Main method to demonstrate exception handling
    public static void main(String[] args) {
        try {
            // Call throwError() method
            throwError();
        } catch (CustomException e) {
            System.out.println("Caught CustomException: " + e.getMessage());
        }

        try {
            // Call throwIOException() method
            throwIOException();
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        } catch (Throwable t) {
            System.out.println("Caught Throwable: " + t.getMessage());
        }
    }
}