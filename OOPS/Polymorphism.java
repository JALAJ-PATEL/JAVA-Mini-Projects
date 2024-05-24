package OOPS;

// Parent class
class Animal {
    // Method to make sound
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass Dog
class Dog extends Animal {
    // Method overriding
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

// Subclass Cat
class Cat extends Animal {
    // Method overriding
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}

// Main class
public class Polymorphism {
    public static void main(String[] args) {
        // Creating objects of Animal, Dog, and Cat
        Animal animal = new Animal();
        Animal dog = new Dog(); // Upcasting
        Animal cat = new Cat(); // Upcasting

        // Calling makeSound method
        animal.makeSound(); // Calls Animal's makeSound
        dog.makeSound();    // Calls Dog's makeSound
        cat.makeSound();    // Calls Cat's makeSound
    }
}
