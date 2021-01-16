package edu.espol.reservas;

import edu.espol.modelos.Habitacion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Habitacion"), 640, 480);
        stage.setTitle("Consulta Habitaciones");
        stage.setScene(scene);
        stage.show(); 
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        Habitacion.llenarHabitacion();
        System.out.println(Habitacion.habitaciones);
        System.out.println(Habitacion.hotels);
        launch();
    }

}