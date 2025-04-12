module com.mycompany.javadb {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.microsoft.sqlserver.jdbc;
    requires java.sql;
    opens com.mycompany.javadb to javafx.fxml;
    exports com.mycompany.javadb;
}