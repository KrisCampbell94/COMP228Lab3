package exercise1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String insuranceType = "";
        double cost = 0;
        Insurance[] insurances = new Insurance[5];
        for(int j = 0; j < insurances.length;j++) {
            for (int i = 0; i < 1; i++) {
                System.out.print("\nEnter your insurance type: ");
                insuranceType = input.next();
                insuranceType = insuranceType.toUpperCase().split("")[0];
                if (insuranceType.isEmpty())
                    i = invalidAnswer();
                else {
                    if (insuranceType.equals("H") || insuranceType.equals("L"))
                        break;
                }
                i = invalidAnswer();
            }
            System.out.print("Enter your monthly cost:   ");
            try {
                cost = input.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Answer. Set default to $50.00");
                cost = 50;
            }

            if (insuranceType.equals("H"))
                insurances[j] = new Health("Health", cost);
            else
                insurances[j] = new Life("Life", cost);
        }
        System.out.println(); System.out.println();
        for (var insurance: insurances)
            System.out.printf("%s%n",insurance.displayInfo());

    }

    private static int invalidAnswer(){
        System.out.println("Invalid Answer");
        return -1;
    }
}
