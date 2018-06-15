package exercise1;

// Used for InputMismatchException capabilities
import java.util.InputMismatchException;
// Used for Scanner capabilities
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        // Create an instance of scanner for user input
        Scanner input = new Scanner(System.in);
        // Variable used to determine the insuranceType
        String insuranceType = "";
        // Variable used to determine the cost
        double cost = 0;
        // An array of insurance instances
        Insurance[] insurances = new Insurance[5];
        // Start a for loop to insert each insurance 5 times
        for(int j = 0; j < insurances.length;j++) {
            // A for loop for asking the user to enter the insurance type
            for (int i = 0; i < 1; i++) {
                // Prompts the user to enter in the insurance type
                System.out.print("\nEnter your insurance type: ");
                insuranceType = input.next();
                // This makes any input string into all uppercase
                // and split it by each character and grabbing the first letter
                insuranceType = insuranceType.toUpperCase().split("")[0];
                // If the newly string is either H or L, break out of for loop
                if (insuranceType.equals("H") || insuranceType.equals("L"))
                    break;
                // If not, prompt the user about the invalid answer
                i = invalidAnswer();
            }// End of inner for loop (int i)
            // Prompts the user to enter in a monthly cost
            System.out.print("Enter your monthly cost:   ");
            try {
                cost = input.nextDouble();
            } catch (InputMismatchException e) {
                // Catches any input that's not numerical, and set the cost to 50
                System.out.println("Invalid Answer. Set default to $50.00");
                cost = 50;
            }
            // Sets the insurance based on the cost and the type
            if (insuranceType.equals("H"))
                insurances[j] = new Health("Health", cost);
            else
                insurances[j] = new Life("Life", cost);
        } // End of outer for loop (int j)
        // Prints out the various insurances on each line
        System.out.println(); System.out.println();
        for (var insurance: insurances)
            System.out.printf("%s%n",insurance.displayInfo());

    } // End of Main Method

    private static int invalidAnswer(){
        // Tells the user their answer was invalid, and how to not do it again
        System.out.println("Invalid Answer. Enter either Health or Life.");
        return -1;
    } // End of invalidAnswer Method
}
