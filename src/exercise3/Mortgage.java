package exercise3;

public abstract class Mortgage implements MortgageConstants {
    private final int mortgageNumber;
    private final String customerName;
    private double amountOfMortgage;
    private final double interestRate;
    private final String term;

    public Mortgage(
            int mortgageNumber,String customerName, double amountOfMortgage,
            double interestRate,String term){
        if(amountOfMortgage <= 0 || amountOfMortgage > 300000)
            throw new IllegalArgumentException
                    ("Mortgage amount cannot precede $0.00 or exceed $300,000.");
        if(interestRate < 0 || interestRate > 7383)
            throw new IllegalArgumentException
                    ("Interest Rate cannot precede 0.01% or exceed 7,383%.");
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        this.amountOfMortgage = amountOfMortgage;
        this.interestRate = interestRate;
        this.term = term;

    }
    public Mortgage(
            int mortgageNumber,String customerName, double amountOfMortgage,
            double interestRate){
        this(mortgageNumber,customerName,amountOfMortgage,interestRate,MortgageConstants.shortTerm);

    }

    public int getMortgageNumber() { return mortgageNumber; }
    public String getCustomerName() { return customerName; }
    public double getAmountOfMortgage() { return amountOfMortgage; }
    public double getInterestRate() { return interestRate; }
    public String getTerm() { return term; }

    public String getMortgageInfo(){
        return String.format("%s Mortgage Information:%n" +
                        "=============================================" +
                        "%n\t%s: %d%n\t%s: %s%n\t%s: $%.2f%n\t%s: %f%%" +
                        "%n\t%s: %s%n\t%s: $%.2f%n",
                bankName,"Mortgage Number",getMortgageNumber(),
                "Customer Name",getCustomerName(), "Mortgage Amount",getAmountOfMortgage(),
                "Interest Rate",getInterestRate(),"Term",getTerm(),
                "Max Mortgage Amount",maximumMortgageAmount());
    }
    @Override
    public double maximumMortgageAmount() {
        return getAmountOfMortgage() + (getAmountOfMortgage() * (getInterestRate() / 100));
    }
}
