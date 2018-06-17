package exercise3;

public class PersonalMortgage extends Mortgage {
    // Constructor for Personal Mortgage
    public PersonalMortgage(int mortgageNumber,String customerName,
                            double amountOfMortgage, double interestRate,
                            String term){
        // Accesses the constructor for the Mortgage class
        super(mortgageNumber,customerName,amountOfMortgage,interestRate + 2,term);
    } // End of Constructor

    // Overridden method of getMortgageInfo
    @Override
    public String getMortgageInfo(){
        return String.format("%s Mortgage Information (TYPE : %s):%n" +
                        "====================================================%s",
                bankName,"Personal",super.getMortgageInfo());
    }// End of getMortgageInfo method
} // End of PersonalMortgage class
