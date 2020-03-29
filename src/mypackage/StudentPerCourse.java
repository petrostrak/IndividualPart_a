package mypackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StudentPerCourse {

    public List<Student> studentList = new ArrayList();
    public List<Course> courseList = new ArrayList();
    private ArrayList<String> studentToCourse = new ArrayList();
    private Set<String> duplicate = new HashSet();

    public StudentPerCourse(List<Student> studentList, List<Course> courseList) {
        this.studentList = studentList;
        this.courseList = courseList;
    }
    //asks user to enroll students to assignements

    public void setNewStudentToCourse() {
        Scanner input = new Scanner(System.in);
        String choice;
        boolean flag = false;
        for (Student name : studentList) {
            for (Course courseTitle : courseList) {
                System.out.println("Would you like to enroll " + name.getFirstName() + " to " + courseTitle.title +" " +courseTitle.type+ " course?");
                if (input.hasNextInt()) {
                    System.out.println("Please give a valid answer.");
                }
                choice = input.next();
                do {
                    if (choice.equals("yes")) {
                        studentToCourse.add(name.firstName + " has enrolled to " + courseTitle.title + " " +courseTitle.type+ "\n");
                        
                    }
                    flag = true;
                } while (flag == false);
            }
        }
        System.out.println("***Students enrolled to Courses***");
        System.out.println(studentToCourse.toString().replace("[", " ").replace("]", "").replace(",", ""));
    }
    
    //finds duplicate courses
    public void studentsWithMore(){
        for(String title : studentToCourse)
            if(studentToCourse.contains(title)){
                duplicate.add(title);  
            }
        System.out.println("***Students with more than one course***");
        System.out.println(duplicate.toString().replace("[", " ").replace("]", "").replace(",", ""));
    }
}
