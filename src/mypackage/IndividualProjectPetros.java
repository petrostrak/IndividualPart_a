package mypackage;

import java.util.Scanner;

public class IndividualProjectPetros {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Student s1 = new Student("Petros", "Trakadas", "10/05/1986", 1200);
        Trainer t1 = new Trainer("Tasos", "Lelakis", "Java");
        Course c1 = new Course("Java", "OOP", "Full Time", "01/03/2020", "01/06/2020");
        Assignment a1 = new Assignment("Java", "Introduction to OOP", "01/06/2020", 8.0);
        AssignPerStudent e1 = new AssignPerStudent("Java", "oop", "10/05/2020", 9.0, s1.studentList, a1.assignmentList);
        StudentPerCourse sc1 = new StudentPerCourse(s1.studentList, c1.courseList);
        TrainerPerCourse tc1 = new TrainerPerCourse(t1.trainerList, c1.courseList);

        boolean flag = false;
        while (!flag) {

            doConsole();
            System.out.print("Input : ");
            while (input.hasNextInt()) {
                System.out.println("Please provide a valid option.");
                input.nextInt();
            }
            String choice = input.next().toLowerCase();
            switch (choice) {
                case "student":
                    s1.setNewStudent();
                    break;
                case "cache":
                    System.out.println("**Students**********");
                    System.out.printf("%-16s%-15s%-15s%-10s", "First Name", "Last Name", "Date Of Birth", "Tuition Fee\n");
                    s1.setStoredData();
                    System.out.println("**Trainers**********");
                    System.out.printf("%-16s%-15s%-8s", "First Name", "Last Name", "Subject\n");
                    t1.setStoredData();
                    System.out.println("**Courses***********");
                    System.out.printf("%-10s%-20s%-15s%-15s%-9s", "Title", "Stream", "Type", "Start Date", "End Date\n");
                    c1.setStoredData();
                    System.out.println("**Assignments*******");
                    System.out.printf("%-11s%-27s%-15s%s", "Title", "Description", "Sub. Date", "Mark\n");
                    a1.setStoredData();
                    break;
                case "trainer":
                    t1.setNewTrainer();
                    break;
                case "deadline":
                    e1.submissionDate();
                    break;
                case "more":
                    sc1.studentsWithMore();
                    break;
                case "course":
                    c1.setNewCourse();
                    break;
                case "assignment":
                    a1.setNewAssignment();
                    break;
                case "submenu":
                    if (s1.studentList.isEmpty() || c1.courseList.isEmpty() || a1.assignmentList.isEmpty() || t1.trainerList.isEmpty()) {
                        System.out.println("You have to create students and courses to use this option.");
                        break;
                    }
                    doConsoleEnrollment();
                    System.out.print("Input : ");
                    while (input.hasNextInt()) {
                        System.out.println("Please provide a valid option.");
                        input.nextInt();
                    }
                    choice = input.next().toLowerCase();
                    switch (choice) {
                        case "student":
                            sc1.setNewStudentToCourse();
                            break;
                        case "trainer":
                            tc1.setNewTrainerToCourse();
                            break;
                        case "enrollment":
                            e1.setNewEnrollment();
                            break;
                        case "exit":
                            break;
                    }
                    break;
                case "exit":
                    flag = true;
            }
        }
    }

    static void doConsole() {
        System.out.println("[Main Menu]");
        System.out.println("What would you like to do?");
        System.out.println("To add new Student, type student.");
        System.out.println("To add new Trainer, type trainer.");
        System.out.println("To add new Course, type course.");
        System.out.println("To add new Assignment, type assignment.");
        System.out.println("To skip manual entry and continue with stored data, type  cache");
        System.out.println("For more options, type submenu.");
        System.out.println("To see the students with more that one course, type more");
        System.out.println("To see the the dealines of the assignments, type deadline");
        System.out.println("To exit the programm, type exit");
    }

    static void doConsoleEnrollment() {
        System.out.println("[Submenu]");
        System.out.println("What would you like to do?");
        System.out.println("To enroll students to course, type student.");
        System.out.println("To enroll trainers to courses, type trainer.");
        System.out.println("To enroll assignments to course, type assignment.");
        System.out.println("To enroll students to assignments, type enrollment.");
        System.out.println("To exit enrollment, type exit");
    }
}
