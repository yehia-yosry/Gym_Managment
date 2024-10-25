package Gym_Managment;

public class Member extends Identity {

    private String memberID, name, membershipType, email, phoneNumber, status;

    public Member(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        this.memberID = memberID;
        this.name = name;
        this.membershipType = membershipType;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    String lineRepresentation() {
        String data = String.join(", ", memberID, name, membershipType, email, phoneNumber, status);
        return data;
    }

    String getSearchKey() {
        return memberID;
    }

}
