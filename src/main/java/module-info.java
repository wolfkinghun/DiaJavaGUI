module com.example.diagui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.diagui to javafx.fxml;
    exports com.example.diagui;
}