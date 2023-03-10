module com.example.ftm {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;


    opens com.example.ftm to javafx.fxml;
    exports com.example.ftm;
}