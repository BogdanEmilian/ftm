module com.example.ftm {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires jakarta.persistence;


    opens com.example.ftm to javafx.fxml, javafx.base;
    opens com.example.ftm.entity to javafx.base, javafx.fxml;
    exports com.example.ftm;
    exports com.example.ftm.entity;
}