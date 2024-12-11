module com.example.proiecttema5ppoo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens com.example.proiecttema5ppoo to javafx.fxml;
    exports com.example.proiecttema5ppoo;
}