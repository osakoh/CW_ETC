/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etcfinal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Osas
 */
public class Lesson {
    
    ArrayList<Tutor> tutors = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Student> records = new ArrayList<>();
    static ArrayList<Tutor> subRecords = new ArrayList<>();
    ArrayList<String> textBook = new ArrayList<>();

    Scanner scan = new Scanner(System.in);
    
    
    /**keeps track of students booking to stop students 
     * from cancelling a lesson they didn't book
    */ 
//    static Student recordsList;

    
   
     /**
     * @add a tutor 
     */
    public void addTutor (Tutor tut) {
        tutors.add(tut);
    }
    
    /**
     * @param stud a student to the list
     */
    public void addStudent (Student stud) {
        students.add(stud);
    }
       
    /**
     *
     * @param tut adds a tutor
     * @return checks if tutor has been added
     */
    public boolean isTutor(Tutor tut){
        return tutors.contains(tut);
    }
    
    /**
     * @param stud adds student to the list
     * @return checks if a student has been added to the list
     */
    public static boolean isStudent(Student stud){
        return students.contains(stud);
    }
    
        /**
     * first checks if list of booked student is empty 
     * then prints list
     */
    public void showBookedStudent(){
        if (!records.isEmpty()) {
            int index = 1;
            for (Student s : records) {
                System.out.println(index++ + " . " + s.getName());
            } 
        } else {
            System.out.println("No booked lesson yet");
        }
    }
    
          /**
     * Add a Student
     * @param stud the student to be added
     * @param tut.slotAvailable() checks if tutor has available slot
     */
    public void bookLesson(Student stud, Tutor tut) {
        if (!isTutor(tut)) {
            System.out.println("Sorry, " + stud.getName() + " this isn't a registered tutor\n");
        } else if (!isStudent(stud)){
            System.out.println(stud.getName() + " is not a registered student \n");
        } else if (!tut.slotAvailable()) {
            System.out.println("Sorry " + stud.getName() + " no slots available\n");
        } else {
            tut.registerStudent(stud);
            records.add(stud);
            
            System.out.println("<--------------" + stud.getName() + " has booked " + tut.getSubject() + "-------------->\n");
            subRecords.add(tut);
            Student.bookedLesson++;
        }
    }
    
        
    public boolean studentHasBooked(Student stud) {
        return records.contains(stud);
    }
    
    public void bookList(){
        if (!subRecords.isEmpty()){
            for (Tutor s : subRecords){
            System.out.println(s.getSubject());
            }
        } else {
            System.out.println("Book list empty\n");
        }
        
    }
    
    public void removeLesson(Student stud, Tutor tut) {
        if (!studentHasBooked(stud)){
            System.out.println("You have to book a lesson first\n");
        } else {
            tut.eraseStudent(stud);
            System.out.println("<----->" + stud.getName() + " cancelled " + tut.getSubject() + "<----->\n");
            Student.cancelledLesson++;
        }
    }
    
        
    public void timeTable(){
        String leftAlignFormat = "| %-8s | %-22s | %-20s | %-15d | %-12d |%n";
        System.out.format("+----------+------------------ Time Table -----------------+-----------------+--------------+%n");
        System.out.format("|  Tutor   |        Subject         |     Time             | Available Slots | Booked Slots |%n");
        for (int i=0; i < tutors.size(); i++) {
            System.out.format("+----------+------------------------+----------------------+-----------------+--------------+%n");
            System.out.printf(leftAlignFormat, tutors.get(i).getName(), tutors.get(i).getSubject(), tutors.get(i).getAvailableTime(), tutors.get(i).getSlot(), tutors.get(i).remainingSlots());
        }
        System.out.format("+----------+------------------------+----------------------+-----------------+--------------+%n");

        for (String b : textBook ) {
            System.out.println(b);
        }
    }
    
}
