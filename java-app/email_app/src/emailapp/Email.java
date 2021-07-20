package emailapp;

import java.util.Scanner;

public class Email { // access to class 
    private String firstName; // but encapsulation
    private String lastName;
    private String department;
    private String password;
    private int defaultPasswordLength = 10;
    private String email;
    private String companySuffix = "company.com";
    private int mailboxCapacity = 500;
    private String alternateEmail;

    // Custroctor to receive the first name and last name
    public Email(String in_fName, String in_lName){
        this.firstName = in_fName;
        this.lastName = in_lName;

        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);        

        // call a method asking for the depart - return it
        this.department = setDepartment();
        System.out.println("DEPARTMENT: " + this.department);

        // call a method - generate a random password
        this.password = randomPassword(defaultPasswordLength);
        // System.out.println("Your Password is: "+ this.password);

        // combine elements to generate email
        this.email = firstName.toLowerCase() 
        + "." + lastName.toLowerCase() 
        + "@" + this.department.toLowerCase() 
        + "." + companySuffix;
        System.out.println("Your Email is: " + this.email);

    }
    
    // Ask for the Department
    private String setDepartment(){
        System.out.print("DEPARTMENT CODES: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n"
        + "Hello! " 
        + firstName + ", " 
        + "Enter Department Codes >>> ");
            
            Scanner in = new Scanner(System.in);
            int deptChoice = in.nextInt();
            if (deptChoice == 1) { return "Sales"; }
            else if (deptChoice == 2) { return "Dev"; }
            else if (deptChoice == 3) { return "Acct"; }
            else { return "temp"; }
        }

    
    // Generate a Random Password
    private String randomPassword(int in_len){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$";
        char[] password = new char[in_len];
        char[] password_marked = new char[in_len];
        for (int i=0; i<in_len; i++){ // # of input length
            // set the range with passwordSet 0 to 40
            int rand = (int) (Math.random() * passwordSet.length()); 
            // set the random char for the input length of letters of password
            password[i] = passwordSet.charAt(rand);  
            password_marked[i] = '*';
        }

        System.out.print("PASSWORD CREATED: ");
        System.out.println(password_marked);
        // does not work
        // System.out.print("PASSWORD CREATED: " + password_marked.toString());          
        return new String(password);
        // return password.toString();
    }

    // Set the Mailbox Capacity
    public void setMailboxCapacity(int in_cap){
        this.mailboxCapacity = in_cap; // still hiding the value
    }

    // set the alternate email
    public void setAlternateEmail(String in_altEmail){
        this.alternateEmail = in_altEmail;
    }

    // change the password
    public void changePassword(String in_newPassword){
        this.password = in_newPassword;
    }


    //public method can reach to private property in the same class directly
    // create a getter for a mailbox capacity
    public int getMailboxCapacity(){ return mailboxCapacity; } 

    // create a getter for an alternate email
    public String getAlternateEmail(){ return alternateEmail; }

    // create a getter for an alternate email
    public String getPassword(){ return password; }

    // generate info to display
    public String showInfo(){
        String out_info = 
        "-----------------------------------------\n"
        + "NAME: " + firstName + " " + lastName + "\n"
        + "COMPANY EMAIL: " + email + "\n" 
        + "MAILBOX CAPACITY: " + mailboxCapacity + "mb" +
        "\n-----------------------------------------";
        System.out.println(out_info);

        return out_info;
    }





    
}
