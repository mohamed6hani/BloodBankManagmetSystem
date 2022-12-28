package com.example.bloodbankmanagmetsystem;

public class doctor extends Person{
    doctor(String email, String password){
        super(email,  password);

    };
    private int DocID;
    private String hospital;
    private String doctorlogin = "SELECT count(1) FROM Doctor WHERE Doctor_email = '" +this.email+ "' AND Doctor_password = '" +this.password+ "'";

    public String getdoctorlogin(){
        return doctorlogin;
    };
}
