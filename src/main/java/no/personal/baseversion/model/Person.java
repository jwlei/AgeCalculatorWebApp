package no.personal.baseversion.model;

/*
Class for defining a person
@param firstName
@param lastName
@param dateOfBirth
@param timeOfBirth
 */


public class Person {
    private String firstName;
    private String lastName;

    private String dateOfBirth;
    private String timeOfBirth;


    //Constructor
    public Person() {

    }

    public Person(String firstName, String lastName, String dateOfBirth, String timeOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.timeOfBirth = timeOfBirth;
    }

    //Overloading
    public Person(String firstName, String lastName, String dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }




    //Getters and setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setTimeOfBirth(String timeOfBirth) {
        this.timeOfBirth = timeOfBirth;
    }

    public String getTimeOfBirth() {
        return timeOfBirth;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        if (this.getFirstName() != null) sb.append("Name: " + this.getFirstName() + "\n");
        if (this.getLastName() != null) sb.append("Lastname: " + this.getLastName() + "\n");
        if (this.getDateOfBirth() != null) sb.append("Date of birth: " + this.getDateOfBirth() + "\n");
        if (this.getTimeOfBirth() != null) sb.append("Time of birth: " + this.getTimeOfBirth() + "\n");

        String str = sb.toString();
        return str;
    }
}