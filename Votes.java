package rts;

import java.io.*;
import java.util.ArrayList;

public class Votes implements Serializable {
    private String Name,UName;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public Votes(){

    }

    public Votes(String N,String uName){
        Name = N;
        UName = uName;

    }




}
