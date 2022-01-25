package no.personal.baseversion.model;

import java.util.ArrayList;
import java.util.List;

/*
The list of known <Person> in the application
@param Person
@return persons
 */

public class PersonList {
//    private List<Person> person;
    public static List<Person> person = new ArrayList<>();

    // Initializing the list of persons
    public static List<Person> addPersons(List<Person> list) {
        Person p1 = new Person("Joachim", "Leiros", "18-07-1992");
        Person p2 = new Person("Vilja", "Emmasdotter Leiros", "27-07-21", "13:42:00");
        person.add(p1);
        person.add(p2);

        return person;
    }

    public static void addToList(String a, String b, String c, String d) {
        Person x = new Person(a, b, c, d);
        person.add(x);
    }

    public static List<Person> getPerson() {
        return person;
    }

    public void setList(List<Person> person){
        this.person = person;
    }

    public static void printList() {
        System.out.println(person.toString());
    }

}
