package rts;

/*
 * @author haroon
 */
public class Person{
    private String firstName, lastName,City,Address;
    private int age;

    public Person() {
    }

    public Person(String firstName, String lastName, String City, String Address, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.City = City;
        this.Address = Address;
        this.age = age;
    }  

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    


}
