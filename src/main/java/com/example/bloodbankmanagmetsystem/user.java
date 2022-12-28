package com.example.bloodbankmanagmetsystem;

public class user extends Person{
    user(String email, String password){
        super(email, password);
    }
    private int age;
    private char gender;
    private String ssn;
    private String userlogin = "SELECT count(1) FROM user WHERE user_email = '"+email+"' AND user_password = '" +password+"'";

    public String getuserlogin(){
        return userlogin;
    };
    


}
