package exercise3;

public abstract class Mortgage implements MortgageConstants {
    // Variables that set the mortgage information
    private final int mortgageNumber;
    private final String customerName;
    private double amountOfMortgage;
    private final double interestRate;
    private final String term;

    // Constructor for Mortgage
    public Mortgage(
            int mortgageNumber,String customerName, double amountOfMortgage,
            double interestRate,String term){
        // Add Exceptions to double variables
        if(amountOfMortgage <= 0 || amountOfMortgage > 300000)
            throw new IllegalArgumentException
                    ("Mortgage amount cannot precede $0.00 or exceed $300,000.");
        if(interestRate < 0 || interestRate > 7383)
            throw new IllegalArgumentException
                    ("Interest Rate cannot precede 0.01% or exceed 7,383%.");
        // Set values to the variables
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        this.amountOfMortgage = amountOfMortgage;
        this.interestRate = interestRate;
        this.term = term;
    } // End of Mortgage Constructor

    // Public getters for the private variables for access outside of the class
    public int getMortgageNumber() { return mortgageNumber; }
    public String getCustomerName() { return customerName; }
    public double getAmountOfMortgage() { return amountOfMortgage; }
    public double getInterestRate() { return interestRate; }
    public String getTerm() { return term; }

    // Gets the information of the mortgage
    public String getMortgageInfo(){
        return String.format(
                        "%n\t%s: %d%n\t%s: %s%n\t%s: $%.2f%n\t%s: %.2f%%" +
                        "%n\t%s: %s%n\t%s: $%.2f%n",
                "Mortgage Number",getMortgageNumber(),
                "Customer Name",getCustomerName(), "Mortgage Amount",getAmountOfMortgage(),
                "Interest Rate",getInterestRate(),"Term",getTerm(),
                "Max Mortgage Amount",maximumMortgageAmount());
    } // End of getMortgageInfo method

    // Overridden method of the calculation of the maximum mortgage amount
    @Override
    public double maximumMortgageAmount() {
        return getAmountOfMortgage() + (getAmountOfMortgage() * (getInterestRate() / 100));
    }// End of maximumMortgageAmount method
}// End of Mortgage class
