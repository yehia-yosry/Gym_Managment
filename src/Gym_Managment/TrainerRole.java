package Gym_Managment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class TrainerRole {

    private MemberDatabase memberDatabase = new MemberDatabase("Members.txt");
    private ClassDatabase classDatabase = new ClassDatabase("Class.txt");
    private MemberClassRegistrationDatabase registrationDatabase = new MemberClassRegistrationDatabase("Registration.txt");

    public TrainerRole() {

    }

    void addMember(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        Member obj = new Member(memberID, name, membershipType, email, phoneNumber, status);
        memberDatabase.insertRecord(obj);
    }

    ArrayList<Member> getListOfMembers() {
        return memberDatabase.returnAllRecords();
    }

    void addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {
        Class obj = new Class(classID, className, trainerID, duration, maxParticipants);
        classDatabase.insertRecord(obj);
    }

    ArrayList<Class> getListOfClasses() {
        return classDatabase.returnAllRecords();
    }

    boolean registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {
        if (!memberDatabase.contains(memberID)) {
            System.out.println("Member Not Registered, Operation Failed...");
            return false;
        }
        if (!classDatabase.contains(classID)) {
            System.out.println("Class Not Found, Operation Failed...");
            return false;
        }
        if (classDatabase.getRecord(classID).getAvailableSeats() == 0) {
            System.out.println("No Available Seats, Operation Failed...");
            return false;
        }

        registrationDatabase.insertRecord(registrationDatabase.createRecordFrom(memberID + ", " + classID + ", " + "active"));
        int count = classDatabase.getRecord(classID).getAvailableSeats();
        classDatabase.getRecord(classID).setAvailableSeats(count - 1);
        return true;
    }

    boolean cancelRegistration(String memberID, String classID) {
        if (!registrationDatabase.contains(memberID + classID)) {
            System.out.println("Class Registration Not Found, Operation Failed...");
            return false;
        }
        LocalDate prev = registrationDatabase.getRecord(memberID + classID).getRegistrationDate();
        LocalDate now = LocalDate.now();
        long timePassed = ChronoUnit.DAYS.between(prev, now);
        if (Math.abs(timePassed) > 3) {
            System.out.println("Registration Cancellation Time Limit Exceeded, Operation Failed...");
            return false;
        }
        registrationDatabase.deleteRecord(memberID + classID);
        int count = classDatabase.getRecord(classID).getAvailableSeats();
        classDatabase.getRecord(classID).setAvailableSeats(count + 1);
        return true;
    }

    ArrayList<MemberClassRegistration> getListOfRegistrations() {
        return registrationDatabase.returnAllRecords();
    }

    void logout() {
        memberDatabase.saveToFile();
        classDatabase.saveToFile();
        registrationDatabase.saveToFile();
    }
}
