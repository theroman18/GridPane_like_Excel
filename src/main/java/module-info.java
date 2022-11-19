module com.example.scrollpanetest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.scrollpanetest to javafx.fxml;
    exports com.example.scrollpanetest;
}