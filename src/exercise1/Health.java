package exercise1;

public class Health extends Insurance {
    // Class constructor
    public Health(String typeOfInsurance, double monthlyCost){
        // This must be first for subclass constructors
        // Sets the variables from the parameters
        super(typeOfInsurance,monthlyCost);
    }

    // Override the setInsuranceCost Method
    @Override
    public double setInsuranceCost() {
        // Get the yearly cost
        double yearly = getMonthlyCost() * 12;
        // Get the tax from yearly
        double tax = yearly * 0.13;
        // Return the addition of yearly and tax
        return yearly + tax;
    }

    // Override the displayInfo Method
    @Override
    public String displayInfo() {
        return String.format("Type of Insurance: %s%n" +
                "Insurance Cost: $%.2f%n",getTypeOfInsurance(),
                setInsuranceCost());
    }
}
