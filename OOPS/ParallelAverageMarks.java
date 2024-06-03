/*
A student has multiple courses with course name and marks attributes. (Association) . 
Create a list of students with different subjects. Provide average of student marks. 10-10-10 parallel. 
Means 1thread do calculation of 10 Students. 2nd thread 10, main also 10student. 
After 10 students calculation, Main wait for all to complete.
 */

package OOPS;

import java.util.ArrayList;
import java.util.List;

class Subject {
    private String subjectName;
    private int marks;

    public Subject(String subjectName, int marks) {
        this.subjectName = subjectName;
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    public String getSubjectName() {
        return subjectName;
    }
}

class Learner {
    private String name;
    private List<Subject> subjects;

    public Learner(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public double getAverageMarks() {
        int totalMarks = 0;
        for (Subject subject : subjects) {
            totalMarks += subject.getMarks();
        }
        return (double) totalMarks / subjects.size();
    }
}

class AverageMarksThread extends Thread {
    private List<Learner> learners;
    private int startIndex;
    private int endIndex;
    private double partialAverage;

    public AverageMarksThread(List<Learner> learners, int startIndex, int endIndex) {
        this.learners = learners;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.partialAverage = 0;
    }

    public double getPartialAverage() {
        return partialAverage;
    }

    @Override
    public void run() {
        double sum = 0;
        for (int i = startIndex; i < endIndex; i++) {
            sum += learners.get(i).getAverageMarks();
        }
        partialAverage = sum / (endIndex - startIndex);
    }
}

public class ParallelAverageMarks {
    public static void main(String[] args) {
        List<Learner> learners = new ArrayList<>();
        // Populate the list with 30 learners, each having different subjects and marks
        for (int i = 1; i <= 30; i++) {
            List<Subject> subjects = new ArrayList<>();
            subjects.add(new Subject("OS", (int) (Math.random() * 100)));
            subjects.add(new Subject("OOP", (int) (Math.random() * 100)));
            subjects.add(new Subject("DMGT", (int) (Math.random() * 100)));
            learners.add(new Learner("Student" + i, subjects));
        }

        // Create threads to calculate the average marks for 10 learners each
        AverageMarksThread thread1 = new AverageMarksThread(learners, 0, 10);
        AverageMarksThread thread2 = new AverageMarksThread(learners, 10, 20);

        // Start the threads
        thread1.start();
        thread2.start();

        // Main thread calculates the average marks for the remaining 10 learners
        double mainThreadSum = 0;
        for (int i = 20; i < 30; i++) {
            mainThreadSum += learners.get(i).getAverageMarks();
        }
        double mainThreadAverage = mainThreadSum / 10;

        try {
            // Wait for both threads to complete using join
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the partial averages from the threads
        double thread1Average = thread1.getPartialAverage();
        double thread2Average = thread2.getPartialAverage();

        // Calculate the final average
        double finalAverage = (thread1Average + thread2Average + mainThreadAverage) / 3;

        // Display the results
        System.out.println("Average marks of all Students: " + finalAverage);
    }
}