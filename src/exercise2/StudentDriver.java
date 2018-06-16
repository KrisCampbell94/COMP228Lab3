package exercise2;

// Import for scanner
import java.util.Scanner;

// The Driver class for the Student classes
public class StudentDriver {
    public static void main(String[] args) {
        // A reference to the abstract class Student
        Student aStudent;
        // A reference to Scanner for User input
        Scanner input = new Scanner(System.in);

        // Prompts the user to enter in their first name
        System.out.print("Enter in your First Name : ");
        String firstName = input.next();

        // Prompts the user to enter in their last name
        System.out.print("Enter in your Last Name : ");
        String lastName = input.next();

        // Prompts the user to answer the question
        String fullTimeResponse = "";
        System.out.print("Are you entering in Full Time? (ENTER Yes/No) : ");
        // For loop to continue until the user enters either Yes or No
        for (int i = 0; i < 1; i++) {
            fullTimeResponse = input.next();
            // Takes the string, makes all the characters upper, and split it by each and grab the first character
            // EXAMPLE: Enter : "yes" -> "YES" -> "Y" "E" "S" -> "Y"
            fullTimeResponse = fullTimeResponse.toUpperCase().split("")[0];
            // If the newly response is "Y" or "N"
            if(fullTimeResponse.equals("Y") || fullTimeResponse.equals("N"))
                break; // Break out of For loop
            // Anything else will continue the for loop by making i = -1
            System.out.println("Invalid Answer.");
            i--;
        } // End of For loop

        // If the user enters Yes, aStudent is initialized as a FullTimeStudent.
        if(fullTimeResponse.equals("Y"))
            aStudent = new FullTimeStudent(firstName,lastName);
        else{
            // The variable for credit hour input
            double creditHour = 0;
            // For loop to loop until the correct answer is inputted
            for (int i = 0; i < 1; i++) {
                System.out.print("Enter your Credit Hours : ");
                // Try Catch statement to test whether the user inputted the wrong format.
                try {
                    creditHour = input.nextDouble();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Answer.");
                } // End of Try Catch statement
                if(creditHour <= 0.0 || creditHour > 40)
                    System.out.println("Credit Hour must be > than 0.0 and less than 40.");
                else break;
                i--;
            } // End of For loop
            // aStudent is initialized as a PartTimeStudent.
            aStudent = new PartTimeStudent(firstName,lastName,creditHour);
        } // End of Else statement
        System.out.println(aStudent);
    } // End of Main method
} // End of StudentDriver class
