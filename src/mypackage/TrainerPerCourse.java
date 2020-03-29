package mypackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainerPerCourse {
    public List<Trainer> trainerList = new ArrayList();
    public List<Course> courseList = new ArrayList();
    private ArrayList<String> trainerToCourseList = new ArrayList();
    
    public TrainerPerCourse(List<Trainer> trainerList, List<Course> courseList){
        this.trainerList = trainerList;
        this.courseList = courseList;
    }
    
        public void setNewTrainerToCourse() {
        Scanner input = new Scanner(System.in);
        String choice;
        boolean flag = false;
        for (Trainer name : trainerList) {
            for (Course courseTitle : courseList) {
                System.out.println("Would you like to enroll " + name.getFirstName() + " to " + courseTitle.title + " course?");
                if (input.hasNextInt()) {
                    System.out.println("Please give a valid answer.");
                }
                choice = input.next();
                do {
                    if (choice.equals("yes")) {
                        trainerToCourseList.add(name.firstName + " has enrolled to " + courseTitle.title + "\n");
                        //enrollment.add(assignTitle.title);
                    }
                    flag = true;
                } while (flag == false);
            }
        }
        System.out.println("***Trainers enrolled to Courses***");
        System.out.println(trainerToCourseList.toString().replace("[", " ").replace("]", "").replace(",", ""));
    }
}
