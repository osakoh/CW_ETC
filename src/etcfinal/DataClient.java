/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etcfinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Osas
 */
public class DataClient {
    
    Scanner scan = new Scanner(System.in);
    
    static int choice, subjectName, studentNumber;
    private Lesson lesson = new Lesson();
    private Tutor t1, t2, t3, t4, t5;
    private Student stud1, stud2, stud3, stud4, stud5, stud6, stud7, stud8, stud9, stud10; 
    private ArrayList<Student> students;
    private ArrayList<Tutor> tutors;
    private ArrayList<String> textBook;
    static String bs;
    
    public DataClient() {
        
        lesson = new Lesson();
        
        // creates the tutors
        t1 = new Tutor("Steve", "Maths", "10:00AM - 11:00AM", 3);
        t2 = new Tutor("Nathan", "English Comprehension", "09:30AM - 10:30AM", 2);
        t3 = new Tutor("William", "Numerical Reasoning", "12:00PM - 1:00PM", 3);
        t4 = new Tutor("Tim", "Verbal Reasoning", "09:30AM - 10:30AM", 2);
        t5 = new Tutor("Martina", "English Writing", "12:00PM - 1:00PM", 3);
        tutors = new ArrayList<>(Arrays.asList(t1, t2, t3, t4, t5));

        // creates 10 students
        stud1 = new Student("James", "Male", "10/02/1996", "College Lane", 0721102, 0271102);
        stud2 = new Student("Brandon", "Male", "30/05/1998", "De-Haviland", 07321040, 0245671);
        stud3 = new Student("Kate", "Female", "27/12/1996", "Willow Way", 0712321, 0703467);
        stud4 = new Student("Richard", "Male", "01/04/1999", "Roberts Way", 0721102, 0271102);
        stud5 = new Student("Rachel", "Female", "09/08/1995", "Woods Ave", 0721102, 0271102);
        stud6 = new Student("Sim", "Male", "02/02/1997", "Bishop's Close", 0721102, 0271102);
        stud7 = new Student("Vally", "Female", "18/09/1996", "Lane Drive", 0721102, 0271102);
        stud8 = new Student("Rex", "Male", "15/10/1995", "Ellen Brook", 0721102, 0271102);
        stud9 = new Student("Jill", "Female", "20/06/1996", "Dragon Road", 0721102, 0271102);
        stud10 = new Student("Thompson", "Male", "03/11/1997", "Crooks Way", 0721102, 0271102);
        students = new ArrayList<>(Arrays.asList(stud1, stud2, stud3, stud4, stud5, stud6, stud7, stud8, stud9, stud10));
        
        // adds tutor to the class
        lesson.addTutor(t1);
        lesson.addTutor(t2);
        lesson.addTutor(t3);
        lesson.addTutor(t4);
        lesson.addTutor(t5);
        
        // adds students to the class
        lesson.addStudent(stud1);
        lesson.addStudent(stud2);
        lesson.addStudent(stud3);
        lesson.addStudent(stud4);
        lesson.addStudent(stud5);
        lesson.addStudent(stud6);
        lesson.addStudent(stud7);
        lesson.addStudent(stud8);
        lesson.addStudent(stud9);
        lesson.addStudent(stud10);
        
        
        // adds textbook to the arraylist
        String b1 = "mental math 1";
        String b2 = "english comprehension 3";
        String b3 = "pyhsics 4";
        String b4 = "verbal 5";
        textBook = new ArrayList<>(Arrays.asList(b1, b2, b3, b4));

        
        // displays tutors timetable
        lesson.timeTable();
        System.out.println();      
    }
    
    // method which selects a student
    public Student selectStudent(){
        for (int count = 0; count < students.size(); count++) {
            System.out.println((count + 1) + " . " + students.get(count));
        }
        
        System.out.println("Select student: ");
        int num = scan.nextInt();
        num -= 1;
        
        if ( num > students.size() | num < 0) {
            System.out.println("Invalid entry\n");
            selectStudent();
        } else {
            System.out.println(students.get(num) + " selected\n");
        }
        
        return students.get(num);  
    }
    
