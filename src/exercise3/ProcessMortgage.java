package exercise3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args) {
        // Initializer for the array of 3 mortgages
        Mortgage[] mortgages = new Mortgage[3];
        // Initializer for Scanner utilities; used for user input
        Scanner input = new Scanner(System.in);
        // Variable for exception catch
        int exceptionCatch = 0;

        // Variable setup for interest rate
        double interestRate = 0;
        // Prompts the user to enter in the current interest rate
        System.out.print("Enter the Current Interest Rate (RANGE 0-7383): ");
        for (int i = 0; i < 1; i++) {
            try {
                interestRate = input.nextDouble();
            } catch(InputMismatchException e){
                // If in wrong format, it'll breaks out of the for loop,
                // keeps the interest rate to 0%, sets the text to name
                // and sets exceptionCatch to 1
                System.out.println("Incorrect format. Setting interest rate to 0%.");
                exceptionCatch = 1;
            } // End Try-Catch statement
            // Sets a limiter to interestRate
            if(interestRate < 0 || interestRate > 7383)
                System.out.print("Interest Rate cannot precede 0% or exceed 7,383%." +
                        "\nPlease answer again: ");
            else break;
            i--;
        } // End of For loop (int i)

        // Beginning of the For loop to input 3 mortgages
        for (int i = 0; i < mortgages.length; i++) {
            // Prompts the user to enter their name
            System.out.print("Enter your name: ");
            String customerName = input.next();
            // If an exception was catch at the interest rate question, prompt this message.
            // And set exceptionCatch to 0
            if(exceptionCatch > 0){
                System.out.printf("%nName set as %s%n",customerName);
                exceptionCatch = 0;
            } // End If statement

            // Sets the standard mortgage amount to 100
            double amountOfMortgage = 100;
            // Prompts the user to enter in a mortgage amount
            System.out.print("Enter the Mortgage amount(RANGE 0.01-300000): ");
            for (int j = 0; j < 1; j++) {
                try {
                    amountOfMortgage = input.nextDouble();
                } catch(InputMismatchException e){
                    System.out.println("Incorrect format. Setting mortgage amount to $100.");
                } // End Try-Catch statement
                if(amountOfMortgage <= 0 || amountOfMortgage > 300000)
                    System.out.print("Mortgage amount cannot precede $0.00 or exceed $300,000." +
                            "\nPlease answer again: ");
                else break; // End If-Else statement
                j--;
            } // End of For loop (int j)

            // Prompts ths user to enter in the current term
            String term = "";
            for (int j = 0; j < 1; j++) {
                System.out.print("Enter the current term (ENTER Short/Medium/Long): ");
                term = input.next();
                // Takes the string, makes all the characters upper, and split it by each and grab the first character
                term = term.toUpperCase().split("")[0];
                // Determines if tern equals M or L, if neither, set it to short term
                // Prompts the user of the set term decision
                if(term.equals("M")){
                    System.out.println("Setting current term to Medium-Term.");
                    term = MortgageConstants.mediumTerm;
                    break;
                } else if(term.equals("L")){
                    System.out.println("Setting current term to Long-Term.");
                    term = MortgageConstants.longTerm;
                    break;
                } else{
                    System.out.println("Setting current term to Short-Term.");
                    term = MortgageConstants.shortTerm;
                } // End If-Else Statement
            } // End of For loop (int j)

            // Prompts the user to enter the type of mortgage
            String typeOfMortgage = "";
            System.out.print("Enter the type of Mortgage (ENTER Business/Personal): ");
            for (int j = 0; j < 1; j++) {
                typeOfMortgage = input.next();
                typeOfMortgage = typeOfMortgage.toUpperCase().split("")[0];
                // If answer is B or P, break out of For loop, if neither, continue loop
                if(typeOfMortgage.equals("B") || typeOfMortgage.equals("P"))
                    break;
                System.out.print("Incorrect Response. Please answer again: ");
                j--;
            } // End of For loop (int j)

            // Sets up the mortgage with all the gathered information
            // Then prompts a message saying which mortgage is completed
            if(typeOfMortgage.equals("B"))
                mortgages[i] = new BusinessMortgage(i+1,customerName,amountOfMortgage,interestRate,term);
            else
                mortgages[i] = new PersonalMortgage(i+1,customerName,amountOfMortgage,interestRate,term);
            System.out.printf("%d%s MORTGAGE COMPLETE%n",i+1,(i+1 == 1) ? "st" : (i+1 == 2) ? "nd" : "rd");
            System.out.println("====================================================\n");
        } // End of For loop (int i)

        // Prints out all of the mortgages using a ForEach loop
        for (var mortgage: mortgages) {
            System.out.println(mortgage.getMortgageInfo());
        } // End of ForEach loop
    } // End of Main method
} // End of ProcessMortgage class
