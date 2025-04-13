package com.mycompany.javadb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
          Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds(); 

    scene = new Scene(loadFXML("primary"),
                      screenBounds.getWidth(),
                      screenBounds.getHeight());

    stage.setScene(scene);
    stage.setX(screenBounds.getMinX());
    stage.setY(screenBounds.getMinY());
    stage.setWidth(screenBounds.getWidth());
    stage.setHeight(screenBounds.getHeight());

    stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Connected to database successfully!");
                launch(args);
            } else {
                System.out.println("❌ Database connection failed: Connection was null.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed: " + e.getMessage());
        }
        
    }
}