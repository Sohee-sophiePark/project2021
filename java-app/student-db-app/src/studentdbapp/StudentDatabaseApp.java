package studentdbapp;

import java.util.Scanner;

public class StudentDatabaseApp {
    public static void main(String[] args) {
        // test case: stu1
        // Student stu1 = new Student();
        // stu1.enroll();
        // stu1.payTuition();
        // stu1.vewBalance();
        // stu1.getInfo();
        
        // Ask how many students to add
        System.out.println("Enter Number of Students to Enroll: ");
        Scanner in = new Scanner(System.in);
        int in_students = in.nextInt();
        Student[] students = new Student[in_students];

        // Create a number of new students
        for (int n = 0; n < in_students; n++){
            students[n] = new Student();
            students[n].enroll();
            students[n].payTuition();
        }

        for (int n = 0; n < in_students; n++){
            students[n].getInfo();
        }
    }
}
