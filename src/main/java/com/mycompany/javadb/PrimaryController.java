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
    private Button insert; 
    @FXML
    private Button update; 
    @FXML
    private Button delete; 
    @FXML
    private Button search; 


    @FXML
    private void handleInsertButton() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("insert.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) insert.getScene().getWindow();
        stage.setScene(scene);
    }
    
    @FXML
    private void handleDeleteButton() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("delete.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) delete.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void handleUpdateButton() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("update.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) update.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void handleSearchButton() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("search.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) search.getScene().getWindow();
        stage.setScene(scene);
    }
}