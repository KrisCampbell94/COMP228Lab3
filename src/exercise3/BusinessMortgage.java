package exercise3;

public class BusinessMortgage extends Mortgage {
    // Constructor for Business Mortgage
    public BusinessMortgage(int mortgageNumber,String customerName,
                            double amountOfMortgage, double interestRate,
                            String term){
        // Accesses the constructor for the Mortgage class
        super(mortgageNumber,customerName,amountOfMortgage,interestRate + 1,term);
    } // End of Constructor

    // Overridden method of getMortgageInfo
    @Override
    public String getMortgageInfo(){
        return String.format("%s Mortgage Information (TYPE : %s):%n" +
                        "====================================================%s",
                bankName,"Business",super.getMortgageInfo());
    } // End of getMortgageInfo method
} // End of BusinessMortgage class
