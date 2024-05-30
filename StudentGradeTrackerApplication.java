package StudentGradeTracker;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTrackerApplication {
    private ArrayList<Double> grades;

    public StudentGradeTrackerApplication() {
        grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public double findHighest() {
        if (grades.isEmpty()) return 0.0;
        double highest = grades.get(0);
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    public double findLowest() {
        if (grades.isEmpty()) return 0.0;
        double lowest = grades.get(0);
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeTrackerApplication gradeTracker = new StudentGradeTrackerApplication();

        System.out.println("Enter grades (type 'done' to finish):");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                double grade = Double.parseDouble(input);
                gradeTracker.addGrade(grade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid grade.");
            }
        }

        double average = gradeTracker.calculateAverage();
        double highest = gradeTracker.findHighest();
        double lowest = gradeTracker.findLowest();

        System.out.println("Average grade: " + average);
        System.out.println("Highest grade: " + highest);
        System.out.println("Lowest grade: " + lowest);
    }
}

