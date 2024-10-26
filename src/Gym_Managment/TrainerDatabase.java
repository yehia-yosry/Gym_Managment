package Gym_Managment;

import java.util.*;
import java.io.*;

public class TrainerDatabase extends Database {

    private ArrayList<Trainer> records = new ArrayList<>();
    String filename;

    public TrainerDatabase(String filename) {
        this.filename = filename;
    }

    void readFromFile() {
        String line, separated[];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null) {
                separated = line.split(", ");
                Trainer obj = new Trainer(separated[0], separated[1], separated[2], separated[3], separated[4]);
                records.add(obj);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Trainer createRecordFrom(String line) {
        String[] separated = line.split(", ");
        Trainer obj = new Trainer(separated[0], separated[1], separated[2], separated[3], separated[4]);
        return obj;
    }

    ArrayList<Trainer> returnAllRecords() {
        return records;
    }

    boolean contains(String key) {
        for (Trainer obj : records) {
            if (key.equals(obj.getSearchKey())) {
                return true;
            }
        }
        return false;
    }

    Trainer getRecord(String key) {
        for (Trainer obj : records) {
            if (key.equals(obj.getSearchKey())) {
                return obj;
            }
        }
        return null;
    }

    void insertRecord(Trainer record) {
        if (contains(record.getSearchKey())) {
            System.out.println("Trainer Already Exists, Operation Failed...");
        } else {
            records.add(record);
        }
    }

    void deleteRecord(String key) {
        if (contains(key)) {
            records.remove(getRecord(key));

        } else {
            System.out.println("Trainer Does Not Exist, Operation Failed...");
        }
    }

    void saveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false));
            for (Trainer obj : records) {
                String[] separated = obj.lineRepresentation().split(", ");
                writer.write(separated[0] + ", " + separated[1] + ", " + separated[2] + ", " + separated[3] + ", " + separated[4] + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
