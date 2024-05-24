/* Define use of super. Demonstrate use of super using the 
 Person -> Employee class- >subclass hierarchy using java code. */

package OOPS;

class Person {
    String name;
    String adhar;

    Person(String name, String adhar) {
        this.name = name;
        this.adhar = adhar;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Adhar: " + adhar);
    }
}

class Employee extends Person {
    int employeeId;

    Employee(String name, String adhar, int employeeId) {
        super(name, adhar); // Calling superclass constructor
        this.employeeId = employeeId;
    }

    void display() {
        super.display(); // Calling superclass method
        System.out.println("Employee ID: " + employeeId);
    }
}

public class Super_Keyword {
    public static void main(String[] args) {
        Employee emp = new Employee("Jalaj", "1106", 0001);
        emp.display();
    }
}