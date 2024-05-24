// Write down a java code to implementation 1) Abstract class, 2) Interface. 
// Each program must have at least one subclass and two methods. 

package OOPS;

interface Animal {
    // Abstract methods (no body)
    void sound();
    void eat();
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("The dog barks.");
    }

    @Override
    public void eat() {
        System.out.println("The dog eats.");
    }

    // Additional method specific to Dog
    void run() {
        System.out.println("The dog runs.");
    }
}

public class Interface_Class {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();
        dog.eat();
        dog.run();
    }
}
