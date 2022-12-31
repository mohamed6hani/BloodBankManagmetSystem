package com.example.bloodbankmanagmetsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class doctor extends Person {
    doctor(String email, String password) {
        super(email, password);

    }

    ;
    private int DocID;
    private String hospital;
    private String doctorlogin = "SELECT count(1) FROM Doctor WHERE Doctor_email = '" + this.email + "' AND Doctor_password = '" + this.password + "'";
    public void verify_doc_Login(String dlogin){

        DB db=new DB();
        Connection
        try{
            con=db.getConnection();
            Statement stmt=con.createStatement();
            stmt.executeUpdate(sql:"INSERT INTO doctors(Doctor_id,Doctor_name,Doctor_email,Doctor_password,Doctor_Hospital,Doctor_phonenum");
        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}





