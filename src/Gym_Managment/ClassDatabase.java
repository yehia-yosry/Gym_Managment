package Gym_Managment;

import java.util.*;
import java.io.*;

public abstract class ClassDatabase extends Database {

    private ArrayList<Class> records = new ArrayList<>();
    String filename;

    public ClassDatabase(String filename) {
        this.filename = filename;
    }

    void readFromFile() {
        String line, separated[];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null) {
                separated = line.split(", ");
                Class obj = new Class(separated[0], separated[1], separated[2], Integer.parseInt(separated[3]), Integer.parseInt(separated[4]));
                records.add(obj);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Class createRecordFrom(String line) {
        String[] separated = line.split(", ");
        Class obj = new Class(separated[0], separated[1], separated[2], Integer.parseInt(separated[3]), Integer.parseInt(separated[4]));
        return obj;
    }

    ArrayList<Class> returnAllRecords() {
        return records;
    }

    boolean contains(String key) {
        for (Class obj : records) {
            if (key.equals(obj.getSearchKey())) {
                return true;
            }
        }
        return false;
    }

    Class getRecord(String key) {
        for (Class obj : records) {
            if (key.equals(obj.getSearchKey())) {
                return obj;
            }
        }
        return null;
    }

    void insertRecord(Class record) {
        if (contains(record.getSearchKey())) {
            System.out.println("Class Already Exists, Operation Failed...");
        } else {
            records.add(record);
        }
    }

    void deleteRecord(String key) {
        if (contains(key)) {
            for (Class obj : records) {
                if (key.equals(obj.getSearchKey())) {
                    records.remove(obj);
                }
            }
        } else {
            System.out.println("Class Does Not Exist, Operation Failed...");
        }
    }

    void saveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false));
            for (Class obj : records) {
                String[] separated = obj.lineRepresentation().split(", ");
                writer.write(separated[0] + ", " + separated[1] + ", " + separated[2] + ", " + separated[3] + ", " + separated[4] + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
