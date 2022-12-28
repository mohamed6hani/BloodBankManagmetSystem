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
    private int patientAge;
    private char patientGender;
    //private int requestID;
    private boolean urgent;
    private int amount;

    //methods

    public boolean addRequest(String docName, LocalDate date, String bloodType, String location, String patientName, int patientAge,
                           char patientGender, boolean urgent, int amount){

        DB db = new DB();
        Connection con = db.getConnection();
        String placeRequest = "INSERT INTO BloodRequests VALUES('"+docName+"','"+bloodType+"', '"+date+"', '"+location+"', "+amount+", '"+patientName+"','"+patientGender+"', "+patientAge+", "+urgent+")";

        try {
            Statement stmt = con.createStatement();
            ResultSet queryResult = stmt.executeQuery(placeRequest);

           // requestLabel.setText("Request Successfully added");
            System.out.println("Success");
            con.close();
            return true;


        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return false;

    };



    public void displayToUser(String docName, LocalDate date, String bloodType, String location, String patientName, int patientAge,
                              char patientGender, boolean urgent, int amount){

    };







}
