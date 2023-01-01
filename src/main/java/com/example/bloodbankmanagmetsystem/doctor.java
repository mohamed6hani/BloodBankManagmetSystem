package com.example.bloodbankmanagmetsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class doctor extends Person {
    doctor(String email, String password) {
        super(email, password);

    }
    doctor(){}

    ;
    private String DocID;
    private String hospital;

    private String doctorlogin = "SELECT count(1) FROM Doctor WHERE Doctor_email = '" + this.email + "' AND Doctor_password = '" + this.password + "'";

    public String getdoctorlogin(){return doctorlogin;}



    public boolean DocCreateAcc(String DocID,String Name, String email, String password, String hospital, String phonenum){

        DB db=new DB();
        Connection con = db.getConnection();
        try{
            String docCreateAcc= "INSERT INTO doctor VALUES ('"+DocID+"', '"+Name+"', '"+email+"', '"+password+"', '"+hospital+"','"+phonenum+"')";
            Statement stmt =con.createStatement();
            stmt.executeUpdate(docCreateAcc);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return false;
    }
}





