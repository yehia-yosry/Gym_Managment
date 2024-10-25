package Gym_Managment;

import java.util.ArrayList;

public abstract class Role {

    abstract void addTrainer(String trainerId, String name, String email, String specialty, String phoneNumber);

    abstract ArrayList getListOfTrainers();

    abstract void removeTrainer(String key);

    abstract void logout();
}
