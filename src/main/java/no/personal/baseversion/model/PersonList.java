package no.personal.baseversion.model;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/* The list of known <Person> in the application
@param Person
@return persons
 */

public class PersonList {
    public static List<Person> person = new ArrayList<>();

    /* Initializing the list of persons
    @param List<Person>
    @return person
     */
    public static List<Person> addPersons() {
        Person p1 = new Person("Joachim", "Leiros", "18-07-1992");
        Person p2 = new Person("Vilja", "Emmasdotter Leiros", "27-07-2021", "13:42:00");
        person.add(p1);
        person.add(p2);

        return person;
    }

    public static void addToList(String a, String b, String c, String d) {
        Person x = new Person(a, b, c, d);
        person.add(x);
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setList(List<Person> person){
        PersonList.person = person;
    }

    public static void printList() {
        System.out.println(person.toString());
    }

    public static void printNames() {
        for (Person e : person) {
            System.out.println(e.getFirstName() + " " + e.getLastName());
        }
    }

    public  Person getPerson(String s) {
        for (Person e : person) {
            if (e.getFirstName().equalsIgnoreCase(s) || e.getFirstName().equalsIgnoreCase(s)){
                System.out.println("\nPerson [" + e.getFirstName() + "] found and is:");
                return e;
                }
            }
        return null;
    }
}

