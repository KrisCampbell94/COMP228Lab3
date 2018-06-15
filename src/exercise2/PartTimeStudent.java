package exercise2;

public class PartTimeStudent extends Student {
    private double creditHour;
    public PartTimeStudent(String firstName, String lastName, double creditHour){
        super(firstName,lastName,false);
        // 30 - 40 Hours Max.
        if(creditHour <= 0.0 || creditHour > 40)
            throw new IllegalArgumentException("Credit Hour must be > than 0.0 and less than 40.");
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