    public Tutor selectSubject(){
        for (int count = 0; count < tutors.size(); count++) {
            System.out.println((count + 1) + " . " + tutors.get(count));
        }

        System.out.println("Select 1,2 or 3 for corresponding subject: ");
        int num = scan.nextInt();
        num -= 1;

        if ( num > tutors.size() | num < 0) {
            System.out.println("Invalid entry\n");
            selectSubject();
        } else {
            System.out.println(tutors.get(num) + " selected\n");
        }
        return tutors.get(num);  
    }
           
    public void showReport(){
        String leftAlignFormat = "| %-15s | %-17s |%n";
        System.out.format("|------------ Monthly Report ---------|%n");
        System.out.format("| Total Attended  |    Total Canceled |%n");
        System.out.format("+-----------------+-------------------+%n");
        System.out.printf(leftAlignFormat, Student.bookedLesson, Student.cancelledLesson);
        System.out.format("+-----------------+-------------------+%n\n");
    } 
    
       
    public void changeBooking(){
        for (int count = 0; count + 1 < students.size(); count++) {
            System.out.println((count + 1) + " . " + students.get(count));
        }
        
        System.out.println("Enter student number: ");
        studentNumber = scan.nextInt(); 
        studentNumber -= 1;
        if ( studentNumber > students.size() | studentNumber < 0) {
            System.out.println("Invalid entry\n");
        } else {
            for (int count = 0; count < tutors.size(); count++) {
            System.out.println((count + 1) + " . " + tutors.get(count));
            }
            System.out.print("\nSelect desired subject: ");
            subjectName = scan.nextInt();
            subjectName -= 1;
            
            if ( subjectName > tutors.size() | subjectName < 0) {
                System.out.println("Invalid entry\n");
                selectSubject();
            } else {
                students.set(studentNumber, students.get(studentNumber));
                System.out.println(tutors.get(subjectName) + " selected\n");
            }
        }
        System.out.println(students.get(studentNumber) + " changed subject to " + tutors.get(subjectName));
    }
    
    // shows list of students who have booked a lesson
    public void attendLesson(){
        lesson.showBookedStudent();
    }
    
        
    public void requestBook(String s){
        int index = 1;
        for (String b : textBook){
            System.out.println(index++ + ". " + b);
        }

        if (textBook.contains(s.toLowerCase())){
            System.out.println("Requested " + s);
        } else {            
            System.out.println("Sorry, " + s + " is not available");        
        } 
    }
    
    
    public void caseRun(){  

        do
        {
            mainMenu();
            try 
            {        
                choice = scan.nextInt();
                switch (choice)
                {
                    case 1:
                        System.out.println("");
                        lesson.bookLesson(selectStudent(), selectSubject());
                        lesson.timeTable();
                        break;
                    case 2:
                        changeBooking();
                        break;
                    case 3:
                        lesson.removeLesson(selectStudent(), selectSubject());
                        break;
                    case 4:
                        attendLesson();
                        break;
                    case 5:
                        System.out.println("Case 6");
                        break;
                    case 6:
                        showReport();
                        break;
                    case 0:
                        System.out.println("Thank you and goodbye!");
                        return;
                    default:
                          System.out.println("\nInvalid Option!");
                          break;
                }    
            } catch (InputMismatchException e) { 
                System.out.println("\nINVALID INPUT!"); 
                scan.next();
            }
            
        } while (choice != 0);        
    }
    
    
    public void mainMenu(){
        System.out.println("+-------- Extra Tuition Centre (ETC) --------+");
        System.out.println("| 1.      Book lesson                        |");
        System.out.println("| 2.      Change lesson                      |");
        System.out.println("| 3.      Cancel lesson                      |");
        System.out.println("| 4.      Attend Lesson                      |");
        System.out.println("| 5.      Retrieve book list                 |");
        System.out.println("| 6.      Print monthly report               |");
        System.out.println("| 0.      Quit                               |");
        System.out.println("+--------------------------------------------+");

    }
}
