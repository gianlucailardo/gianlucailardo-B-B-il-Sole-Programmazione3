module com.example.progettobbilsole {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires mysql.connector.java;
    opens com.example.Models to javafx.fxml;
    exports com.example.Models;
    exports DataBase;
    opens DataBase to javafx.fxml;
    exports com.example.Controllers;
    opens com.example.Controllers to javafx.fxml;
}