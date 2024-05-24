// Write a program to multiply two numbers using constructor. 

package OOPS;

public class Multiply_2_No_Constructor {
    private int result;

    public Multiply_2_No_Constructor(int num1, int num2) {
        this.result = num1 * num2;
    }

    public int getResult() {
        return this.result;
    }

    public static void main(String[] args) {
        Multiply_2_No_Constructor multiply = new Multiply_2_No_Constructor(5, 10);
        System.out.println("The result is: " + multiply.getResult());
    }
}