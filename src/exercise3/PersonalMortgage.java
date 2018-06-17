package exercise3;

public class PersonalMortgage extends Mortgage {
    public PersonalMortgage(int mortgageNumber,String customerName,
                            double amountOfMortgage, double interestRate,
                            String term){
        super(mortgageNumber,customerName,amountOfMortgage,interestRate + 2,term);
    }
    public PersonalMortgage(int mortgageNumber,String customerName,
                            double amountOfMortgage, double interestRate){
        super(mortgageNumber,customerName,amountOfMortgage,interestRate + 2+interestRate);
    }
}
