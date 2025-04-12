package com.mycompany.javadb;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PrimaryController {

    @FXML
    private Button insert; // تأكد من أن fx:id لزر الإدراج هو "insert"

    @FXML
    private void handleInsertButton() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("insert.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) insert.getScene().getWindow();
        stage.setScene(scene);
    }
}