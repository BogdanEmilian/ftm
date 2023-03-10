module com.example.ftm {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires jakarta.persistence;


    opens com.example.ftm to javafx.fxml;
    exports com.example.ftm;
}