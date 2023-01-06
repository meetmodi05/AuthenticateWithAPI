package com.example.authenticatewithapi;

import java.util.ArrayList;

public class RegistraionModel {
    private String fname;
    private String lname;
    public ArrayList<RegistraionModel> registrationModelArrayList;

    public ArrayList<RegistraionModel> getRegistrationModelArrayList() {
        return registrationModelArrayList;
    }

    public void setRegistrationModelArrayList(ArrayList<RegistraionModel> registrationModelArrayList) {
        this.registrationModelArrayList = registrationModelArrayList;
    }

    public RegistraionModel(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

}
