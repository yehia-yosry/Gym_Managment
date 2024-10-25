package Trainer;

public class Class {

    private String classID, className, trainerID;
    private int duration, availableSeats;

    public Class(String classID, String className, String trainerID, int duration, int availableSeats) {
        this.classID = classID;
        this.className = className;
        this.trainerID = trainerID;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    int getAvailableSeats() {
        return availableSeats;
    }

    void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    String lineRepresentation() {
        String data = String.join(", ", classID, className, trainerID, String.valueOf(duration), String.valueOf(availableSeats));
        return data;
    }

    String getSearchKey() {
        return classID;
    }

}
