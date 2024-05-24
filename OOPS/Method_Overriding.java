/* - Runtime polymorphism is achieved through method overriding, where a subclass provides 
a specific implementation of a method that is already provided by its superclass. The method to be 
called is determined at runtime based on the actual object type. */

package OOPS;


class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Method_Overriding {
    public static void main(String[] args) {
        Animal pet;
        pet = new Dog();
        pet.sound(); // Calls Dog's sound method

        pet = new Cat();
        pet.sound(); // Calls Cat's sound method
    }
}