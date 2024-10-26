package Gym_Managment;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        AdminRole admin = new AdminRole();
        
        admin.addTrainer("T1001", "Ibrahim", "Ibrahim@gmail.com", "Fitness", "0102348754");
        admin.addTrainer("T1002", "Mahmoud", "Mahmoud@gmail.com", "Bodybuilding", "0102348754");
        admin.addTrainer("T1003", "Mostafa", "Mostafa@gmail.com", "Calisthenics", "0102348754");
        admin.addTrainer("T1004", "Essam", "Essam@gmail.com", "Aerobics", "0102348754");
                
        admin.removeTrainer("T1002");
        admin.logout();

        TrainerRole trainer = new TrainerRole();
        
        trainer.addMember("M1001", "Omar", "Premium", "Omar@gmail.com", "0102348754", "Active");
        trainer.addMember("M1002", "Ali", "Monthly", "Ali@gmail.com", "0102348754", "Active");
        trainer.addMember("M1003", "Osama", "Yearly", "Osama@gmail.com", "0102348754", "Active");

        trainer.addClass("C101", "Bodubuilding", "T1001", 60, 20);
        trainer.addClass("C102", "Calisthenics", "T1002", 15, 3);
        trainer.addClass("C103", "Fitness", "T1003", 30, 5);

        
        trainer.registerMemberForClass("M1001", "C101", LocalDate.now());
        trainer.registerMemberForClass("M1002", "C102", LocalDate.now());
        trainer.registerMemberForClass("M1003", "C103",  LocalDate.now());

        trainer.cancelRegistration("M1001", "C101");
        trainer.cancelRegistration("M1003", "C103");
        trainer.logout();
    }
}
