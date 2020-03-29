package mypackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Trainer extends Person {

    public List<Trainer> trainerList = new ArrayList();
    private String subject;

    public Trainer(String firstName, String lastName, String subject) {
        super(firstName, lastName);
        this.subject = subject;
    }

    @Override
    public void setNewTrainer() {
        Scanner input = new Scanner(System.in);
        while (true) {

            //Ask the first name
            System.out.println("What is the first name of the trainer? ");
//            System.out.println("(type exit to exit the process.)");
            while (input.hasNextInt()) {
                System.out.println("Please provide a valid name.");
                input.nextInt();
            }
            this.firstName = input.next(); //first name

            //ask the last name
            System.out.println("What is the last name of the trainer? ");
            while (input.hasNextInt()) {
                System.out.println("Please provide a valid name.");
                input.nextInt();
            }
            this.lastName = input.next(); //last name

            //ask the subject
            System.out.println("What is the subject of this trainer? ");
            while (input.hasNextInt()) {
                System.out.println("Please provide a valid name for the subject.");
                input.nextInt();
            }
            this.subject = input.next(); //subject name

            //add input to the Trainer ArrayList
            trainerList.add(new Trainer(firstName, lastName, subject));
            System.out.println("Trainer created successfully.");
            System.out.println("Would you like to continue creating trainers?");
            System.out.print("Type exit if you want to exit : ");
            String exit = input.next();
            if (exit.equals("exit")) {
                break;
            }
        }
        for (Trainer names : trainerList) {
            System.out.println(names);
        }
    }

    @Override
    public void setStoredData() {
        Trainer t1 = new Trainer("Tasos", "Lelakis", "Java");
        Trainer t2 = new Trainer("Michalis", "Chamilos", "MySQL");
        Trainer t3 = new Trainer("George", "Pasparakis", "HTML");
        trainerList.add(t1);
        trainerList.add(t2);
        trainerList.add(t3);
        for (Trainer name : trainerList) {
            System.out.println(name);
        }
    }

    public String getSubject() {
        return subject;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.subject);
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
        final Trainer other = (Trainer) obj;
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        return true;
    }

    @Override
    public String printDetails() {
        String text = String.format("%s %-15s%-15s", firstName, lastName, subject);
        return text;
    }

    @Override
    public String toString() {
        String text = String.format("%-15s %-15s%-15s", firstName, lastName, subject);
        return text;
    }

}
