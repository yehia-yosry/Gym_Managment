package Gym_Managment;

import java.util.*;

abstract class Database {

    abstract void readFromFile();

    abstract ArrayList returnAllRecords();

    abstract boolean contains(String key);

    abstract void deleteRecord(String key);

    abstract void saveToFile();
}
