// Write down a java code to implementation 1) Abstract class, 2) Interface. 
// Each program must have at least one subclass and two methods. 

package OOPS;

abstract class Shape {
    // Abstract method (does not have a body)
    abstract double area();
    
    // Regular method
    void display() {
        System.out.println("This is a shape.");
    }
}

class Circle extends Shape {
    private double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    // Implementing the abstract method
    @Override
    double area() {
        return Math.PI * radius * radius;
    }
    
    // Additional method specific to Circle
    double circumference() {
        return 2 * Math.PI * radius;
    }
}

public class Abstract_Class {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        circle.display();
        System.out.println("Area of Circle: " + circle.area());
        System.out.println("Circumference of Circle: " + circle.circumference());
    }
}
