module edu.espol.reservas {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.espol.reservas to javafx.fxml;
    exports edu.espol.reservas;
}