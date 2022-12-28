package com.example.bloodbankmanagmetsystem;

public class admin extends Person{
    admin(String email, String password){
        super(email, password);
    }
    private int adminID;

    private String adminlogin = "SELECT count(1) FROM admin WHERE admin_email = '"+email+"' AND admin_password = '" +password+"'";
    public String getadminlogin(){
        return adminlogin;
    };
}
