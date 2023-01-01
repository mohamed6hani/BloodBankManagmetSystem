package com.example.bloodbankmanagmetsystem;

import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;

public class user extends Person{
    user(String email, String password){
        super(email, password);
    }
    private int age;
    private char gender;
    private String ssn;
    private String userlogin = "SELECT count(1) FROM user WHERE user_email = '"+email+"' AND user_password = '" +password+"'";

    public user() {

    }

    public String getuserlogin(){
        return userlogin;
    };

    public boolean UserCreateAcc(String Name, String email, String password, String phonenum, String gender ){

        DB db=new DB();
        Connection con = db.getConnection();
        try{
            String userCreateAcc= "INSERT INTO user VALUES ('"+Name+"', '"+email+"', '"+password+"','"+gender+"','"+phonenum+"')";
            Statement stmt =con.createStatement();
            stmt.executeUpdate(userCreateAcc);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return false;
    }

}
