package Gym_Managment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public abstract class TrainerRole extends Role{
    
    private MemberDatabase obj1;
    private ClassDatabase obj2;
    private MemberClassRegistrationDatabase obj3;
    
    public TrainerRole() {
        
    }
    
    void addMember(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        Member obj = new Member(memberID, name, membershipType, email, phoneNumber, status);
        obj1.insertRecord(obj);
    }
    
    ArrayList<Member> getListOfMembers() {
        return obj1.returnAllRecords();
    }
    
    void addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {
        Class obj = new Class(classID, className, trainerID, duration, maxParticipants);
        obj2.insertRecord(obj);
    }
    
    ArrayList<Class> getListOfClasses() {
        return obj2.returnAllRecords();
    }
    
    boolean registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {
        if (!obj1.contains(memberID)) {
            System.out.println("Member Not Registered, Operation Failed...");
            return false;
        }
        if (!obj2.contains(classID)) {
            System.out.println("Class Not Found, Operation Failed...");
            return false;
        }
        if (obj2.getRecord(classID).getAvailableSeats() == 0) {
            System.out.println("No Available Seats, Operation Failed...");
            return false;
        }
        
        obj3.insertRecord(obj3.createRecordFrom(memberID + ", " + classID + "active"));
        int count = obj2.getRecord(classID).getAvailableSeats();
        obj2.getRecord(classID).setAvailableSeats(count - 1);
        return true;
    }
    
    boolean cancelRegistration(String memberID, String classID) {
        if (!obj3.contains(memberID.concat(classID))) {
            System.out.println("Class Registration Not Found, Operation Failed...");
            return false;
        }
        LocalDate prev = obj3.getRecord(memberID).getRegistrationDate();
        LocalDate now = LocalDate.now();
        long timePassed = ChronoUnit.DAYS.between(prev, now);
        if (Math.abs(timePassed) > 3) {
            System.out.println("Registration Cancellation Time Limit Exceeded, Operation Failed...");
            return false;
        }
        obj3.deleteRecord(classID);
        int count = obj2.getRecord(classID).getAvailableSeats();
        obj2.getRecord(classID).setAvailableSeats(count + 1);
        return true;
    }
    
    ArrayList<MemberClassRegistration> getListOfRegistrations() {
        return obj3.returnAllRecords();
    }
    
    void logout() {
        obj1.saveToFile();
        obj2.saveToFile();
        obj3.saveToFile();
    }
    
}
