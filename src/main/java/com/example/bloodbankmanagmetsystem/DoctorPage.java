package com.example.bloodbankmanagmetsystem;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class DoctorPage extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DoctorPage.class.getResource("DoctorPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("DoctorPage");
        stage.setScene(scene);
        stage.show();
    }
}
