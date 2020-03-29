package mypackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Assignment {

    public String title;
    private String description;
    public String subDateTime;
    private double mark;
    public List<Assignment> assignmentList = new ArrayList();

    public Assignment(String title, String description, String subDateTime, double mark) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.mark = mark;
    }

    public void setNewAssignment() {
        Scanner input = new Scanner(System.in);
        while (true) {

            //Ask the title of the assignment
            System.out.println("What is the title of the assignment? ");
            while (input.hasNextInt()) {
                System.out.println("Please provide a valid title.");
                input.nextInt();
            }
            this.title = input.next(); //title of the assignment

            //ask the description 
            System.out.println("What is the descritpion of the assignment? ");
            while (input.hasNextInt()) {
                System.out.println("Please provide a valid name for the stream.");
                input.nextInt();
            }
            this.description = input.next(); //description

            //ask the submission date
            System.out.println("What is the date of submission? ");
            System.out.println("(Please provide a date in the following format : (dd/MM/yyyy.)");
            String date = input.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateFromString = LocalDate.parse(date, formatter);
            String dateFromLocalDate = dateFromString.format(formatter);
            this.subDateTime = dateFromLocalDate; // submission date

            //ask the mark
            System.out.println("What is the mark of the assignment? ");
            do {
                while (!input.hasNextDouble()) {
                    input.next();
                }
                this.mark = input.nextDouble(); //mark
            } while (this.mark <= 0);

            //add input to Assignmet ArrayList
            assignmentList.add(new Assignment(title, description, subDateTime, mark));
            System.out.println("Assignment created successfully.");
            System.out.println("Would you like to continue creating new assignments?");
            System.out.print("Type exit if you want to exit : ");
            String exit = input.next();
            if (exit.equals("exit")) {
                break;
            }
        }
        for (Assignment names : assignmentList) {
            System.out.println(names);
        }
    }

    public void setStoredData() {
        Assignment a1 = new Assignment("Java", "Introduction to OOP", "01/06/2020", 8.0);
        Assignment a2 = new Assignment("HTML", "Hypertext Markup Language", "01/08/2020", 9.0);
        Assignment a3 = new Assignment("Javascript", "Just-in-time compiled", "01/09/2020", 8.5);
        assignmentList.add(a1);
        assignmentList.add(a2);
        assignmentList.add(a3);
        for (Assignment number : assignmentList) {
            System.out.println(number);
        }
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSubDateTime() {
        return subDateTime;
    }

    public double getMark() {
        return mark;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSubDateTime(String subDateTime) {
        this.subDateTime = subDateTime;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + Objects.hashCode(this.subDateTime);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.mark) ^ (Double.doubleToLongBits(this.mark) >>> 32));
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
        final Assignment other = (Assignment) obj;
        if (Double.doubleToLongBits(this.mark) != Double.doubleToLongBits(other.mark)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.subDateTime, other.subDateTime)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String text = String.format("%-11s%-27s%-15s%s", title, description, subDateTime, mark);
        return text;
    }

    public String printDetails() {
        String text = String.format("%-11s%-27s%-15s%s", title, description, subDateTime, mark);
        return text;
    }
}
