package Gym_Managment;

import java.util.*;
import java.io.*;

public class MemberClassRegistrationDatabase extends Database {

    private ArrayList<MemberClassRegistration> records = new ArrayList<>();
    String filename;

    public MemberClassRegistrationDatabase(String filename) {
        this.filename = filename;
    }

    void readFromFile() {
        String line, separated[];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null) {
                separated = line.split(", ");
                MemberClassRegistration obj = new MemberClassRegistration(separated[0], separated[1], separated[3]);
                records.add(obj);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    MemberClassRegistration createRecordFrom(String line) {
        String[] separated = line.split(", ");
        MemberClassRegistration obj = new MemberClassRegistration(separated[0], separated[1], separated[2]);
        return obj;
    }

    ArrayList<MemberClassRegistration> returnAllRecords() {
        return records;
    }

    boolean contains(String key) {
        for (MemberClassRegistration obj : records) {
            if (key.equals(obj.getMemberID() + obj.getClassID()))  {
                return true;
            }
        }
        return false;
    }

    MemberClassRegistration getRecord(String key) {
        for (MemberClassRegistration obj : records) {
            if (key.equals(obj.getMemberID() + obj.getClassID())) {
                return obj;
            }
        }
        return null;
    }

    void insertRecord(MemberClassRegistration record) {
        if (contains(record.getMemberID() + record.getClassID())) {
            System.out.println("Registration Already Exists, Operation Failed...");
        } else {
            records.add(record);
        }
    }

    void deleteRecord(String key) {
        if (contains(key)) {
            records.remove(getRecord(key));
        } else {
            System.out.println("Registration Does Not Exist, Operation Failed...");
        }
    }

    void saveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false));
            for (MemberClassRegistration obj : records) {
                String[] separated = obj.lineRepresentation().split(", ");
                writer.write(separated[0] + ", " + separated[1] + ", " + separated[2] + ", " + separated[3] + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
