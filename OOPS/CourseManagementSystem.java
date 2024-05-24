/*
 Write a program to associate courses taken by students and list all of them.

Include search by student by id or name functionality, it should show all details including courses taken by students. I.e. List all the courses taken by a student.

A Course class can have properties like Course_name, Credit, Max_marks.

 */

package OOPS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String courseName;
    private int credit;
    private int maxMarks;

    Course(String courseName, int credit, int maxMarks) {
        this.courseName = courseName;
        this.credit = credit;
        this.maxMarks = maxMarks;
    }

    void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    void setCredit(int credit) {
        this.credit = credit;
    }

    void setMaxMarks(int maxMarks) {
        this.maxMarks = maxMarks;
    }

    String getCourseName() {
        return courseName;
    }

    int getCredit() {
        return credit;
    }

    int getMaxMarks() {
        return maxMarks;
    }

    Course searchByName(List<Course> courses, String name) {
        for (Course course : courses) {
            if (course.courseName.equals(name)) {
                return course;
            }
        }
        return null;
    }

    Course searchByCredit(List<Course> courses, int credit) {
        for (Course course : courses) {
            if (course.credit == credit) {
                return course;
            }
        }
        return null;
    }
}

class Student {
    static List<Student> students = new ArrayList<>();
    private int id;
    private String name;
    List<Course> courses = new ArrayList<>();
    
    Student(int id, String name) {
        this.id = id;
        this.name = name;
        students.add(this);
    }

    void addCourse(Course course) {
        this.courses.add(course);
    }

    Student searchById(int id) {
        for (Student student : students) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }

    Student searchByName(String name) {
        for (Student student : students) {
            if (student.name.equals(name)) {
                return student;
            }
        }
        return null;
    }
    
    void searchStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name or ID: ");
        String input = scanner.nextLine();
        scanner.close();

        Student searchedStudent;
        if (input.matches("\\d+")) {
            int id = Integer.parseInt(input);
            searchedStudent = searchById(id);
        } else {
            searchedStudent = searchByName(input);
        }

        if (searchedStudent != null) {
            System.out.println("Found student: " + searchedStudent.name);
            System.out.println("Courses taken by the student:");
            for (Course course : searchedStudent.courses) {
                System.out.println("Course: " + course.getCourseName());
                System.out.println("Credit: " + course.getCredit());
                System.out.println("Max Marks: " + course.getMaxMarks());
            }
        } else {
            System.out.println("Student not found.");
        }
    }
}

public class CourseManagementSystem {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Jalaj");
        Student s2 = new Student(2, "Jainil");
        Student s3 = new Student(3, "Het");
        Student s4 = new Student(4, "Matang");

        Course c1 = new Course("OOPS - JAVA", 4, 100);
        Course c2 = new Course("DBMS", 5, 99);
        Course c3 = new Course("Data Structures", 4, 95);
        Course c4 = new Course("Operating Systems", 5, 98);

        s1.addCourse(c1);
        s1.addCourse(c2);
        s1.addCourse(c4);

        s2.addCourse(c1);
        s2.addCourse(c3);

        s3.addCourse(c4);
        s3.addCourse(c2);

        s4.addCourse(c1);
        s4.addCourse(c2);
        s4.addCourse(c4);

        Student student = new Student(0, "");
        student.searchStudent();
    }
}