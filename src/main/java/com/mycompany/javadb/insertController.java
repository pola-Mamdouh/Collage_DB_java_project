package com.mycompany.javadb;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertController {

    @FXML
    private Button backButton;

    @FXML
    private Button insertButton;

    @FXML
    private ComboBox<String> tableSelector;

    @FXML
    private TextField idField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField phoneField;

    @FXML
    public void initialize() {
        if (tableSelector.getItems().isEmpty()) {
            tableSelector.getItems().addAll("student", "instractor", "course", "department");
            tableSelector.setValue("student");
    }
}


    @FXML
    private void handleBackButton() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void handleInsertButton() {
        String selectedTable = tableSelector.getValue();

        if ("student".equals(selectedTable)) {
            insertIntoStudents();
        } else if ("instractor".equals(selectedTable)) {
            insertIntoInstractor();
        } else if ("course".equals(selectedTable)) {
            // وهكذا
        }
    }

    private void insertIntoStudents() {
        String sql = "INSERT INTO student (student_id, first_name, last_name, phone) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, Integer.parseInt(idField.getText()));
            pstmt.setString(2, firstNameField.getText());
            pstmt.setString(3, lastNameField.getText());
            pstmt.setString(4, phoneField.getText());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println(" Inserted successfully into students!");
                clearFields();
            }

        } catch (SQLException | NumberFormatException e) {
            System.out.println(" Error inserting data: " + e.getMessage());
        }
    }
        private void insertIntoInstractor() {
        String sql = "INSERT INTO instractor (instractor_id, first_name, last_name, phone) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, Integer.parseInt(idField.getText()));
            pstmt.setString(2, firstNameField.getText());
            pstmt.setString(3, lastNameField.getText());
            pstmt.setString(4, phoneField.getText());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println(" Inserted successfully into students!");
                clearFields();
            }

        } catch (SQLException | NumberFormatException e) {
            System.out.println(" Error inserting data: " + e.getMessage());
        }
    }
    private void insertIntoCourse() {
        String sql = "INSERT INTO course (student_id, first_name, last_name, phone) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, Integer.parseInt(idField.getText()));
            pstmt.setString(2, firstNameField.getText());
            pstmt.setString(3, lastNameField.getText());
            pstmt.setString(4, phoneField.getText());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println(" Inserted successfully into students!");
                clearFields();
            }

        } catch (SQLException | NumberFormatException e) {
            System.out.println(" Error inserting data: " + e.getMessage());
        }
    }


    private void clearFields() {
        idField.clear();
        firstNameField.clear();
        lastNameField.clear();
        phoneField.clear();
    }
}
