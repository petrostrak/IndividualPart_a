package mypackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Person {

    protected String firstName;
    protected String lastName;
    private ArrayList<String> languages;
    List<Student> studentList;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> list) {
        this.languages = list;
    }

    public void addLanguages(String language) {
        if (languages == null) {
            languages = new ArrayList();
        }
        languages.add(language);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.firstName);
        hash = 67 * hash + Objects.hashCode(this.lastName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }

    public void setStoredData() {

    }

    public String printDetails() {
        String text = String.format("%-15s %-15s", firstName, lastName);
        return text;
    }

    @Override
    public String toString() {
        String text = String.format("%-15s %-15s", firstName, lastName);
        return text;
    }

    void setNewStudent() {

    }

    void setNewTrainer() {

    }

}
