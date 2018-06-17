package exercise3;

public class BusinessMortgage extends Mortgage {
    public BusinessMortgage(int mortgageNumber,String customerName,
                            double amountOfMortgage, double interestRate,
                            String term){
        super(mortgageNumber,customerName,amountOfMortgage,interestRate + 1,term);
    }
    public BusinessMortgage(int mortgageNumber,String customerName,
                            double amountOfMortgage, double interestRate){
        super(mortgageNumber,customerName,amountOfMortgage,interestRate + 1);
    }

}
