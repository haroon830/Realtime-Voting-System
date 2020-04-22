package rts;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class NewUser implements Serializable{

    //public NewUser(String firstName, String lastName, String City, String Address, int age, String username, String password) {
//        super(firstName, lastName, City, Address, age);
//        this.username = username;
//        this.password = password;
//    }

    private String username, password;

    public NewUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public NewUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void display() {
        System.out.println("NewUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}');
    }


}