package exercise2;

// Full Time Student class that's an extension of the abstract Student class
public class FullTimeStudent extends Student {
    // Constructor of FullTimeStudent
    public FullTimeStudent(String firstName, String lastName){
        // Activates the constructor of the super class Student, sets Full-Time to true
        super(firstName,lastName,true);
    } // End of Constructor

    // Overridden method of setTuition, which returns 2000.00
    @Override
    public double setTuition() { return 2000.00; }

    // Overridden method of toString which overrides the Student toString method
    // Returns the super.toString, and the tuition
    @Override
    public String toString() {
        return String.format("%s%nTuition   : $%.2f%n",
                super.toString(),setTuition());
    } // End of toString method
} // End of FullTimeStudent class
