/*
Write following programs in java.
Write program to implement polymorphism, abstraction, inheritance and encapsulation.
#. Create a blue print interface for person class
#. Create person class implement search by name and by adhar functions
#. Create Employee class and override search by adhar function with search by Employee id
#. Make sure all classes are encapsulated.
#. Use object list to store and search for objects. Return entire object if found.
 */

package OOPS;

import java.util.ArrayList;
import java.util.Scanner;

public class Office {
    public static void main(String[] args) {
        Person admin = new Person("admin", 1000000000, false);
        Employee adminEmployee = new Employee("admin", 1000000000, 0);

        new Person("Jalaj", 22013, false);
        new Person("Jainil", 220137, false);
        new Employee("Het", 220133, 1);
        new Employee("Matang", 220144, 2);

        Scanner sc = new Scanner(System.in);
        System.out.println("What search parameter do you want to use?");
        System.out.println("1 - Name\n2 - Adhar No.\n3 - EmployeeId\n");
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();

        if(choice == 1) {
            System.out.println("Enter the Name: ");
            String name = sc.next().toLowerCase();
            Person person = admin.search(name);
            Employee employee = adminEmployee.search(name);
            if(employee != null) {
                employee.getEmployee();
            } else if(person != null) {
                person.getPerson();
            } else {
                System.out.println("No such Person Found");
            } 
        } else if(choice == 2) {
            System.out.println("Enter the Adhar No.: ");
            int adhar = sc.nextInt();
            Person person = admin.search(adhar);
            if(person != null) {
                person.getPerson();
            } else {
                System.out.println("No such Person Found");
            }
        } else if(choice == 3) {
            System.out.println("Enter the Employee-Id: ");
            int employeeId = sc.nextInt();
            Employee employee = adminEmployee.search(employeeId);
            if(employee != null) {
                employee.getEmployee();
            } else {
                System.out.println("No such Employee Found");
            }
        } else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }
}

interface PersonInterface {
    public Person search(String name);
}

class Person implements PersonInterface {
    private static ArrayList<Person> people = new ArrayList<>();
    private String name;
    private int adhar;

    public Person(String name, int adhar, boolean isEmployee) {
        this.name = name;
        this.adhar = adhar;
        if(!isEmployee) {
            people.add(this);
        }
        // System.out.println(people.toString());
    }

    public String getName() {
        return name;
    }
    public int getAdhar() {
        return adhar;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAdhar(int adhar) {
        this.adhar = adhar;
    }

    public void getPerson() {
        System.out.println("Name: " + this.name + " Adhar: " + this.adhar);
    }

    @Override
    public Person search(String name) {
        for(Person person : people) {
            if(person.name.equals(name)) {
                return person;
            }
        }
        return null;
    }
    
    public Person search(int adhar) {
        for(Person person : people) {
            if(person.adhar == adhar) {
                return person;
            }
        }
        return null;
    }
}

class Employee extends Person {
    
    private static ArrayList<Employee> employees = new ArrayList<>();
    private int employeeId;
    
    public Employee(String name, int adhar, int employeeId) {
        super(name, adhar, true);
        this.employeeId = employeeId;
        employees.add(this);
        // System.out.println(employees.toString());
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    public void getEmployee() {
        System.out.println("Name: " + this.getName() + " Adhar: " + this.getAdhar() + " Employee ID: " + this.getEmployeeId());
    }

    public Employee search(String name) {
        for(Employee employee : employees) {
            if(employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public Employee search(int employeeId) {
        for(Employee employee : employees) {
            if(employee.employeeId == employeeId) {
                return employee;
            }
        }
        return null;
    }
}