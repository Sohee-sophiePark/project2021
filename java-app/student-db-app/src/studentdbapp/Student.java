package studentdbapp;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeyear;
    private String studentID;
    private String courses = "";
    private double tuitionBalance;
    private static double costOfCourse = 600.00;
    private static int id = 1001;

    // Constructor - prompt user to enter student's name and year
    public Student(){
        Scanner in = new Scanner(System.in);        
        System.out.println("Enter Student's First Name:");
        this.firstName =  in.nextLine();
        System.out.println("Enter Student's Last Name:");
        this.lastName = in.nextLine();
        System.out.println("Enter Student's Grade Year:\n1. Freshmen\n2. Sophomore\n3. Junior\n4. Senior");
        this.gradeyear = in.nextInt();

        setStudnetId();
        // enroll();
        
        String infoString = this.firstName 
        + "\n" + this.lastName 
        + "\n" + this.gradeyear 
        + "\n" + this.studentID;
        System.out.println(infoString);
    }
    
    // Generate an ID
    private void setStudnetId(){
        // Static
        id++;
        this.studentID = gradeyear+ "" + id; //automatic casting
        System.out.println(studentID);
    }


    // Enroll in courses
    public void enroll(){
        do {
            // get Inside a loop - user hits 0
            System.out.println("Enter course to Enroll (0 to Quit)");
            Scanner in = new Scanner(System.in);
            String in_course = "";
            in_course = in.nextLine();
            if(!in_course.equalsIgnoreCase("0")){
                courses  = courses + "\n - " + in_course;
                tuitionBalance = tuitionBalance + costOfCourse;
            }
            else{ break;}
        }while(true);
        System.out.println("TUITION BALANCED: " + tuitionBalance);        
        System.out.println("ENROLLED IN: " + courses);
    }


    // View balance 
    public void vewBalance(){
        System.out.println("Your Balance is "+tuitionBalance);
    }

    // Pay Tuition
    public void payTuition(){
        vewBalance();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Amount of Payment: ");
        double in_payment = in.nextDouble();
        System.out.println("PAID: " + in_payment);
        tuitionBalance = tuitionBalance - in_payment;
    }

    // Show Status
    public void getInfo(){
        String line = "--------------------------\n";
        String info = 
        "* STUDENT ID: " + studentID + "\n" +
        "* NAME: " + firstName + " " + lastName + "\n" +
        "* YEAR: " + gradeyear + "\n" +
        "* COURSES: " + courses + "\n" +
        "* CURRENT BALANCE: $" + tuitionBalance + "\n";
        String out = line + info + line;
        System.out.println(out);
        
        
    }
    
}
