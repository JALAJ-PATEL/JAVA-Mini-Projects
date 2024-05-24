/*
--> Create a class called Employee that includes:
I.  Three instance variables— id (type String), name (type String) and 
    monthly_salary (double). 
II. A default constructor that initializes the three instance variables. 
III.A setter and a getter method for each instance variable (for example 
    for id variable void setId(String id), String getId( )). 
IV. displayEmployee() method for displaying employee details.

Write a driver class named EmployeeTest that demonstrates class Employee’s 
capabilities. Create two Employee objects and display each object’s yearly 
salary. Then give each Employee a 10% raise and display each Employee’s 
yearly salary again.

*/

package OOPS;

class Employee {
    // Instance variables
    private String id;
    private String name;
    private double monthlySalary;

    // Default constructor
    public Employee() {
        this.id = "";
        this.name = "";
        this.monthlySalary = 0.0;
    }

    // Parameterized constructor
    public Employee(String id, String name, double monthlySalary) {
        this.id = id;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    // Getter and setter methods
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary >= 0) {
            this.monthlySalary = monthlySalary;
        } else {
            System.out.println("Monthly salary cannot be negative.");
        }
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    // Method to display employee details
    public void displayEmployee() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Monthly Salary: " + monthlySalary);
    }

    // Method to calculate yearly salary
    public double getYearlySalary() {
        return monthlySalary * 12;
    }

    // Method to apply a raise
    public void applyRaise(double percentage) {
        if (percentage > 0) {
            monthlySalary += monthlySalary * percentage / 100;
        } else {
            System.out.println("Raise percentage must be positive.");
        }
    }
}
public class EmployeeTest {
    public static void main(String[] args) {
        // Create two Employee objects
        Employee employee1 = new Employee();
        employee1.setId("E001");
        employee1.setName("Jalaj");
        employee1.setMonthlySalary(500000.0);

        Employee employee2 = new Employee();
        employee2.setId("E002");
        employee2.setName("Jainil");
        employee2.setMonthlySalary(400000.0);

        // Display yearly salary for each employee
        System.out.println("Yearly Salary for Employee 1: " + employee1.getYearlySalary());
        System.out.println("Yearly Salary for Employee 2: " + employee2.getYearlySalary());

        // Apply a 10% raise to each employee
        double raisePercentage = 10.0;
        employee1.applyRaise(raisePercentage);
        employee2.applyRaise(raisePercentage);

        // Display yearly salary for each employee after the raise
        System.out.println("\nAfter Applying Raise of " + raisePercentage + "%:");
        System.out.println("Yearly Salary for Employee 1: " + employee1.getYearlySalary());
        System.out.println("Yearly Salary for Employee 2: " + employee2.getYearlySalary());

        // Display employee details
        System.out.println("\nEmployee 1 Details:");
        employee1.displayEmployee();
        
        System.out.println("\nEmployee 2 Details:");
        employee2.displayEmployee();
    }
}