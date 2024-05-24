// Write a program to convert a decimal number to binary. 
// For example, Input:10 => Output:1010

package OOPS;

public class Decimal_to_Binary {

    public static String convertDecimalToBinary(int num){
        if(num == 0){
            return "0";
        }

        String binary = "";
        while (num > 0) {
            int remainder = num % 2;
            binary = remainder + binary;
            num = num / 2;
        }
        return binary;
    }

    public static void main(String[] args) {
        int decimal = 10;
        String binary = convertDecimalToBinary(decimal);
        System.out.println("Binary representation of " + decimal + " is " + binary);
    }
}
