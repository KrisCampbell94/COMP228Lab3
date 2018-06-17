package exercise3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args) {
        Mortgage[] mortgages = new Mortgage[3];
        Scanner input = new Scanner(System.in);
        int exceptionCatch = 0;

        double interestRate = 0;
        for (int i = 0; i < 1; i++) {
            System.out.print("Enter the Current Interest Rate: ");
            try {
                interestRate = input.nextDouble();
            } catch(InputMismatchException e){
                System.out.println("Incorrect format. Setting interest rate to 0%.");
                exceptionCatch = 1;
            }
            if(interestRate < 0 || interestRate > 7383)
                System.out.println("Interest Rate cannot precede 0% or exceed 7,383%.");
            else break;
            i--;
        }

        for (int i = 0; i < mortgages.length; i++) {
            System.out.print("Enter your name: ");
            String customerName = input.next();
            if(exceptionCatch > 0) System.out.printf("%nName set as %s%n",customerName);
            
            double amountOfMortgage = 100;
            for (int j = 0; j < 1; j++) {
                System.out.print("Enter the Mortgage amount: ");
                try {
                    amountOfMortgage = input.nextDouble();
                } catch(InputMismatchException e){
                    System.out.println("Incorrect format. Setting mortgage amount to $100.");
                }
                if(amountOfMortgage <= 0 || amountOfMortgage > 300000)
                    System.out.println("Mortgage amount cannot precede $0.00 or exceed $300,000.");
                else break;
                j--;
            }
            String term = "";
            for (int j = 0; j < 1; j++) {
                System.out.print("Enter the current term (ENTER Short/Medium/Long): ");
                term = input.next();
                term = term.toUpperCase().split("")[0];
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
                }
            }
            String typeOfMortgage = "";
            System.out.print("Enter the type of Mortgage (ENTER Business/Personal): ");
            for (int j = 0; j < 1; j++) {
                term = input.next();
                term = term.toUpperCase().split("")[0];
                if(term.equals("B") || term.equals("P"))
                    break;
                System.out.print("Incorrect Response. Please answer again: ");
                j--;
            }
            if(typeOfMortgage.equals("B"))
                mortgages[i] = new BusinessMortgage(i+1,customerName,amountOfMortgage,interestRate,term);
            else
                mortgages[i] = new PersonalMortgage(i+1,customerName,amountOfMortgage,interestRate,term);
            System.out.printf("%d%s MORTGAGE COMPLETE%n",i+1,(i+1 == 1) ? "st" : (i+1 == 2) ? "nd" : "rd");
            System.out.println("====================================================\n");
        }

        for (var mortgage: mortgages) {
            System.out.println(mortgage.getMortgageInfo());
        }
    }
}
