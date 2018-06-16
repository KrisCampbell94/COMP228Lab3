package exercise2;

// Abstract class of Student
public abstract class Student {
    // An array for both first and last name
    private String[] name;
    // Boolean check if the student is full time or not
    private boolean isFullTime;

    // Constructor for abstract class Student
    public Student(String firstName, String lastName, boolean isFullTime){
        // Setting the array to only hold 2 variables
        this.name = new String[2];
        // Setting the values to the appropriate variables
        name[0] = firstName;
        name[1] = lastName;
        this.isFullTime = isFullTime;
    } // End of Constructor method

    // Abstract method to be override in the subclasses of Student
    public abstract double setTuition();

    // Overridden method toString to return information
    @Override
    public String toString() {
        return String.format("Full Name : %s %s%nStatus    : %s",
                name[0], name[1],
                (isFullTime)? "Full Time" : "Part Time");
    }// End of toString method
} // End of Abstract Class
