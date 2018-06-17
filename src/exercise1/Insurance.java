package exercise1;

public abstract class Insurance {
    // The variable to hold the type of insurance
    private final String typeOfInsurance;
    // The variable to hold the monthly cost of the insurance
    private final double monthlyCost;

    // The abstract class constructor
    public Insurance(String typeOfInsurance, double monthlyCost){
        if(monthlyCost <= 0.0)
            throw new IllegalArgumentException("Monthly cost must be greater than 0.0");
        this.typeOfInsurance = typeOfInsurance;
        this.monthlyCost = monthlyCost;
    }

    // Method to retrieve the variable typeOfInsurance
    public String getTypeOfInsurance() {
        return typeOfInsurance;
    }
    // Method to retrieve the variable monthlyCost
    public double getMonthlyCost() {
        return monthlyCost;
    }

    // Abstract methods that MUST be implemented to the subclasses
    public abstract double setInsuranceCost();
    public abstract String displayInfo();
}
