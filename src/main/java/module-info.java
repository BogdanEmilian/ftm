module com.example.ftm {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ftm to javafx.fxml;
    opens com.example.ftm.controllers to javafx.fxml;
    exports com.example.ftm;
}