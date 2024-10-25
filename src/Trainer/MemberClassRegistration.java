package Trainer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MemberClassRegistration {

    private String memberID, classID, status;
    private LocalDate registrationDate;

    public MemberClassRegistration(String memberID, String classID, String status) {
        this.memberID = memberID;
        this.classID = classID;
        this.status = status;
        this.registrationDate = LocalDate.now();
    }

    String getMemberID() {
        return memberID;
    }

    String getClassID() {
        return classID;
    }

    LocalDate getRegistrationDate() {
        return registrationDate;
    }

    String getSearchKey() {
        return memberID.concat(classID);
    }

    String lineRepresentation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String data = String.join(", ", memberID, classID, registrationDate.format(formatter));
        return data;
    }

}
