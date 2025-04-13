package com.mycompany.javadb;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

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
    private Pane coursePane;

    @FXML
    private TextField courseId;

    @FXML
    private TextField courseName;

    @FXML
    private TextField courseDuration;

    @FXML
    private Pane departmentPane;

    @FXML
    private TextField departmentName;

    @FXML
    private TextField departmentLocation;

    @FXML
    public void initialize() {
        if (tableSelector.getItems().isEmpty()) {
            tableSelector.getItems().addAll("student", "instractor", "course", "department");
            tableSelector.setValue("student");
            updateFieldsVisibility("student"); // Initialize visibility
        }

        tableSelector.setOnAction(event -> {
            String selectedTable = tableSelector.getValue();
            updateFieldsVisibility(selectedTable);
        });
    }

    private void updateFieldsVisibility(String selectedTable) {
        boolean isCourseSelected = "course".equals(selectedTable);
        boolean isDepartmentSelected = "department".equals(selectedTable);

        // Visibility of Student/Instructor fields
        boolean isStudentOrInstructor = "student".equals(selectedTable) || "instractor".equals(selectedTable);
        if (idField != null) idField.setVisible(isStudentOrInstructor);
        if (firstNameField != null) firstNameField.setVisible(isStudentOrInstructor);
        if (lastNameField != null) lastNameField.setVisible(isStudentOrInstructor);
        if (phoneField != null) phoneField.setVisible(isStudentOrInstructor);

        // Visibility of Course Pane
        if (coursePane != null) {
            coursePane.setVisible(isCourseSelected);
            coursePane.setManaged(isCourseSelected);
        }

        // Visibility of Department Pane
        if (departmentPane != null) {
            departmentPane.setVisible(isDepartmentSelected);
            departmentPane.setManaged(isDepartmentSelected);
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
            insertIntoCourse();
        } else if ("department".equals(selectedTable)) {
            insertIntoDepartment();
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
                System.out.println("Inserted successfully into students!");
                clearFields();
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error inserting into students: " + e.getMessage());
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
                System.out.println("Inserted successfully into instractor!");
                clearFields();
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error inserting into instractor: " + e.getMessage());
        }
    }

    private void insertIntoCourse() {
        String sql = "INSERT INTO course (course_id, course_name, duration) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(courseId.getText()));
            pstmt.setString(2, courseName.getText());
            pstmt.setString(3, courseDuration.getText());
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Inserted successfully into course!");
                clearFields();
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error inserting into course: " + e.getMessage());
        }
    }

    private void insertIntoDepartment() {
        String sql = "INSERT INTO department (department_name, location) VALUES (?, ?)"; // Adjust columns based on your table
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, departmentName.getText());
            pstmt.setString(2, departmentLocation.getText()); // Assuming you have a location field
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Inserted successfully into department!");
                clearFields();
            }
        } catch (SQLException e) {
            System.out.println("Error inserting into department: " + e.getMessage());
        }
    }

    private void clearFields() {
        if (idField != null) idField.clear();
        if (firstNameField != null) firstNameField.clear();
        if (lastNameField != null) lastNameField.clear();
        if (phoneField != null) phoneField.clear();
        if (courseId != null) courseId.clear();
        if (courseName != null) courseName.clear();
        if (courseDuration != null) courseDuration.clear();
        if (departmentName != null) departmentName.clear();
        if (departmentLocation != null) departmentLocation.clear();
    }
}