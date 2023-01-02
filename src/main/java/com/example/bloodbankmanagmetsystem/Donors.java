package com.example.bloodbankmanagmetsystem;

public class Donors {
    Donors(String Name, String email, String bloodType, String status, String chronicIllness, String lastDonation){
        this.Name = Name;
        this.email = email;
        this.bloodType = bloodType;
        this.status = status;
        this.chronicIllness= chronicIllness;
        this.lastDonation = lastDonation;
    }
    String Name, email, bloodType, chronicIllness, lastDonation, status;
   // String status = "pending";
    public String getName(){return Name;}
    public String getEmail(){return email;}
    public String getBloodType(){return bloodType;}
    public String getChronicIllness(){return chronicIllness;}
    public String getLastDonation(){return lastDonation;}
    public String getStatus(){return status;}

    public void setStatus(String s){this.status = s;}




}
