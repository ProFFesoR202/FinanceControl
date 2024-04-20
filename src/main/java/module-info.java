module com.example.financecontrol {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.financecontrol to javafx.fxml;
    exports com.example.financecontrol;
}