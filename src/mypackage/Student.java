package mypackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Student extends Person {

    public List<Student> studentList = new ArrayList();
    private String dateOfBirth;
    private int tuitionFee;

    public Student(String firstName, String lastName, String dateOfBirth, int fee) {
        super(firstName, lastName);
        this.dateOfBirth = dateOfBirth;
        this.tuitionFee = fee;
    }

    @Override
    public void setNewStudent() {
        Scanner input = new Scanner(System.in);
        while (true) {
            //Ask the first name
            System.out.println("What is the first name of the student? ");
//            System.out.println("(type exit to exit the process.)");
            while (input.hasNextInt()) {
                System.out.println("Please provide a valid name.");
                input.nextInt();
            }
            this.firstName = input.next(); //first name

            //ask the last name
            System.out.println("What is the last name of the student? ");
            while (input.hasNextInt()) {
                System.out.println("Please provide a valid name.");
                input.nextInt();
            }
            this.lastName = input.next(); //last name

            //ask date of birth
            System.out.println("What is the date of birth of the student? ");
            System.out.println("(Please provide a date in the following format : (dd/MM/yyyy.)");
            String date = input.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateFromString = LocalDate.parse(date, formatter);
            String dateFromLocalDate = dateFromString.format(formatter);
            this.dateOfBirth = dateFromLocalDate; // date of birth

            //ask tuition fee
            System.out.println("What is the tuition fee of the student? ");
            do {
                while (!input.hasNextInt()) {
                    input.next();
                }
                this.tuitionFee = input.nextInt(); //tuition fee
            } while (this.tuitionFee <= 0);

            //Adding input to Student ArrayList
            studentList.add(new Student(firstName, lastName, dateOfBirth, tuitionFee));
            System.out.println("Student created successfully.");
            System.out.println("Would you like to continue creating students?");
            System.out.print("Type exit if you want to exit : ");
            String exit = input.next();
            if (exit.equals("exit")) {
                break;
            }
        }
        for (Student names : studentList) {
            System.out.println(names);
        }
    }

    @Override
    public void setStoredData() {

        Student s1 = new Student("Labros", "Liaskos", "03/03/1987", 3000);
        Student s2 = new Student("Ardit", "Kasemaj", "09/04/1986", 1000);
        Student s3 = new Student("Despoina", "Karavia", "03/10/1986", 1200);
        Student s4 = new Student("Tyxomoira", "Groueva", "14/02/1987", 1500);
        Student s5 = new Student("Orestis", "Panagopoulos", "17/07/1984", 1300);
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);

        for (Student names : studentList) {
            System.out.println(names);
        }
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Scanner input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String inputDate = input.next();
        LocalDate dateFromString = LocalDate.parse(inputDate, formatter);
        String dateFromLocalDate = dateFromString.format(formatter);
        this.dateOfBirth = dateFromLocalDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(Scanner input) {
        do {
            System.out.println("What is the tuition fee of the student?");
            while (!input.hasNextInt()) {
                System.out.println("Please provide a valid number");
                input.hasNext();
            }
            this.tuitionFee = input.nextInt();
        } while (this.tuitionFee < 0);
        this.tuitionFee = input.nextInt();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 59 * hash + this.tuitionFee;
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
        final Student other = (Student) obj;
        if (this.tuitionFee != other.tuitionFee) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String text = String.format("%-15s %-15s%-15s%-10d", firstName, lastName, dateOfBirth, tuitionFee);
        return text;
    }

    @Override
    public String printDetails() {
        String text = String.format("%-15s %-15s%-15s%-10d", firstName, lastName, dateOfBirth, tuitionFee);
        return text;
    }

}
