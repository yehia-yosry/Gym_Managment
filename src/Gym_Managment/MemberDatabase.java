package Gym_Managment;

import java.util.*;
import java.io.*;

public abstract class MemberDatabase extends Database {

    private ArrayList<Member> records = new ArrayList<>();
    String filename;

    public MemberDatabase(String filename) {
        this.filename = filename;
    }

    void readFromFile() {
        String line, separated[];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null) {
                separated = line.split(", ");
                Member obj = new Member(separated[0], separated[1], separated[2], separated[3], separated[4], separated[5]);
                records.add(obj);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Member createRecordFrom(String line) {
        String[] separated = line.split(", ");
        Member obj = new Member(separated[0], separated[1], separated[2], separated[3], separated[4], separated[5]);
        return obj;
    }

    ArrayList<Member> returnAllRecords() {
        return records;
    }

    boolean contains(String key) {
        for (Member obj : records) {
            if (key.equals(obj.getSearchKey())) {
                return true;
            }
        }
        return false;
    }

    Member getRecord(String key) {
        for (Member obj : records) {
            if (key.equals(obj.getSearchKey())) {
                return obj;
            }
        }
        return null;
    }

    void insertRecord(Member record) {
        if (contains(record.getSearchKey())) {
            System.out.println("Member Already Exists, Operation Failed...");
        } else {
            records.add(record);
        }
    }

    void deleteRecord(String key) {
        if (contains(key)) {
            for (Member obj : records) {
                if (key.equals(obj.getSearchKey())) {
                    records.remove(obj);
                }
            }
        } else {
            System.out.println("Member Does Not Exist, Operation Failed...");
        }
    }

    void saveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false));
            for (Member obj : records) {
                String[] separated = obj.lineRepresentation().split(", ");
                writer.write(separated[0] + ", " + separated[1] + ", " + separated[2] + ", " + separated[3] + ", " + separated[4] + separated[5] + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
