/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.reservas;

import edu.espol.modelos.Habitacion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author famil
 */
public class HabitacionController implements Initializable {

    @FXML
    private Button btnConsultar;
    @FXML
    private TextField txtnumeroHabitacion;
    @FXML
    private ComboBox<String> cboHotel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cboHotel.getItems().addAll(Habitacion.hotels);
    }    
    
}
