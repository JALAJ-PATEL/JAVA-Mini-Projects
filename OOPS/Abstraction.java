package OOPS;

// Abstract class representing a Laptop
abstract class Laptop {
    // Abstract method for powering on
    public abstract void powerOn();

    // Abstract method for powering off
    public abstract void powerOff();

    // Concrete method for displaying brand name
    public void displayBrand() {
        System.out.println("Brand: " + getBrand());
    }

    // Abstract method to get the brand name
    public abstract String getBrand();
}

// Concrete class representing a Dell Laptop
class DellLaptop extends Laptop {
    @Override
    public void powerOn() {
        System.out.println("Dell Laptop is powering on");
    }

    @Override
    public void powerOff() {
        System.out.println("Dell Laptop is powering off");
    }

    @Override
    public String getBrand() {
        return "Dell";
    }
}

// Concrete class representing an HP Laptop
class HPLaptop extends Laptop {
    @Override
    public void powerOn() {
        System.out.println("HP Laptop is powering on");
    }

    @Override
    public void powerOff() {
        System.out.println("HP Laptop is powering off");
    }

    @Override
    public String getBrand() {
        return "HP";
    }
}

// Concrete class representing an Apple Laptop
class AppleLaptop extends Laptop {
    @Override
    public void powerOn() {
        System.out.println("Apple Laptop is powering on");
    }

    @Override
    public void powerOff() {
        System.out.println("Apple Laptop is powering off");
    }

    @Override
    public String getBrand() {
        return "Apple";
    }
}

// Concrete class representing a Samsung Laptop
class SamsungLaptop extends Laptop {
    @Override
    public void powerOn() {
        System.out.println("Samsung Laptop is powering on");
    }

    @Override
    public void powerOff() {
        System.out.println("Samsung Laptop is powering off");
    }

    @Override
    public String getBrand() {
        return "Samsung";
    }
}

// Main class
public class Abstraction {
    public static void main(String[] args) {
        // Creating objects of different laptop brands
        Laptop dellLaptop = new DellLaptop();
        Laptop hpLaptop = new HPLaptop();
        Laptop appleLaptop = new AppleLaptop();
        Laptop samsungLaptop = new SamsungLaptop();

        // Powering on and off laptops
        dellLaptop.powerOn();
        dellLaptop.powerOff();
        dellLaptop.displayBrand();

        hpLaptop.powerOn();
        hpLaptop.powerOff();
        hpLaptop.displayBrand();

        appleLaptop.powerOn();
        appleLaptop.powerOff();
        appleLaptop.displayBrand();

        samsungLaptop.powerOn();
        samsungLaptop.powerOff();
        samsungLaptop.displayBrand();
    }
}
