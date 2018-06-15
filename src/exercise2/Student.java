package exercise2;

public abstract class Student {
    public String[] name;
    public boolean isFullTime;

    public Student(String firstName, String lastName, boolean isFullTime){
        this.name = new String[2];
        name[0] = firstName;
        name[1] = lastName;
        this.isFullTime = isFullTime;
    }

    public abstract double setTuition();

    @Override
    public String toString() {
        return String.format("Full Name : %s %s%nStatus    : %s",
                name[0], name[1],
                (isFullTime)? "Full Time" : "Part Time");
    }
}
