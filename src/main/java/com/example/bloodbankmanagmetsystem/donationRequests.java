package com.example.bloodbankmanagmetsystem;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class donationRequests {

    /*Add the strings and buttons to be used in the application*/
    String id, name, age, bloodGroup,unit,hospitalName,gender,date;

    Button approve;


    /* Constructors */
    public donationRequests(String id, String name, String age, String bloodGroup, String unit, String hospitalName, String gender, String date, Button approve) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.approve = approve;
        this.approve.setText("Donate");
        this.unit = unit;
        this.hospitalName = hospitalName;
        this.gender = gender;
        this.date = date;

        approve.setOnAction(e -> {
            ObservableList<donationRequests> requestDonate = UserControllerClass.table_info_app.getSelectionModel().getSelectedItems();

            for (donationRequests user : requestDonate) {
                if (user.getApprove() == approve) {
                    System.out.println("id: " + user.getId());
                    System.out.println("name: " + user.getName());
                    System.out.println("age: " + user.getAge());
                    System.out.println("bloodGroup: " + user.getBloodGroup());
                    System.out.println("unit: " + user.getUnit());
                    System.out.println("gender: " + user.getGender());
                    System.out.println("hospitalName: " + user.getHospitalName());
                    System.out.println("date: " + user.getDate());
                }
            }
        });
    }

    /* Getters and setters */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Button getApprove() {
        return approve;
    }
    public String getDate() {
        return date;
    }

    public String getUnit() {
        return unit;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setApprove(Button approve) {
        this.approve = approve;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
