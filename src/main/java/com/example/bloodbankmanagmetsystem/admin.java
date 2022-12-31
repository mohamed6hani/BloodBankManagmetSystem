package com.example.bloodbankmanagmetsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class admin extends Person {
    admin(String email, String password) {
        super(email, password);
        this.adminID = adminID;
    }

    admin(String Name, int adminID, String email, String phonenum) {
        super(email);
        this.Name = Name;
        this.adminID = adminID;
        this.phonenum = phonenum;


    }
    admin(){

    }

    private int adminID;
    private String viewadm = "SELECT * FROM admin ";
    private String viewdoc = "SELECT * FROM Doctor ";
    private String adminlogin = "SELECT count(1) FROM admin WHERE admin_email = '" + email + "' AND admin_password = '" + password + "'";

    //----------getters----------
    //public String getemail(){return email;}
    public String getphonenum() {
        return phonenum;
    }

    public int getAdminID() {
        return adminID;
    }

    public String getName() {
        return Name;
    }

    public String getadminlogin() {
        return adminlogin;
    }

    ;

    public String getViewadm() {
        return viewadm;
    }

    ;

    public String getViewdoc() {
        return viewdoc;
    }

    ;

    //-------------setters
    public void setAdminID() {
        this.adminID = adminID;
    }

    public void setName() {
        this.Name = Name;
    }

    public void setphonenum() {
        this.phonenum = phonenum;
    }




    //-------------methods
    public void viewAdmins() {
        DB db = new DB();
        Connection con = db.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet queryResult = stmt.executeQuery(getViewadm());
            while(queryResult.next());

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }


    public void viewDoctors () {}

}


