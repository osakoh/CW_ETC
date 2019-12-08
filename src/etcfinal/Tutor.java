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
public class Tutor {

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    private String name;
    private String subject;
    private String availableTime;
    private int slot;
    private ArrayList<Student> students = new ArrayList<>();
    private String notes;

    public Tutor(String name, String subject, String availableTime, int slot) {
        this.name = name;
        this.subject = subject;
        this.availableTime = availableTime;
        this.slot = slot;
    }
    
    public Tutor(){}

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @return the availableTime
     */
    public String getAvailableTime() {
        return availableTime;
    }
    
     /**
     * @return the slot
     */
    public int getSlot() {
        return slot;
    }
    
    public boolean slotAvailable() {
        return students.size() < getSlot();
    }
    
//    public String availablility() {
//        if (students.size() > getSlot()){
//            System.out.println("Booked");
//        } else if (students.size() < getSlot()){
//            System.out.println(getSlot() + " slots available");
//        } else {
//            System.out.println("Available");
//        }
//            return "";
//    }
    
    public void registerStudent(Student stud) {
        students.add(stud);
        
    }
    
    public void eraseStudent (Student stud) {
        students.remove(stud);
    }
        
    public int remainingSlots(){
       return students.size();
    }
    
//    public boolean isSubject(String sub){
//        
//    }
    
    @Override
    public String toString(){
        return subject;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public static void setNotes() {
        Scanner scan = new Scanner(System.in);
           String write = scan.nextLine();
    }
    
}

