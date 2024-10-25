package Gym_Managment;

public class Trainer extends Identity{

    private String trainerId, name, email, speciality, phoneNumber;

    public Trainer(String trainerId, String name, String email, String speciality, String phoneNumber) {
        this.trainerId = trainerId;
        this.name = name;
        this.email = email;
        this.speciality = speciality;
        this.phoneNumber = phoneNumber;
    }

    String lineRepresentation() {
        String data = String.join(", ", trainerId, name, email, speciality, phoneNumber);
        return data;
    }

    String getSearchKey() {
        return trainerId;
    }
}
