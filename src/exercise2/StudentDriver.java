package exercise2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentDriver {
    public static void main(String[] args) {
        Student aStudent;
        Scanner input = new Scanner(System.in);

        String firstName = input.next();
        String lastName = input.next();
        boolean isFullTime = false;
        double creditHour = 0;
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
            try {
                creditHour = input.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Answer. Set default to $50.00");
                creditHour = 20;
            }
            aStudent = new PartTimeStudent(firstName,lastName,creditHour);
        }
        System.out.println(aStudent);
    }
}
