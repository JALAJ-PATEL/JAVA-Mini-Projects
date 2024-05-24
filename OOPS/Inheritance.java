package OOPS;

// Parent class
class Car {
    public void start() {
        System.out.println("Car is starting");
    }

    public void accelerate() {
        System.out.println("Car is accelerating");
    }

    public void stop() {
        System.out.println("Car is stopping");
    }
}

// Single inheritance: Audi inherits from Car
class Audi extends Car {
    public void audiSpecificFeature() {
        System.out.println("Audi has Quattro all-wheel drive");
    }
}

// Multi-level inheritance: Porsche inherits from Audi
class Porsche extends Audi {
    public void porscheSpecificFeature() {
        System.out.println("Porsche has rear-engine layout");
    }
}

// Hierarchical inheritance: Ferrari and Lamborghini both inherit from Car
class Ferrari extends Car {
    public void ferrariSpecificFeature() {
        System.out.println("Ferrari has prancing horse logo");
    }
}

class Lamborghini extends Car {
    public void lamborghiniSpecificFeature() {
        System.out.println("Lamborghini has iconic scissor doors");
    }
}

// Main class
public class Inheritance {
    public static void main(String[] args) {
        // Single inheritance example
        Audi audi = new Audi();
        audi.start();  // Inherited from Car
        audi.accelerate(); // Inherited from Car
        audi.stop(); // Inherited from Car
        audi.audiSpecificFeature(); // Specific to Audi

        // Multi-level inheritance example
        Porsche porsche = new Porsche();
        porsche.start();  // Inherited from Car
        porsche.accelerate(); // Inherited from Car
        porsche.stop(); // Inherited from Car
        porsche.audiSpecificFeature(); // Inherited from Audi
        porsche.porscheSpecificFeature(); // Specific to Porsche

        // Hierarchical inheritance examples
        Ferrari ferrari = new Ferrari();
        ferrari.start();  // Inherited from Car
        ferrari.accelerate(); // Inherited from Car
        ferrari.stop(); // Inherited from Car
        ferrari.ferrariSpecificFeature(); // Specific to Ferrari

        Lamborghini lamborghini = new Lamborghini();
        lamborghini.start();  // Inherited from Car
        lamborghini.accelerate(); // Inherited from Car
        lamborghini.stop(); // Inherited from Car
        lamborghini.lamborghiniSpecificFeature(); // Specific to Lamborghini
    }
}
