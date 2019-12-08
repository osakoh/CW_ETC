/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etcfinal;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Osas
 */
public class LessonTest {


    public LessonTest() {}
    
    
    

    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addStudent method of class Lesson.
     */
    @Test
    public void testAddStudent() {
        System.out.println("Test to addStudent to list");
        
        Lesson instance = new Lesson(); // creates an instance of lesson
         // counts the size of student array
        int beforeAddCount = Lesson.students.size();        
        Student std = new Student("James", "Male", "10/02/1996", "College Lane", 0721102, 0271102);
        
        instance.addStudent(std);
        
        // counts the size of student array after an element(std) have been added
        int afterAddCount = Lesson.students.size();
        assertEquals(beforeAddCount + 1, afterAddCount);
    }

    /**
     * Test of isTutor method, of class Lesson.
     */
    @Test
    public void testIsTutor() {
        System.out.println("Test isTutor");
        // creates Tutor tut
        Tutor tut = new Tutor("Steve", "Maths", "10:00AM - 11:00AM", 3);       
        Lesson instance = new Lesson(); // instance of Lesson class
        instance.addTutor(tut); // adds tut to the tutor arraylist
        boolean expResult = true; // tutor has been added
        
        boolean result = instance.isTutor(tut); // checks if tut is in arraylist
        assertEquals(expResult, result);
    }

    /**
     * Test of isStudent method, of class Lesson.
     */
    @Test
    public void testIsStudent() {
        System.out.println("Test isStudent");
        Lesson instance = new Lesson();
        // creates student s
        Student s = new Student("Jill", "Female", "10/02/1996", "College Lane", 0721102, 0271102);
        instance.addStudent(s); // adds student              
        boolean expResult = true;
        
        boolean result = Lesson.isStudent(s); 
        assertEquals(expResult, result); // checks if s has been added as a student
    }

    /**
     * Test of studentHasBooked method, of class Lesson.
     */
    @Test
    public void testStudentHasBooked() {
        System.out.println("Test studentHasBooked");
        Student stud = new Student("James", "Male", "10/02/1996", "College Lane", 0721102, 0271102);
        Lesson instance = new Lesson();

        instance.addStudent(stud); // books student
        boolean expected = true;
        
        // checks if stud is in list of students
        boolean result = Lesson.isStudent(stud);
        assertEquals(expected,result);
    }

    /**
     * Test of removeLesson method, of class Lesson.
     */
    @Test
    public void testRemoveLesson() {
        System.out.println("Test removeLesson");          
        
        // creates Student stud
        Student student = new Student("Paul", "Male", "10/02/1996", "College Lane", 0721102, 0271102);
        // creates Tutor tut
        Tutor tut = new Tutor("Steve", "Maths", "10:00AM - 11:00AM", 3);        
        
        Tutor instance = new Tutor(); // instance of Tutor
        
        instance.registerStudent(student); // adds student
        // checks if student has booked a lesson
        boolean afterBooking = Lesson.isStudent(student); 

        instance.eraseStudent(student); // cancels lesson
         // checks if stud is still in list of students
        boolean afterCancelling = Lesson.isStudent(student);
        assertEquals(afterBooking, afterCancelling);  
    }

}

