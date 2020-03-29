package mypackage;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssignPerStudent extends Assignment {

    public List<Student> studentList = new ArrayList();
    public List<Course> courseList = new ArrayList();
    public List<Assignment> assignmentList = new ArrayList();
    public ArrayList<String> enrollment = new ArrayList();
    public List<String> subDateList = new ArrayList();

    public AssignPerStudent(String title, String description, String subDateTime, double mark, List<Student> listOfStudents, List<Assignment> listOfAssignments) {
        super(title, description, subDateTime, mark);
        this.studentList = listOfStudents;
        this.assignmentList = listOfAssignments;
    }

    //asks user to enroll students to assignements
    public void setNewEnrollment() {
        Scanner input = new Scanner(System.in);
        String choice;
        boolean flag = false;
        for (Student name : studentList) {
            for (Assignment assignTitle : assignmentList) {
                System.out.println("Would you like to enroll " + name.getFirstName() + " to " + assignTitle.title + " course?");
                if (input.hasNextInt()) {
                    System.out.println("Please give a valid answer.");
                }
                choice = input.next();
                do {
                    if (choice.equals("yes")) {
                        enrollment.add(name.firstName + " has enrolled to " + assignTitle.title + "\n");
                        subDateList.add(subDateTime);
                        //enrollment.add(assignTitle.title);
                    }
                    flag = true;
                } while (flag == false);
            }
        }
        System.out.println("***Students enrolled to Assignments***");
        System.out.println(enrollment.toString().replace("[", " ").replace("]", "").replace(",", ""));
    }
    
    
    //Δεν καταφερα να περασω της ημερομηνιες απο τη λιστα, δεν ειναι λειτουργικο.
    //Περναει την ημερομηνια του αντικειμενου απο την main..
    public void submissionDate() {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Please give a date to check the submissions");
        System.out.println("(Please provide a date in the following format : (dd/MM/yyyy.)");
        LocalDate questionDate = LocalDate.parse(input.next(), formatter);

        LocalDate firstDayOfWeek = questionDate;//<---

        while (firstDayOfWeek.getDayOfWeek() != DayOfWeek.MONDAY) {//enums
            firstDayOfWeek = firstDayOfWeek.minusDays(1);
        }
        LocalDate lasteDayOfWeek = firstDayOfWeek.plusDays(6);
        
        //System.out.println(firstDayOfWeek);//Λειτουργει
        //System.out.println(lasteDayOfWeek);//Λειτουργει
        //System.out.println(subDateList);//Σταθερη ημερομηνια απ το αντικειμενο της main..
        
        for (String deadLine : subDateList) {
            for (String names : enrollment) {
                LocalDate subDate = LocalDate.parse(subDateTime, formatter);
                if (subDate.isAfter(firstDayOfWeek) && subDate.isBefore(lasteDayOfWeek)) {
                    System.out.println(names +"'s assignments are due at " + deadLine);
                }
            }
        }
        System.out.println("No submission for this week.");
    }
}
