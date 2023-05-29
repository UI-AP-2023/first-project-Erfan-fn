module com.example.javafxproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxproject to javafx.fxml;
    opens com.example.model.Stuff to javafx.fxml;
    opens com.example.model.UserModelFacilities to javafx.fxml;
    exports com.example.javafxproject;
    exports com.example.model.Stuff;
    exports com.example.model.UserModelFacilities;
}