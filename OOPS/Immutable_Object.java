// Write a program to create immutable objects having student id.  

package OOPS;

public class Immutable_Object {
    private final int id;

    public Immutable_Object(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static void main(String[] args) {
        Immutable_Object student = new Immutable_Object(123);
        System.out.println("Student ID: " + student.getId());
    }
}
