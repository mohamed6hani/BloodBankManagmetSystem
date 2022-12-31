package com.example.bloodbankmanagmetsystem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;


public class bloodRequest {

    //attributes
    private String docName;
    private LocalDate date;
    private String bloodType;
    private String location;
    private String patientName;
    private String patientAge;
    private String patientGender;
    private boolean urgent;
    private int amount;

    //methods

    public void addRequest(LocalDate date, String bloodType, String location, String patientName, String patientAge,
                           String patientGender, int urgent, int amount){

        DB db = new DB();
        Connection con = db.getConnection();
        String placeRequest = "INSERT INTO BloodRequests (BloodType, date, location, amount_in_units, patient_name, patient_gender, patient_age, urgent) VALUES ('"+bloodType+"', '"+date+"', '"+location+"', "+amount+", '"+patientName+"','"+patientGender+"', "+patientAge+", "+urgent+")";

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(placeRequest);
            con.close();



        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    };


    public void displayToUser(LocalDate date, String bloodType, String location, String patientName, int patientAge,
                              char patientGender, boolean urgent, int amount){

    };


}