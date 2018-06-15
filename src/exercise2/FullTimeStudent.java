package exercise2;

public class FullTimeStudent extends Student {
    public FullTimeStudent(String firstName, String lastName){
        super(firstName,lastName,true);
    }

    @Override
    public double setTuition() {
        return 2000.00;
    }

    @Override
    public String toString() {
        return String.format("%s%nTuition   : $%.2f%n",
                super.toString(),setTuition());
    }
}
