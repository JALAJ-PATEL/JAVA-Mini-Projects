/* Compile-time polymorphism is achieved through method overloading, where multiple methods 
 with the same name but different parameter lists can exist in the same class. The appropriate 
method is determined at compile time based on the number and type of arguments.
*/

package OOPS;


class Calculator {
    void add(int a, int b) {
        System.out.println("Sum of integers: " + (a + b));
    }

    void add(double a, double b) {
        System.out.println("Sum of doubles: " + (a + b));
    }
}

public class Method_Overloading {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.add(5, 3); // Calls the first add method
        calc.add(2.5, 3.7); // Calls the second add method
    }
}