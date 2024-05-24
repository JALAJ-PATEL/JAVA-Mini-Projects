// Write down basic block of code that throws an user-defined exception with a custom message.

package OOPS;

// Class representing a user-defined exception
class UserDefinedException extends Exception {
    // Constructor that accepts a custom message
    public UserDefinedException(String str) {
        // Calling the constructor of the parent Exception class
        super(str);
    }
}

// Class that uses the above UserDefinedException
public class UDE {
    public static void main(String[] args) {
        try {
            // Throw an object of user-defined exception
            throw new UserDefinedException("This is a user-defined exception");
        } catch (UserDefinedException ude) {
            // Catch the user-defined exception
            System.out.println("Caught the exception");
            // Print the message from the UserDefinedException object
            System.out.println(ude.getMessage());
        }
    }
}
