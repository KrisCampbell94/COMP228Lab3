package exercise2;

public class PartTimeStudent extends Student {
    public double creditHour;
    public PartTimeStudent(String firstName, String lastName, double creditHour){
        super(firstName,lastName,false);

        if(creditHour <= 0.0)
            throw new IllegalArgumentException("Credit Hour must be > than 0.0");
        this.creditHour = creditHour;
    }

    @Override
    public double setTuition() {
        return 100 * creditHour;
    }

    @Override
    public String toString() {
        return String.format("%s%nCredit Hour : %.2f%n" +
                        "Tuition     : $%.2f%n",
                super.toString(),creditHour,setTuition());
    }

}
