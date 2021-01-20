/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.reservas;

import edu.espol.modelos.Habitacion;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    @FXML
    private HBox HboxMensaje;

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
        HboxMensaje.getChildren().clear();
        Boolean existe=false;
        for (Habitacion p: Habitacion.habitaciones){
            if (p.getNumeroHabitacion().equalsIgnoreCase(txtnumeroHabitacion.getText())&& p.getNombreHotel().equals("Sonesta")){
                Label lblmensaje=new  Label("El numero de habitacion existe");
                TextField nombre1=new TextField(p.getNombreHotel());
                TextField numero1=new TextField(p.getNumeroHabitacion());
                TextField precio1=new TextField(p.getPrecio());
                TextField servicios1=new TextField(p.getServicio());
                TextField categoria1=new TextField(p.getCategoria());
                Label nombre=new  Label("Nombre del Hotel");
                Label numero=new  Label("Numero del Hotel");
                Label precio=new  Label("Precio");
                Label servicios=new  Label("Servicio");
                Label categoria=new Label("Categoria");
                HboxMensaje.getChildren().add(lblmensaje);
                panel2.getChildren().addAll(nombre1,numero1,precio1,servicios1,categoria1);
                panel1.getChildren().addAll(nombre,numero,precio,servicios,categoria);
                panelHabitacion.getChildren().addAll(panel1,panel2);
                existe=true;
            }
      
        }
        if (existe==false){  
            Label lblmensaje=new  Label("LA HABITACION NO EXISTE."); 
            HboxMensaje.getChildren().add(lblmensaje);
            TextField precio1=new TextField();
            TextField servicios1=new TextField();
            ComboBox categoria1=new ComboBox();
            categoria1.getItems().addAll(Habitacion.categorias);
            Label precio=new  Label("Precio");
            Label servicios=new  Label("Servicio");
            Label categoria=new Label("Categoria");
            Button btnGuardar=new Button("Guardar Información                                                                                                                                                                                ");
            btnGuardar.setOnAction(e->guardar(txtnumeroHabitacion,precio1,servicios1,categoria1));
            panel2.getChildren().addAll(precio1,servicios1,categoria1,btnGuardar);
            panel1.getChildren().addAll(precio,servicios,categoria);
            panelHabitacion.getChildren().addAll(panel1,panel2);
        }
    }
    public void guardar(TextField txtnumeroHabitacion,TextField precio, TextField servicio,ComboBox categoria){
        System.out.println("Sonesta");
        System.out.println(txtnumeroHabitacion.getText());
        System.out.println(precio.getText());
        System.out.println(servicio.getText());
        System.out.println(categoria.getValue());
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            String data = "Sonesta;"+txtnumeroHabitacion.getText()+";"+precio.getText()+";"+servicio.getText()+";"+categoria.getValue();
            File file = new File("src/main/resources/files/Habitacion.txt");
        // Si el archivo no existe, se crea!
        if (!file.exists()) {
            file.createNewFile();
        }
        // flag true, indica adjuntar información al archivo.
        fw = new FileWriter(file.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        bw.write(data);
        bw.newLine();
        System.out.println("información agregada!");
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        finally {
            try {//Cierra instancias de FileWriter y BufferedWriter
                if (bw != null)
                bw.close();
                if (fw != null)
                fw.close();
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    

   
}
