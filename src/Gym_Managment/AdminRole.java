package Gym_Managment;

import java.util.*;

public class AdminRole {

    private TrainerDatabase database = new TrainerDatabase("Trainers.txt");

    public AdminRole() {

    }

    void addTrainer(String trainerId, String name, String email, String specialty, String phoneNumber) {
        Trainer obj1 = new Trainer(trainerId, name, email, specialty, phoneNumber);
        database.insertRecord(obj1);
    }

    ArrayList<Trainer> getListOfTrainers() {
        return database.returnAllRecords();
    }

    void removeTrainer(String key) {
        database.deleteRecord(key);
    }

    void logout() {
        database.saveToFile();
    }
}
