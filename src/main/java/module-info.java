module com.example.practicacuatrojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practicacuatrojavafx to javafx.fxml;
    exports com.example.practicacuatrojavafx;
}