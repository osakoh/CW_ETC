/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etcfinal;

import java.util.ArrayList;

/**
 *
 * @author Osas
 */
public class Student {
           
    private String name;
    private String gender;
    private String dob;
    private String address;
    private long emergContact;
    private long phoneNo;
    static int bookedLesson = 0;
    static int cancelledLesson = 0;
    private ArrayList<Lesson> lesson;
    private ArrayList<String> textBook;
    

    public Student(String name, String gender, String dob, String address, long emergContact, long phoneNo) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.emergContact = emergContact;
        this.phoneNo = phoneNo;
    }

    /**
     * @return the bookedLesson
     */
    public int getBookedLesson() {
        return bookedLesson;
    }

    /**
     * @param bookedLesson the bookedLesson to set
     */
    public void setBookedLesson(int bookedLesson) {
        this.bookedLesson = bookedLesson;
    }

    /**
     * @return the cancelledLesson
     */
    public int getCancelledLesson() {
        return cancelledLesson;
    }

    /**
     * @param cancelledLesson the cancelledLesson to set
     */
    public void setCancelledLesson(int cancelledLesson) {
        this.cancelledLesson = cancelledLesson;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return the emergContact
     */
    public long getEmergContact() {
        return emergContact;
    }

    /**
     * @return the phoneNo
     */
    public long getPhoneNo() {
        return phoneNo;
    }

    /**
     * @return the lesson
     */
    public ArrayList<Lesson> getLesson() {
        return lesson;
    }
    
    public void studentDetails(){
        System.out.println("Name:              " + getName());
        System.out.println("Gender:            " + getGender());
        System.out.println("Date of birth:     " + getDob());
        System.out.println("Address:           " + getAddress());
        System.out.println("Emergency contact: " + getEmergContact());
        System.out.println("Phone number:      " + getPhoneNo());
        System.out.println("Booked lesson:     " + getBookedLesson());
    }
    
    
    @Override
    public String toString(){
        return name;
    }
    
    public void addTextBook(String b){
        textBook.add(b);
    }
    
}

