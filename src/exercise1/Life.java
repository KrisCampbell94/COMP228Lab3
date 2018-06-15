package exercise1;

public class Life extends Insurance {
    // Class constructor
    public Life(String typeOfInsurance, double monthlyCost){
        // Sets the variables from the parameters
        super(typeOfInsurance,monthlyCost);
    }

    // Override the setInsuranceCost Method
    @Override
    public double setInsuranceCost() {
        double yearly = getMonthlyCost() * 12;
        double tax = yearly * 0.13;
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
