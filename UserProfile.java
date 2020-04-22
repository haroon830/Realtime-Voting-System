package rts;

public class UserProfile {
    protected String name,city,gender,cnic;
    protected int age;

    public UserProfile() {
    }

    public UserProfile(String name, String city, String gender, String cnic, int age) {
        this.name = name;
        this.city = city;
        this.gender = gender;
        this.cnic = cnic;
        this.age = age;
    }


}
