package Admin;

import java.util.*;

public class AdminRole {

    private TrainerDatabase obj;

    public AdminRole() {

    }

    void addTrainer(String trainerId, String name, String email, String specialty, String phoneNumber) {
        Trainer obj1 = new Trainer(trainerId, name, email, specialty, phoneNumber);
        obj.insertRecord(obj1);
    }

    ArrayList<Trainer> getListOfTrainers() {
        return obj.returnAllRecords();
    }

    void removeTrainer(String key) {
        obj.deleteRecord(key);
    }

    void logout() {
        obj.saveToFile();
    }
}
