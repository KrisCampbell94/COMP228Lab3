package exercise2;

// Part Time Student class that's an extension of the abstract Student class
public class PartTimeStudent extends Student {
    // Variable for number of credit hour
    private double creditHour;

    // Constructor of PartTimeStudent
    // With the added parameter for the credit hour variable
    public PartTimeStudent(String firstName, String lastName, double creditHour){
        // Activates the constructor of the super class Student, sets Full-Time to false
        super(firstName,lastName,false);
        // Check if creditHour is either under 0 or over 40
        if(creditHour <= 0.0 || creditHour > 40)
            throw new IllegalArgumentException("Credit Hour must be > than 0.0 and less than 40.");
        // Sets creditHour's value
        this.creditHour = creditHour;
    } // End of Constructor

    // Overridden method of setTuition, which returns creditHour multiplied by 100
    @Override
    public double setTuition() { return creditHour * 100; }

    // Overridden method of toString which overrides the Student toString method
    // Returns the super.toString, credit hours, and the tuition
    @Override
    public String toString() {
        return String.format("%s%nCredit Hour : %.2f%n" +
                        "Tuition     : $%.2f%n",
                super.toString(),creditHour,setTuition());
    } // End of toString method
} // End of PartTimeStudent class
