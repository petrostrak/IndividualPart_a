package mypackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Course {

    public String title;
    private String stream;
    public String type;
    private String startDate;
    private String endDate;
    public List<Course> courseList = new ArrayList();

    public Course(String title, String stream, String type, String startDate, String endDate) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setNewCourse() {
        Scanner input = new Scanner(System.in);
        while (true) {

            //Ask the title of the course
            System.out.println("What is the title of the course? ");
            while (input.hasNextInt()) {
                System.out.println("Please provide a valid title.");
                input.nextInt();
            }
            this.title = input.next(); //title of the course

            //ask the stream of the course
            System.out.println("What is the stream of the course? ");
            while (input.hasNextInt()) {
                System.out.println("Please provide a valid name for the stream.");
                input.nextInt();
            }
            this.stream = input.next(); //stream
            //ask the type of the course
            System.out.println("What is the type of the course? ");
            while (input.hasNextInt()) {
                System.out.println("Please provide a valid type.");
                input.nextInt();
            }
            this.type = input.next(); //type

            //ask the start date
            System.out.println("What is the starting date of the course? ");
            System.out.println("(Please provide a date in the following format : (dd/MM/yyyy.)");
            String date = input.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateFromString = LocalDate.parse(date, formatter);
            String dateFromLocalDate = dateFromString.format(formatter);
            this.startDate = dateFromLocalDate; // starting date

            //ask the end date
            System.out.println("What is the end date of the course? ");
            System.out.println("(Please provide a date in the following format : (dd/MM/yyyy.)");
            String date2 = input.next();
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateFromString2 = LocalDate.parse(date2, formatter2);
            String dateFromLocalDate2 = dateFromString2.format(formatter2);
            this.endDate = dateFromLocalDate2; // end date

            //add inpunt to Course ArrayList
            courseList.add(new Course(title, stream, type, startDate, endDate));
            System.out.println("Course created successfully.");
            System.out.println("Would you like to continue creating courses?");
            System.out.print("Type exit if you want to exit : ");
            String exit = input.next();
            if (exit.equals("exit")) {
                break;
            }
        }
        for (Course names : courseList) {
            System.out.println(names);
        }
    }

    public void setStoredData() {
        Course c1 = new Course("Java", "object-oriented", "Full Time", "01/03/2020", "01/06/2020");
        Course c2 = new Course("C#", "component-oriented", "Full Time", "01/03/2020", "01/09/2020");
        Course c3 = new Course("Java", "object-oriented", "Part Time", "01/03/2020", "01/06/2020");
        Course c4 = new Course("C#", "component-oriented", "Full Time", "01/03/2020", "01/09/2020");
        courseList.add(c1);
        courseList.add(c2);
        courseList.add(c3);
        courseList.add(c4);
        for (Course name : courseList) {
            System.out.println(name);
        }
    }

    public String getTitle() {
        return title;
    }

    public String getStream() {
        return stream;
    }

    public String getType() {
        return type;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStartDate(String startDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String inputDate = startDate;
        LocalDate dateFromString = LocalDate.parse(inputDate, formatter);
        String dateFromLocalDate = dateFromString.format(formatter);
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String inputDate = endDate;
        LocalDate dateFromString = LocalDate.parse(inputDate, formatter);
        String dateFromLocalDate = dateFromString.format(formatter);
        this.endDate = endDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + Objects.hashCode(this.stream);
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + Objects.hashCode(this.startDate);
        hash = 53 * hash + Objects.hashCode(this.endDate);
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
        final Course other = (Course) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.stream, other.stream)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endDate, other.endDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String text = String.format("%-9s %-20s%-15s%-15s%-15s", title, stream, type, startDate, endDate);
        return text;
    }

    public String printDetails() {
        String text = String.format("%-9s %-20s%-15s%-15s%-15s", title, stream, type, startDate, endDate);
        return text;
    }

}
