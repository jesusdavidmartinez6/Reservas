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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
    @FXML
    private FlowPane panelHabitacion;
    @FXML
    private VBox panel1;
    @FXML
    private VBox panel2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cboHotel.getItems().addAll(Habitacion.hotels);
    }
    @FXML
    public void consultarHabitacion(){
        panelHabitacion.getChildren().clear();
        panel1.getChildren().clear();
        panel2.getChildren().clear();
        Boolean existe=false;
        for (Habitacion p: Habitacion.habitaciones){
            if (p.getNumeroHabitacion().equalsIgnoreCase(txtnumeroHabitacion.getText())&& p.getNombreHotel().equals("Sonesta")){
                Label lblmensaje=new  Label("El numero de habitacion existe");
                panelHabitacion.getChildren().addAll(lblmensaje);
                existe=true;
            }
      
        }
        if (existe==false){  
        
            TextField precio1=new TextField();
            TextField servicios1=new TextField();
            ComboBox categoria1=new ComboBox();
            categoria1.getItems().addAll(Habitacion.categorias);
            Label precio=new  Label("Precio");
            Label servicios=new  Label("Servicio");
            Label categoria=new Label("Categoria");
            panel2.getChildren().addAll(precio1,servicios1,categoria1);
            panel1.getChildren().addAll(precio,servicios,categoria);
            panelHabitacion.getChildren().addAll(panel1,panel2);
            
        }
    }
    
}
