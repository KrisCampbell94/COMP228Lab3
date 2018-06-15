package exercise2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentDriver {
    public static void main(String[] args) {
        Student aStudent;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter in your First Name : ");
        String firstName = input.next();
        System.out.print("Enter in your Last Name : ");
        String lastName = input.next();
        boolean isFullTime = false;
        double creditHour = 0;
        System.out.print("Are you entering in Full Time? (Enter Yes/No) : ");
        for (int i = 0; i < 1; i++) {
            String fullTimeResponse = input.next();
            fullTimeResponse = fullTimeResponse.toUpperCase().split("")[0];
            if(fullTimeResponse.equals("Y")){
                isFullTime = true;
                break;
            }
            else if(fullTimeResponse.equals("N"))
                break;

            System.out.println("Invalid Answer");
            i--;
        }
        if(isFullTime){
            aStudent = new FullTimeStudent(firstName,lastName);
        }
        else{
            for (int i = 0; i < 1; i++) {
                try {
                    System.out.print("Enter your Credit Hours : ");
                    creditHour = input.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Answer. Set default to 30.0");
                    creditHour = 30;
                    break;
                }
                if(creditHour <= 0.0 || creditHour > 40){
                    System.out.println("Credit Hour must be > than 0.0 and less than 40.");
                    i--;
                }
                else
                    break;
            }
            aStudent = new PartTimeStudent(firstName,lastName,creditHour);
        }
        System.out.println(aStudent);
    }
}
